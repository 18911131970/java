package com.dao;

import com.entity.User;
import org.springframework.orm.hibernate3.HibernateTemplate;

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
}
