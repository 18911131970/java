package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

/**
 * Created by yangzhe on 2017/4/26.
 */
public class UserAction extends ActionSupport {

    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("UserAction------execute");
        userService.add();
        userService.get();
        return NONE;
    }
}
