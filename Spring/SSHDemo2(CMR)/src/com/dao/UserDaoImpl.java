package com.dao;

import com.entity.User;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by yangzhe on 2017/5/2.
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    @Override
    public User loginUser(User user) {
        //调用方法获取hibernateTemplate对象
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        //登录的查询操作
        List<User> list = (List<User>)hibernateTemplate.find("from User where username=? and password=?",user.getUsername(),user.getPassword());
        if (list.size() != 0 && list != null ){
            return list.get(0);
        }

        return null;


    }

//    @Override
//    public List<User> findUsers() {
//
//        List<User> list = (List<User>)this.getHibernateTemplate().find("from User");
//        return list;
//    }
}
