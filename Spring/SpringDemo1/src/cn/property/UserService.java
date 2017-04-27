package cn.property;

import cn.ioc.User;

/**
 * Created by yangzhe on 2017/4/21.
 */
public class UserService {

    private User user = new User();

    public void setUser(User user) {
        this.user = user;
    }
    public void test1(){
        System.out.println("UserService---------+" + user);
    }


}
