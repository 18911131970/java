package cn.action;

/**
 * Created by yangzhe-java on 17/4/16.
 */
public class helloAction {

    /*
    * 配置action类的访问路径
    * */
    public String execute(){
        System.out.println("execute");
        return "none";
    }

    public String add(){
        return "add";
    }
}
