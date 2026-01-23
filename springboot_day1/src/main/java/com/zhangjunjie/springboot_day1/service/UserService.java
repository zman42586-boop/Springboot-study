package com.zhangjunjie.springboot_day1.service;

import com.zhangjunjie.springboot_day1.pojo.User;

public interface UserService {
    User findByUserName(String userName);
    void register(String username, String password);
    void update(User user);
    void updateAvatar(String avatarUrl);
    void updatePwd(String newPwd);
}
