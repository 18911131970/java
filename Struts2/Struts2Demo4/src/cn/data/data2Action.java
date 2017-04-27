package cn.data;

import cn.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by yangzhe on 17/4/18.
 */
public class data2Action extends ActionSupport implements ModelDriven<User> {


    private User user = new User();
    @Override
    public User getModel() {
        return user;
    }

    @Override
    public String execute() throws Exception {

        System.out.println("data2Action-------:" + this.user);
        return NONE;
    }
}
