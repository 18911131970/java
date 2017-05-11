package com.dao;

import java.util.List;

/**
 * Created by yangzhe on 2017/5/10.
 */
/*
* T 代表任意类型
* */
public interface BaseDao<T> {

    //添加
    public void add(T t);

    //更新
    public void update(T t);

    //删除
    public void delete(T t);

    //根据id查询
    public T findOne(Integer id);

    //查询所有
    public List<T> findAll();

}
