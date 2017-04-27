package cn.aop;

import cn.xmlAnno.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yangzhe on 2017/4/24.
 */
public class TestAop {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Book book = (Book)context.getBean("book");
        book.add();
    }

}
