package com.dao;

import com.entity.LinkMan;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by yangzhe on 2017/5/3.
 */
public class LinkManDaoImpl extends BaseDaoImpl<LinkMan> implements LinkManDao {

//    @Override
//    public void addLinkMan(LinkMan linkMan) {
//        this.getHibernateTemplate().save(linkMan);
//    }
//
//    @Override
//    public List<LinkMan> listLinkMan() {
//        List<LinkMan> list =  (List<LinkMan>)this.getHibernateTemplate().find("from  LinkMan");
//        return list;
//    }
//
//    @Override
//    public LinkMan findOne(int linkId) {
//        LinkMan linkMan = this.getHibernateTemplate().get(LinkMan.class,linkId);
//        return linkMan;
//    }
//
//    @Override
//    public void updata(LinkMan linkMan) {
//        this.getHibernateTemplate().update(linkMan);
//    }
//
//    @Override
//    public void delete(LinkMan linkMan) {
//        this.getHibernateTemplate().delete(linkMan);
//    }

    //离线查询方式
    public List<LinkMan> findCondition(LinkMan linkMan){
        DetachedCriteria criteria = DetachedCriteria.forClass(linkMan.getClass());

        if (linkMan.getLkmName() != null && !(linkMan.getLkmName() != "")){
            criteria.add(Restrictions.eq("lkmName",linkMan.getLkmName()));
        }

        if (linkMan.getCustomer().getCid() != null && !(linkMan.getCustomer().getCid().equals(""))){
            criteria.add(Restrictions.eq("cid",linkMan.getCustomer().getCid()));
        }
        return (List<LinkMan> )this.getHibernateTemplate().findByCriteria(criteria);

    }

}
