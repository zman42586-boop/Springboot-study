//package com.zhangjunjie.springboot_day1;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//
//@SpringBootTest
//public class RedisTest {
//    @Autowired
//    private StringRedisTemplate template;
//    @Test
//    public void testSet(){
//        //存储键值对
//        ValueOperations<String, String> Operations = template.opsForValue();
//        Operations.set("username", "zhangsan");
//    }
//}
