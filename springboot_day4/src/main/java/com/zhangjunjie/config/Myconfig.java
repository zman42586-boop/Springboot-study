package com.zhangjunjie.config;

import com.zhangjunjie.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Myconfig2.class})
//这个相当于beans.xml
public class Myconfig {
    //这个相当于bean标签
    //方法的名字相当于是id
    //方法的返回值相当于是bean标签中的class属性
    @Bean
    public User getUser(){
        return new User();
    }
}
