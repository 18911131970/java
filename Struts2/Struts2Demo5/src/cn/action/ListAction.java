package cn.action;

import cn.entity.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangzhe on 17/4/19.
 */
public class ListAction extends ActionSupport {

    List<User> list = new ArrayList<>();
    public List<User> getList() {
        return list;
    }
    @Override
    public String execute() throws Exception {

        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123123");
        User user1 = new User();
        user1.setUsername("王二小");
        user1.setPassword("123456");
        list.add(user);
        list.add(user1);
        return SUCCESS;
    }
}
