package com.zhangjunjie.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component说明这个类被Spring接管了，放到容器中
@Component
public class User {

    private String name;

    public String getName() {
        return name;
    }
    @Value("QINJIANG")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
