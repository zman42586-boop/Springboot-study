package com.Zhangjunjie.dao;

import com.Zhangjunjie.pojo.User;

import java.util.List;

public interface UserMapper {
    //查询
    List<User> getUserList();
    //根据ID查询用户
    User getUserById(int id);
    //增加用户
    void addUser(User user);
    //删除用户
    void deleteUserById(int id);
    //修改用户
    void updateUser(User user);
}
