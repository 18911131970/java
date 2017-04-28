package com.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by yangzhe on 2017/4/28.
 */
public class UserAction extends ActionSupport {

    public String login(){
        return "login";
    }

    @Override
    public String execute() throws Exception {
        return super.execute();
    }
}
