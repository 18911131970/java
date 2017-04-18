package cn.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangzhe on 17/4/14.
 */
public class Customer {

    private Integer custid;
    private String custName;

    private Set<LinkMan> setLinkMan = new HashSet<LinkMan>();

    public void setSetLinkMan(Set<LinkMan> setLinkMan) {
        this.setLinkMan = setLinkMan;
    }

    public Set<LinkMan> getSetLinkMan() {

        return setLinkMan;
    }

    public void setCustid(Integer custid) {
        this.custid = custid;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Integer getCustid() {

        return custid;
    }

    public String getCustName() {
        return custName;
    }
}
