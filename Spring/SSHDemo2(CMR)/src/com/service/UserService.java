package com.service;

import com.dao.UserDao;
import com.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yangzhe on 2017/5/2.
 */
@Transactional
public class UserService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public User login(User user){
        return userDao.loginUser(user);
    }

}
