package com.zhangjunjie.config;


import com.zhangjunjie.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Myconfig2 {
    @Bean
    public User getuser2(){
        return new User();
    }
}
