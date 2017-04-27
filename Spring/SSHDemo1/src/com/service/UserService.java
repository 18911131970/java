package com.service;

import com.dao.UserDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yangzhe on 2017/4/26.
 */
@Transactional
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("UserService------add");
        userDao.add();
    }

    public void get(){
        userDao.get();
    }
}
