package com.dao;

import com.entity.Customer;
import com.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * Created by yangzhe on 2017/5/2.
 */
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

//    @Override
//    public void add(Customer customer) {
//       this.getHibernateTemplate().save(customer);
//    }


//    @Override
//    public List<Customer> findAll() {
//
//        List<Customer> list = ( List<Customer>)this.getHibernateTemplate().find("from Customer");
//        return list;
//    }

//    @Override
//    public Customer findOne(Integer cid) {
//        Customer customer = this.getHibernateTemplate().get(Customer.class,cid);
//        return customer;
//    }

//    @Override
//    public void delete(Customer customer) {
//        this.getHibernateTemplate().delete(customer);
//    }

//    @Override
//    public void updata(Customer customer) {
//        this.getHibernateTemplate().update(customer);
//    }

    @Override
    public Integer findCount() {
        List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count (*) from Customer");
        if (list != null && list.size() != 0) {
            Object obj = list.get(0);
            Long lobj = (Long) obj;
            int count = lobj.intValue();
            return count;
        }
        return 0;
    }

    /*分页查询*/
    @Override
    public List<Customer> findPage(Integer begin, Integer pageSize) {
//        SessionFactory sessionFactory = this.getSessionFactory();
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("from Customer");
//        query.setFirstResult(begin);
//        query.setMaxResults(pageSize);
//        List<Customer> list = query.list();

        //
        //创建离线对象，设置对哪个实体类进行操作
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);

        //调用hibernageTemplate方法实现
        List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
        return list;
    }

    /*条件查询*/
    @Override
    public List<Customer> findCondition(Customer customer) {
        //第一种方法
//        SessionFactory sessionFactory = this.getSessionFactory();
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("from Customer where cname = ?");
//        query.setParameter(0,"%" + customer.getCname() + "%");
//        List<Customer> list = query.list();

        //第二种方式
//        List<Customer> list = (List<Customer>)this.getHibernateTemplate().
//                find("from Customer where cname like ?","%"+customer.getCname()+"%");

        //第三种方法
        //创建离线对象，设置对哪个实体类进行操作
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
        //设置实体类属性
        criteria.add(Restrictions.like("cname", "%" + customer.getCname() + "%"));
        //调用hibernateTemplate方法中的方法查询
        List<Customer> list = (List<Customer>) this.getHibernateTemplate().
                findByCriteria(criteria);

        return list;

    }


    /*多条件查询  根据客户的姓名／电话等信息查询 */
    public List<Customer> findCondition1(Customer customer) {

        String hql = "from Customer where 1=1";

        List<Object> p = new ArrayList<Object>();

        //如果条件不为空
        if (customer.getCname() != null && "".equals(customer.getCname())) {
            hql += " and cname=?";
            //把值设置到list中去
            p.add(customer.getCname());
        }

        //有条件 进行拼接
        if (customer.getCphone() != null && "".equals(customer.getCphone())) {
            hql += " and cphone=?";
            p.add(customer.getCphone());


        }
        return (List<Customer>) this.getHibernateTemplate().find(hql, p.toArray());

    }


    //使用离线对象的方式实现多条件查询
    public List<Customer> findCondition2(Customer customer) {
        //创建离线对象  指定对哪个实体类操作
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(customer.getClass());
        //判断条件值是否为空
        //如果条件不为空
        if (customer.getCname() != null && "".equals(customer.getCname())) {
            //设置条件
            detachedCriteria.add(Restrictions.eq("cname",customer.getCname()));
        }

        //有条件 进行拼接
        if (customer.getCphone() != null && "".equals(customer.getCphone())) {
            detachedCriteria.add(Restrictions.eq("cphone",customer.getCphone()));
        }

        return (List<Customer>)this.getHibernateTemplate().findByCriteria(detachedCriteria);
    }
}
