package cn.ioc;

import cn.bean.bean2;
import cn.property.Person;
import cn.property.PropertyDemo1;
import cn.property.PropertyDemo2;
import cn.property.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yangzhe on 2017/4/20.
 */
public class TestIOC {

    @Test
    public void testUser(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        //得到配置创建的文件
        //xml文件中的id值
        User user = (User)context.getBean("user");
        User user1 = (User)context.getBean("user");

        user.add();
        System.out.println(user);
        System.out.println(user1);

        bean2 b = (bean2)context.getBean("bean2");
        b.add();

        bean2 b1 = (bean2)context.getBean("bean2");
        b1.add();

        PropertyDemo1 demo1 = (PropertyDemo1)context.getBean("propertyDemo1");
        demo1.test1();

        PropertyDemo2 demo2 = (PropertyDemo2)context.getBean("propertyDemo2");
        demo2.test1();

        UserService service = (UserService)context.getBean("userService");
        service.test1();

        Person person = (Person)context.getBean("person");
        person.test1();

        Person person2 = (Person)context.getBean("person2");
        person2.test2();
    }

}
