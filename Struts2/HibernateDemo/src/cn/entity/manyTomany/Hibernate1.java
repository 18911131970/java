package cn.entity.manyTomany;

import cn.HibernateTool;
import cn.entity.Customer;
import cn.entity.LinkMan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by yangzhe on 17/4/14.
 */
public class Hibernate1 {


    @Test
    //多对多的
    public void mudifyDemo(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction ts = null;

        try {
            sessionFactory = HibernateTool.getSessionFactory();
            session = HibernateTool.getSession();
            ts = session.beginTransaction();
            //某个用户具有某个角色
            User lucy = session.get(User.class,1);
            Role role = session.get(Role.class,1);
            lucy.getSetRole().add(role);

            //某个用户删除某个角色
            User lili = session.get(User.class,2);
            lili.getSetRole().remove(role);




            ts.commit();
        }catch (Exception e){
            ts.rollback();
        }finally {
            sessionFactory.close();
        }

    }

    @Test
    //多对多的
    public void deleteDemo(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction ts = null;

        try {
            sessionFactory = HibernateTool.getSessionFactory();
            session = HibernateTool.getSession();
            ts = session.beginTransaction();


            ts.commit();
        }catch (Exception e){
            ts.rollback();
        }finally {
            sessionFactory.close();
        }

    }


    @Test
    //多对多的
    public void addDemo(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction ts = null;

        try {
            sessionFactory = HibernateTool.getSessionFactory();
            session = HibernateTool.getSession();
            ts = session.beginTransaction();

            User user = new User();
            user.setUser_name("lucy");
            user.setUser_password("123");


            User user1 = new User();
            user1.setUser_name("asan");
            user1.setUser_password("456");

            //3种角色
            Role role = new Role();
            role.setRole_name("xcode");
            role.setRole_memo("oc");

            Role role1 = new Role();
            role1.setRole_name("xcode1");
            role1.setRole_memo("oc1");

            Role role2 = new Role();
            role2.setRole_name("xcode2");
            role2.setRole_memo("oc2");


            // user->role/role1
            user.getSetRole().add(role);
            user.getSetRole().add(role1);
            //user2->r1/r2
            user1.getSetRole().add(role1);
            user1.getSetRole().add(role2);

            session.save(user);
            session.save(user1);

            ts.commit();
        }catch (Exception e){
            ts.rollback();
        }finally {
            sessionFactory.close();
        }

    }

}
