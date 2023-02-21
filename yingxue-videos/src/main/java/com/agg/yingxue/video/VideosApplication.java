package com.agg.yingxue.video;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@MapperScan("com.agg.yingxue.video.dao")
public class VideosApplication {
    public static void main(String[] args) {
        SpringApplication.run(VideosApplication.class, args);
    }
}
