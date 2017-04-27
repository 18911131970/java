package com.c3p0;

/**
 * Created by yangzhe on 2017/4/26.
 */
public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("UserService-----add");
        userDao.add();
    }
}
