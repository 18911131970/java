package cn.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by yangzhe on 17/4/18.
 */
public class HelloAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        System.out.print("execute");
        return  SUCCESS;
    }
}
