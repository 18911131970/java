package cn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by yangzhe on 17/4/14.
 */
public class HibernateTool {

    private static Configuration configuration = null;
    private static SessionFactory sessionFactory = null;
    private static Session session = null;
    static {
        configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.getCurrentSession();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static Session getSession(){
        return session;
    }

    public static void main(String[] args){

    }

}
