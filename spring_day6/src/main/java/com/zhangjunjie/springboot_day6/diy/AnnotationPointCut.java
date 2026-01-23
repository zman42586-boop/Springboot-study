package com.zhangjunjie.springboot_day6.diy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect//标注这个类是一个切面
public class AnnotationPointCut {
    @Before("execution(* com.zhangjunjie.springboot_day6.Service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("before");
    }
    @After("execution(* com.zhangjunjie.springboot_day6.Service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("after");
    }
    @Around("execution(* com.zhangjunjie.springboot_day6.Service.UserServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前");
        Object proceed = joinPoint.proceed();
        System.out.println(joinPoint.getSignature());
        System.out.println("环绕后");
        return proceed;
    }
}
