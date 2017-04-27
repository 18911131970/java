package cn.data;

import cn.entity.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.Map;

/**
 * Created by yangzhe on 17/4/18.
 */
public class mapAction extends ActionSupport {

    private Map<String,User>  map;
    public Map<String, User> getMap() {
        return map;
    }
    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    @Override
    public String execute() throws Exception {

        System.out.println("mapAction-------:" + this.map);
        return NONE;
    }
}
