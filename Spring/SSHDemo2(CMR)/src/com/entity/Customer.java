package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangzhe on 2017/5/2.
 */
public class Customer {
    private Integer cid;
    private String cname;
    private String caddress;
    private String cphone;


    //客户所有拜访记录
    private Set<Visit> setCustomerVisit = new HashSet<Visit>();

    public Set<Visit> getSetCustomerVisit() {
        return setCustomerVisit;
    }

    public void setSetCustomerVisit(Set<Visit> setCustomerVisit) {
        this.setCustomerVisit = setCustomerVisit;
    }

    private Set<LinkMan> setLinkMan = new HashSet<LinkMan>();

    public Set<LinkMan> getSetLinkMan() {
        return setLinkMan;
    }

    public void setSetLinkMan(Set<LinkMan> setLinkMan) {
        this.setLinkMan = setLinkMan;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }
}
