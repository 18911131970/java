package cn;

import cn.entity.Customer;
import cn.entity.LinkMan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by yangzhe on 17/4/14.
 */
public class Hibernate {



    @Test
    public void mudifyDemo(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction ts = null;

        try {
            sessionFactory = HibernateTool.getSessionFactory();
            session = HibernateTool.getSession();
            ts = session.beginTransaction();

            Customer customer = session.get(Customer.class,"1");
            LinkMan linkMan = session.get(LinkMan.class,2);
            customer.getSetLinkMan().add(linkMan);
            linkMan.setCustomer(customer);


            ts.commit();
        }catch (Exception e){
            ts.rollback();
        }finally {
            sessionFactory.close();
        }

    }

    @Test
    public void deleteDemo(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction ts = null;

        try {
            sessionFactory = HibernateTool.getSessionFactory();
            session = HibernateTool.getSession();
            ts = session.beginTransaction();

            Customer customer = session.get(Customer.class,"1");
            session.delete(customer);

            ts.commit();
        }catch (Exception e){
            ts.rollback();
        }finally {
            sessionFactory.close();
        }

    }

    @Test
    public void addDemo(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction ts = null;

        try {
            sessionFactory = HibernateTool.getSessionFactory();
            session = HibernateTool.getSession();
            ts = session.beginTransaction();

            Customer customer = new Customer();
            customer.setCustName("huawei");

            LinkMan linkMan = new LinkMan();
            linkMan.setLk_name("zhangsan");

            LinkMan linkMan1 = new LinkMan();
            linkMan.setLk_name("lisi");


            customer.getSetLinkMan().add(linkMan);
            customer.getSetLinkMan().add(linkMan1);

            linkMan.setCustomer(customer);

            session.save(customer);
            session.save(linkMan);

            ts.commit();
        }catch (Exception e){
            ts.rollback();
        }finally {
            sessionFactory.close();
        }
    }
}
