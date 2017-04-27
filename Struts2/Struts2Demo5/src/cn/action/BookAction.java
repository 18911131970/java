package cn.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * Created by yangzhe on 17/4/18.
 */
public class BookAction extends ActionSupport {

    public BookAction(){
        System.out.println("BookAction");
    }

    @Override
    public String execute() throws Exception {

        ActionContext context = ActionContext.getContext();
        //值栈对象
        ValueStack stack = context.getValueStack();

        return SUCCESS;
    }
}
