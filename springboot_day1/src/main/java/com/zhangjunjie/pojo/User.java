package com.zhangjunjie.pojo;

public class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public void show(){
        System.out.println("username is : "+username);
    }
}
