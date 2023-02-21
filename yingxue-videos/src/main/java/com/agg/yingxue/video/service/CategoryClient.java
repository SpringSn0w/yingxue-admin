package com.agg.yingxue.video.service;

import com.agg.yingxue.video.dto.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "yingxue-category",contextId = "cateClient")
@RequestMapping("/category")
public interface CategoryClient {
    @GetMapping("selectOne/{id}")
    public Category queryById(@PathVariable("id") Integer id);
}
