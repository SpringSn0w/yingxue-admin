package com.agg.yingxue.category;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.agg.yingxue.category.dao")
public class CategoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(CategoryApplication.class);
    }
}
