package cn.form;

import cn.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yangzhe on 17/4/18.
 */
public class form4 extends ActionSupport{

    @Override
    public String execute() throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setAddress(request.getParameter("address"));
        user.setPassword(request.getParameter("password"));
        user.setPhone(request.getParameter("Phone"));

        System.out.println(user);
        return NONE;
    }
}
