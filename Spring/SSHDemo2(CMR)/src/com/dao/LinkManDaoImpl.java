package com.dao;

import com.entity.LinkMan;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * Created by yangzhe on 2017/5/3.
 */
public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

    @Override
    public void addLinkMan(LinkMan linkMan) {
        this.getHibernateTemplate().save(linkMan);
    }
}
