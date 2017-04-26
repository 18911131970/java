package com.c3p0;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yangzhe on 2017/4/26.
 */
public class TestService {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = (UserService)context.getBean("userService");
        userService.add();
    }
}
