package com.agg.yingxue.administrators.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.HashMap;

@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver {
    @Override
    @SneakyThrows
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        HashMap<String, String> resultMap = new HashMap<>();
        resultMap.put("msg", ex.getMessage());

        // 转换json工具
        ObjectMapper mapper = new ObjectMapper();

        // 响应json串
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");

        if (ex instanceof IllegalPasswordException) {
            response.setStatus(HttpStatus.SC_FORBIDDEN);
        }else {
            response.setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }

        mapper.writeValue(response.getWriter(),resultMap);
        return new ModelAndView();
    }
}
