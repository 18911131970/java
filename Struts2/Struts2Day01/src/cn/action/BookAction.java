package cn.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by yangzhe-java on 17/4/17.
 */
public class BookAction extends ActionSupport {
    public String add(){
        System.out.println("addAction");
       return NONE;
    }

    public String update(){
        System.out.println("updateAction");
        return NONE;
    }
}
