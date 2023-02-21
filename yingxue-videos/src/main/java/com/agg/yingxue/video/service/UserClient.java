package com.agg.yingxue.video.service;

import com.agg.yingxue.video.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "yingxue-users",contextId = "userClient")
@RequestMapping("/user")
public interface UserClient {
    @GetMapping("selectByName/{name}")
    public List<User> queryByName(@PathVariable("name") String name);
    @GetMapping("userInfo/{uid}")
    public User getUser(@PathVariable("uid")Integer id);

}
