package com.dao;

import com.entity.LinkMan;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by yangzhe on 2017/5/3.
 */
public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

    @Override
    public void addLinkMan(LinkMan linkMan) {
        this.getHibernateTemplate().save(linkMan);
    }

    @Override
    public List<LinkMan> listLinkMan() {
        List<LinkMan> list =  (List<LinkMan>)this.getHibernateTemplate().find("from  LinkMan");
        return list;
    }

    @Override
    public LinkMan findOne(int linkId) {
        LinkMan linkMan = this.getHibernateTemplate().get(LinkMan.class,linkId);
        return linkMan;
    }

    @Override
    public void updata(LinkMan linkMan) {
        this.getHibernateTemplate().update(linkMan);
    }

    @Override
    public void delete(LinkMan linkMan) {
        this.getHibernateTemplate().delete(linkMan);
    }
}
