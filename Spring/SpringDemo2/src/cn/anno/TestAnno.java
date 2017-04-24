package cn.anno;

import cn.xmlAnno.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yangzhe on 2017/4/21.
 */
public class TestAnno {


    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        BookService bookService = (BookService)context.getBean("bookService");
        bookService.add();

    }

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = (UserService)context.getBean("userService");

        userService.add();

    }

    @Test
    public void testUser(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User)context.getBean("user");
        System.out.println(user);
        user.test();

        User user1 = (User)context.getBean("user");
        System.out.println(user1);

    }

}
