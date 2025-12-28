package com.zhangjunjie.springboot_day4;

import com.zhangjunjie.config.Myconfig;
import com.zhangjunjie.config.Myconfig2;
import com.zhangjunjie.pojo.User;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class myTest {
    public static void main(String[] args) {
        //完全使用配置的方法，只能用AnnotationConfigApplicationContext
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Myconfig.class);
        User user = context.getBean("getUser", User.class);
        System.out.println(user.toString());

        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(Myconfig2.class);
        User user2 = context.getBean("getuser2", User.class);
        System.out.println(user2.toString());
    }
}
