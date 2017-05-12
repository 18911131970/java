package com.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by yangzhe on 2017/5/10.
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    private Class aClass;

    public BaseDaoImpl() {
        //得到当前运行类的class
        Class clazz = this.getClass();

        //得到当前类的父类的参数化类型BaseDaoImpl<Customer>
        Type type = clazz.getGenericSuperclass();
        ParameterizedType ptype = (ParameterizedType)type;

//        System.out.println("********************"+ptype);
        //得到实际的类型参数
        Type[] types = ptype.getActualTypeArguments();
        Class pclass  = (Class)types[0];
        this.aClass = pclass;

    }

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

        return (T) this.getHibernateTemplate().get(aClass,id);
    }

    @Override
    public List<T> findAll() {
        return (List<T>)this.getHibernateTemplate().find("from " + aClass.getSimpleName());
    }
}
