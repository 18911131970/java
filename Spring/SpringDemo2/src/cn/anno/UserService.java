package cn.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by yangzhe on 2017/4/21.
 */

@Component("userService")
public class UserService {

    //第一种注解方式
//    @Autowired
//    private UserDao userDao;

    //第二种注解方式
    @Resource(name = "userDao")
    private UserDao userDao;


    public void add(){
        System.out.println("UserService---add---" + userDao);
        userDao.add();
    }

}
