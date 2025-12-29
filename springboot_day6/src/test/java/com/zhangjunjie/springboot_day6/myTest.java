package com.zhangjunjie.springboot_day6;

import com.zhangjunjie.springboot_day6.Service.UserService;
import com.zhangjunjie.springboot_day6.Service.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.add();
    }
}
