package cn.property;

import cn.ioc.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by yangzhe on 2017/4/21.
 */
public class Person {

    private String pname;

    public void setPname(String pname) {
        this.pname = pname;
    }

    private String[] arrs;
    private List<String> list ;
    private Map<String,String> map;
    private Properties properties;

    public void setArrs(String[] arrs) {
        this.arrs = arrs;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }



    public void test1(){

        System.out.println("pname---------" + pname);

    }

    public void test2(){

        System.out.println("String[]---------" + arrs);
        System.out.println("List---------" + list);
        System.out.println("Map---------" + map);
        System.out.println("Properties---------" + properties);
    }


}
