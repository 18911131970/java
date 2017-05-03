package com.action;

import com.entity.Customer;
import com.entity.PageBean;
import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CustomerService;
import org.apache.struts2.ServletActionContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangzhe on 2017/5/2.
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private CustomerService customerService;
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    private List<Customer> list = new ArrayList<Customer>();
    public List<Customer> getList() {
        return list;
    }

    //模型驱动
    private Customer customer = new Customer();
    public Customer getCustomer() {
        return customer;
    }


    @Override
    public Customer getModel() {
        return customer;
    }




    private Integer currentPage;
    public Integer getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    //表达式封装
    private PageBean pageBean = new PageBean();
    public PageBean getPageBean() {
        return pageBean;
    }
    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }


    public String add(){
        if (customer != null){
            customerService.add(customer);
            list = customerService.findCustomers();
            return "addSuccess";
        } else  {
            return "add";
        }
    }

    public String find(){

        list = customerService.findCustomers();
        return "list";
    }

    public String delete(){

        Customer deleteCustomer = customerService.findOne(customer.getCid());
        if (deleteCustomer != null) {
            customerService.delete(deleteCustomer);
        }
        return "deleteSuccess";
    }

    public String show(){
        customer = customerService.findOne(customer.getCid());
        return "show";
    }


    public String modify(){
        customerService.updata(customer);
        //修改操作
        return "updataSuccess";
    }


    public String listPage(){
        pageBean = customerService.listpage(currentPage);
//       ServletActionContext.getRequest().setAttribute("pageBean",pageBean);
        return "listPage";
    }


    //条件查询
    public String listcondition(){
        if (customer != null){
           list = customerService.findCondition(customer);
        } else { //不输入任何内容 查所有
            find();
        }

        return "listcondition";
    }
}
