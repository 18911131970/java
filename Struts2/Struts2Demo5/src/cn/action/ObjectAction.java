package cn.action;

import cn.entity.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by yangzhe on 17/4/19.
 */
public class ObjectAction extends ActionSupport{

    User user =  new User();
    public User getUser() {
        return user;
    }
    @Override
    public String execute() throws Exception {
        user.setUsername("zhangsan");
        user.setPassword("123123");
        return SUCCESS;
    }
}
