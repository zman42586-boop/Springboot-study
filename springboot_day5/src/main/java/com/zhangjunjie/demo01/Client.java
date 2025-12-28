package com.zhangjunjie.demo01;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

public class Client {
    public static void main(String[] args) {
        Proxy proxy1 = new Proxy(new Host());
        proxy1.rent();
        proxy1.seeHouse();
        proxy1.fare();
    }
}
