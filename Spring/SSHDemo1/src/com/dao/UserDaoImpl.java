package com.dao;

import com.entity.User;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

/**
 * Created by yangzhe on 2017/4/26.
 */
public class UserDaoImpl implements UserDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void add() {
        System.out.println("UserDaoImpl------add");
        User user = new User();
        user.setUsername("yangzhe");
        user.setAddress("beijing");
        hibernateTemplate.save(user);
    }

    @Override
    public void get() {
        User user = hibernateTemplate.get(User.class,1);
        System.out.println(user);

        List<User> list = (List<User>)hibernateTemplate.find("from User");
        System.out.println(list);

        List<User> list1 = (List<User>)hibernateTemplate.find("from User where username = ?","yangzhe");
        System.out.println(list1);

    }
}
