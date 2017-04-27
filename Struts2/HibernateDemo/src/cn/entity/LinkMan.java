package cn.entity;

import cn.entity.Customer;

/**
 * Created by yangzhe on 17/4/14.
 */
public class LinkMan {

    private Integer lk_id;
    private String lk_name;
    private Customer customer;

    public void setLk_id(Integer lk_id) {
        this.lk_id = lk_id;
    }

    public void setLk_name(String lk_name) {
        this.lk_name = lk_name;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getLk_id() {

        return lk_id;
    }

    public String getLk_name() {
        return lk_name;
    }

    public Customer getCustomer() {
        return customer;
    }
}
