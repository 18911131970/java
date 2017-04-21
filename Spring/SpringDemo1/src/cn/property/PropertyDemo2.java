package cn.property;

/**
 * Created by yangzhe on 2017/4/21.
 */
public class PropertyDemo2 {

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public void test1(){
        System.out.println("PropertyDemo2---------+" + username);
    }
}
