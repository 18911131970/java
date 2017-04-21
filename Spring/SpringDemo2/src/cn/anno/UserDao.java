package cn.anno;

import org.springframework.stereotype.Component;

/**
 * Created by yangzhe on 2017/4/21.
 */

@Component(value = "userDao")
public class UserDao {

    public void add(){
        System.out.println("UserDao---add---");
    }
}








