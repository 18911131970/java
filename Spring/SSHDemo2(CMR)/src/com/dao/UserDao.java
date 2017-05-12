package com.dao;

import com.entity.User;

import java.util.List;

/**
 * Created by yangzhe on 2017/5/2.
 */
public interface UserDao extends BaseDao<User> {

    public User loginUser(User user);

//    List<User> findUsers();
}
