package com.action;

import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;
import org.apache.struts2.ServletActionContext;

/**
 * Created by yangzhe on 2017/4/28.
 */
public class UserAction extends ActionSupport {

    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /*属性封装来获取*/
    private String username;
    private String password;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    /*登录的方法*/
    public String login(){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        User userExist =  userService.login(user);
        if (userExist != null){
            //用session保存登录状态
            ServletActionContext.getRequest().getSession().setAttribute("user",userExist);
            return "loginSuccess";
        } else  {
            return "login";
        }

    }

    @Override
    public String execute() throws Exception {
        return super.execute();
    }


}
