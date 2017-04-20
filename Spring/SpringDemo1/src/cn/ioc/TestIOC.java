package cn.ioc;

import cn.bean.bean2;
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
        user.add();

        bean2 b = (bean2)context.getBean("bean2");
        b.add();
    }

}
