package com.zhangjunjie.springboot_day2;

import com.zhangjunjie.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = context.getBean("Student1",Student.class);
        System.out.println(student.toString());

    }
}
