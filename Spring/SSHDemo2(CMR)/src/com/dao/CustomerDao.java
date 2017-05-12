package com.dao;

import com.entity.Customer;
import com.entity.User;

import java.util.List;

/**
 * Created by yangzhe on 2017/5/2.
 */
public interface CustomerDao extends BaseDao<Customer> {
//    public void add(Customer customer);
//    public List<Customer> findCustomers();
//    public Customer findOne(Integer cid);
//    public void delete(Customer customer);
//    public void updata(Customer customer);
    public Integer findCount();
    public List<Customer> findPage(Integer begin,Integer pageSize);
    List<Customer> findCondition(Customer customer);
}
