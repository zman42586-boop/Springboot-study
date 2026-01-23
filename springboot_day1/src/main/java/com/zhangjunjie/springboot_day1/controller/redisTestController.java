package com.zhangjunjie.springboot_day1.controller;

import com.zhangjunjie.springboot_day1.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class redisTestController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/test")
    public Result testRedis() {
        // 1. 存数据
        stringRedisTemplate.opsForValue().set("mykey", "Hello Redis, I am runnning!");

        // 2. 取数据
        String value = stringRedisTemplate.opsForValue().get("mykey");

        // 3. 返回给浏览器看看
        return Result.success("从Redis取出的值是: " + value);
    }
}