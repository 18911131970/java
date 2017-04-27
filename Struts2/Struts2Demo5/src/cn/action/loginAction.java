package cn.action;

import cn.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yangzhe on 2017/4/19.
 */
public class loginAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();

    public User getUser() {
        return user;
    }

    @Override
    public User getModel() {
        return user;
    }

    public String login(){
        System.out.print(user);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.getSession().setAttribute("username",user.getUsername());
        request.getSession().setAttribute("password",user.getPassword());


        if (user.getUsername().equals("admin")){
            return "loginSuccess";
        } else  {
            return "login";
        }


    }

    @Override
    public String execute() throws Exception {
        System.out.print("loginAction");
        return NONE;
    }
}
