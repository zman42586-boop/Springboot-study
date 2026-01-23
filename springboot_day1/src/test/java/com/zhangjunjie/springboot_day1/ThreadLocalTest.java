//package com.zhangjunjie.springboot_day1;
//
//import org.junit.jupiter.api.Test;
//
//public class ThreadLocalTest {
//    @Test
//    public void testThreadLocalSetAndGet() {
//        // 1. 提供一个 ThreadLocal 对象
//        // 它就像一个“线程保险箱”，每个线程只能存取属于自己的那份数据
//        ThreadLocal tl = new ThreadLocal();
//
//        // 2. 开启第一个线程：名为“蓝色”
//        new Thread(() -> {
//            tl.set("萧炎"); // 在当前线程存入数据
//            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
//            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
//            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
//        }, "蓝色").start();
//
//        // 3. 开启第二个线程：名为“绿色”
//        new Thread(() -> {
//            tl.set("药尘"); // 在当前线程存入数据，不会覆盖“蓝色”线程的数据
//            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
//            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
//            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
//        }, "绿色").start();
//    }
//}
