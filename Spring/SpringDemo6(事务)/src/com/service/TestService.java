package com.service;

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
        OrdersService ordersService = (OrdersService)context.getBean("ordersService");
        ordersService.accountMoney();
    }

}
