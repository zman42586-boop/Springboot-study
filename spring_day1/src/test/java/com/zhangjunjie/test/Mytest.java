package com.zhangjunjie.test;

import com.zhangjunjie.Service.UserServiceImpl;
import com.zhangjunjie.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String[] args) {
        //获取spring的上下文对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //Spring管理对象
//        Object hello = context.getBean("hello");
//        System.out.println(hello.toString());
        UserServiceImpl userServiceImpl = context.getBean("ServiceImpl",UserServiceImpl.class);
        userServiceImpl.getUser();

        User user = context.getBean("User", User.class);
        user.show();
    }
}
