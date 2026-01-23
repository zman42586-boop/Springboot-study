package com.zhangjunjie.Service;

import com.zhangjunjie.DAO.UserDao;

public class UserServiceImpl implements Userservice{
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUserData();
    }
}
