package com.service;

import com.dao.CustomerDao;
import com.entity.Customer;
import com.entity.PageBean;
import com.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yangzhe on 2017/5/2.
 */
@Transactional
public class CustomerService {

    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    /*添加功能*/
    public void add(Customer customer) {
        customerDao.add(customer);
    }

    public List<Customer> findCustomers(){
        return customerDao.findAll();
    }

    public void delete(Customer customer){
        customerDao.delete(customer);
    }

    public Customer findOne(Integer cid){
        return customerDao.findOne(cid);
    }

    public void updata(Customer customer){
        customerDao.update(customer);
    }

    //封装分页的数据到pageBean中
    public PageBean listpage(Integer currentPage){
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(currentPage);

        int totalCount = customerDao.findCount();
        pageBean.setTotalCount(totalCount);

        int pageSize = 3 ;
        pageBean.setPageSize(pageSize);

        //总页数
        int totalPage = 0;
        if (totalCount % pageSize == 0){ //整除
            totalPage = totalCount / pageSize;
        } else  {
            totalPage = totalCount / pageSize + 1;
        }
        pageBean.setTotalePage(totalPage);

        //开始位置
        int begin = (currentPage - 1) * pageSize;
        pageBean.setBegin(begin);
        //每一页list数据
        List<Customer> list = ( List<Customer>)customerDao.findPage(begin,pageSize);
        pageBean.setList(list);

        return pageBean;
    }

    public List<Customer> findCondition(Customer customer){

        return customerDao.findCondition(customer);

    }
}

