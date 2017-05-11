package com.action;

import com.entity.Customer;
import com.entity.User;
import com.entity.Visit;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CustomerService;
import com.service.UserService;
import com.service.VisitService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yangzhe on 2017/5/10.
 */
public class VisitAction extends ActionSupport implements ModelDriven {

    private VisitService visitService;
    public void setVisitService(VisitService visitService) {
        this.visitService = visitService;
    }

    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    //模型驱动
    private Visit visit = new Visit();
    @Override
    public Object getModel() {
        return visit;
    }

    public String toAddPage(){

        //查询所有的客户
        List<Customer> customerList = customerService.findCustomers();

        List<User> userList = userService.findUsers();

        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("customerList",customerList);
        request.setAttribute("userList",userList);

        return "toAddPage";
    }


    public String add(){
        visitService.add(visit);
        return "add";
    }


}
