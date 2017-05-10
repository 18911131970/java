package com.dao;

import com.entity.Customer;
import com.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;
import java.util.Queue;

/**
 * Created by yangzhe on 2017/5/2.
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

    @Override
    public void add(Customer customer) {
       this.getHibernateTemplate().save(customer);
    }

    @Override
    public List<Customer> findCustomers() {

        List<Customer> list = ( List<Customer>)this.getHibernateTemplate().find("from Customer");
        return list;
    }

    @Override
    public Customer findOne(Integer cid) {
        Customer customer = this.getHibernateTemplate().get(Customer.class,cid);
        return customer;
    }

    @Override
    public void delete(Customer customer) {
        this.getHibernateTemplate().delete(customer);
    }

    @Override
    public void updata(Customer customer) {
        this.getHibernateTemplate().update(customer);
    }

    @Override
    public Integer findCount() {
        List<Object> list = (List<Object>)this.getHibernateTemplate().find("select count (*) from Customer");
        if (list != null && list.size() != 0){
            Object obj = list.get(0);
            Long lobj  = (Long)obj;
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
        List<Customer> list = (List<Customer>)this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
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
        criteria.add(Restrictions.like("cname","%"+customer.getCname()+"%"));
        //调用hibernateTemplate方法中的方法查询
        List<Customer> list = (List<Customer>)this.getHibernateTemplate().
                findByCriteria(criteria);

        return list;
    }
}
