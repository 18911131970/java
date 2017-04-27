package cn.anno;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by yangzhe on 2017/4/21.
 */


@Component(value = "user")
@Scope(value = "prototype")
public class User {

    public void test(){

        System.out.println("UserUserUser");
    }
}
