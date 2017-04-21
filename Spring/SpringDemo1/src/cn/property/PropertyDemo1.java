package cn.property;

/**
 * Created by yangzhe on 2017/4/21.
 */
public class PropertyDemo1 {

    private String username;

    public PropertyDemo1(String username) {
        this.username = username;
    }

    public void test1(){
        System.out.println("PropertyDemo1---------+" + username);
    }
}
