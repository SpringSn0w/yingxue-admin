package com.agg.yingxue.gatewat.filter;

import com.agg.yingxue.gatewat.exception.GlobalExceptionConfiguration;
import com.agg.yingxue.gatewat.exception.IllegalTokenException;
import com.alibaba.cloud.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 登录校验
 */
@Component
public class TokenGatewayFilterFactory extends AbstractGatewayFilterFactory<TokenGatewayFilterFactory.Config> {

    public TokenGatewayFilterFactory() {
        super(Config.class);
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                // 判断是否登录 （redis检查token对应标识）
                //1 从请求获取token
                String token = exchange.getRequest().getQueryParams().getFirst("token");
                if (StringUtils.isEmpty(token)){
                    throw new IllegalTokenException("无效的token");
                }
                //2 根据token参数从redis获取标识
                Boolean hasKey = redisTemplate.hasKey("TOKEN:" + token);
                if (Boolean.FALSE.equals(hasKey)) {
                    throw new IllegalTokenException("token失效");
                }

                //3 更新超时时间
                redisTemplate.expire("TOKEN"+token,30, TimeUnit.MINUTES);

                return chain.filter(exchange);
            }
        };
    }


    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("requiredToken");
    }

    public static class Config{
        private boolean requiredToken;

        public boolean isRequiredToken() {
            return requiredToken;
        }

        public void setRequiredToken(boolean requiredToken) {
            this.requiredToken = requiredToken;
        }
    }
}
