package cn.data;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by yangzhe on 17/4/18.
 * 属性封装 获取表单的数据
 */
public class dataDemo1Action extends ActionSupport {

    private String username;
    private String password;
    private String address;
    private String phone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(this.getUsername() + ";" + this.getPassword());

        return NONE;
    }
}
