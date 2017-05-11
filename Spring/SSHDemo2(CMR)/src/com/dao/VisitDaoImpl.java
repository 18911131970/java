package com.dao;

import com.entity.Visit;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * Created by yangzhe on 2017/5/10.
 */
public class VisitDaoImpl extends HibernateDaoSupport implements VisitDao {


    @Override
    public void add(Visit visit) {
        this.getHibernateTemplate().save(visit);
    }
}
