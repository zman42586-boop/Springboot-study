package com.zhangjunjie.springboot_day6.Service;

public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("增加了用户");
    }

    @Override
    public void delete() {
        System.out.println("删除了用户");
    }

    @Override
    public void change() {
        System.out.println("修改了用户");
    }

    @Override
    public void query() {
        System.out.println("查找了用户");
    }
}
