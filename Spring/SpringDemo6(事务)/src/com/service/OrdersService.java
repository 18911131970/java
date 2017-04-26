package com.service;

import com.dao.OrdersDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yangzhe on 2017/4/26.
 */
@Transactional
public class OrdersService {

    private OrdersDao ordersDao;
    public void setOrdersDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    //业务逻辑层
    public void accountMoney(){
        //少钱方法
        ordersDao.lessMoney();

        //多钱的方法
        ordersDao.moreMoney();

    }

}
