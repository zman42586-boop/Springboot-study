package com.zhangjunjie.springboot_day2;

import com.zhangjunjie.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest2_pcnamespace {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("UserBean.xml");
        User userBean = context.getBean("User1", User.class);
        System.out.println(userBean.toString());
    }
}
