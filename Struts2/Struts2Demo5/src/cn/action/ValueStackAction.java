package cn.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * Created by yangzhe on 17/4/19.
 */
public class ValueStackAction extends ActionSupport {

    private String password;
    public String getPassword() {
        return password;
    }

    @Override
    public String execute() throws Exception {

        //使用直栈里面的set方法放数据
        ActionContext context = ActionContext.getContext();
        ValueStack stack = context.getValueStack();
        stack.set("username","set方法放入的值");


        //push方法
        stack.push("push方法放入的值");

        this.password = "123123123123";

        return SUCCESS;
    }
}
