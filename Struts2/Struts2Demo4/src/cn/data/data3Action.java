package cn.data;

import cn.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by yangzhe on 17/4/18.
 * 表达式形式
 */
public class data3Action extends ActionSupport {


    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute() throws Exception {

        System.out.println("data3Action-------:" + this.user);
        return NONE;
    }
}
