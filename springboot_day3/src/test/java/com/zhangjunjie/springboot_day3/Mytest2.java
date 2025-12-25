package com.zhangjunjie.springboot_day3;

import com.zhangjunjie.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user.name);
    }
}
