package cn.entity;

/**
 * Created by yangzhe on 17/4/18.
 */
public class User {

    private String username;
    private String password;
    private String address;
    private String phone;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {

        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "username:" + this.getUsername() + "password:" + this.getPassword();
    }
}
