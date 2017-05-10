package com.action;

import com.entity.Customer;
import com.entity.LinkMan;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CustomerService;
import com.service.LinkManService;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by yangzhe on 2017/5/3.
 */
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
    private LinkManService linkManService;
    public void setLinkManService(LinkManService linkManService) {
        this.linkManService = linkManService;
    }

    private CustomerService customerService;
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    private LinkMan linkMan = new LinkMan();

    @Override
    public LinkMan getModel() {
        return linkMan;
    }




    /*
      上传的文件流
      上传的文件名
    */
    //表单里文件上传项的name值
    private File upload;
    //上传的文件名:表单里文件上传项的name值+FileName
    private String uploadFileName;

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }




    public String toAddPage(){
        //查询出所有的客户list
        List<Customer> list = customerService.findCustomers();
        ServletActionContext.getRequest().setAttribute("listCustomer",list);
        return "toAddPage";
    }


    public String addLinkMan() throws IOException {
//        String scid = ServletActionContext.getRequest().getParameter("cid");
//        int cid = Integer.parseInt(scid);
//        Customer customer = new Customer();
//        customer.setCid(cid);
//        linkMan.setCustomer(customer);

        if (upload != null){ //写上传代码
            //在服务器文件夹里创建文件
            File serviceFile = new File("/Users/yangzhe/Project/java/uploadFile/" + uploadFileName);
            //将文件复制到服务器文件里
            FileUtils.copyFile(upload,serviceFile);
        }

        linkManService.addLinkMan(linkMan);
        return "addLinkMan";
    }

    public String list(){
        List<LinkMan> list = linkManService.listLinkMan();
        ServletActionContext.getRequest().setAttribute("linkManList",list);
        return "list";
    }

    //修改联系人
    public String show(){
        int linkId = linkMan.getLinkId();

        HttpServletRequest servletRequest = ServletActionContext.getRequest();

        //客户list集合
        List<Customer> listCustomer = customerService.findCustomers();
        servletRequest.setAttribute("listCustomer",listCustomer);

        LinkMan linkMan = linkManService.findOne(linkId);
        servletRequest.setAttribute("linkMan",linkMan);
        return "show";
    }

    public String updataLinkMan(){

        linkManService.updata(linkMan);

        return "updataLinkMan";
    }

    public String delete(){
        linkManService.delete(linkMan);
        return "delete";
    }


}
