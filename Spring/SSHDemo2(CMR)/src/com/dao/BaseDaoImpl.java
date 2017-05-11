package com.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by yangzhe on 2017/5/10.
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
    @Override
    public void add(T t) {
        this.getHibernateTemplate().save(t);
    }

    @Override
    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    @Override
    public void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }

    @Override
    public T findOne(Integer id) {
//        this.getHibernateTemplate().get()
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }
}
