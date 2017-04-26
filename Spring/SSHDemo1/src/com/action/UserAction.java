package com.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by yangzhe on 2017/4/26.
 */
public class UserAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        System.out.println("UserAction------execute");
        return NONE;
    }
}
