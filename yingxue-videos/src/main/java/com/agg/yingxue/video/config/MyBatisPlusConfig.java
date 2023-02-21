package com.agg.yingxue.video.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisPlusConfig {
    
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        PaginationInnerInterceptor interceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        //设置请求的页面大于最大页后操作， true调回到首页， 默认false
        interceptor.setOverflow(true);
        //设置单页限制
        interceptor.setMaxLimit(500L);
        //开启count的join优化，只针对部分left join
        interceptor.setOptimizeJoin(true);
        
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(interceptor);
        
        return mybatisPlusInterceptor;
    }
}
 