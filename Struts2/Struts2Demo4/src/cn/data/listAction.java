package cn.data;

import cn.entity.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by yangzhe on 17/4/18.
 */
public class listAction extends ActionSupport {

    private List<User> list;

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    @Override
    public String execute() throws Exception {

        System.out.println("listAction-------:" + this.list);
        return NONE;
    }
}
