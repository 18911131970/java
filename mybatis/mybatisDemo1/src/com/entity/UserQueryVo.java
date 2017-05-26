package com.entity;

/**
 * Created by yangzhe on 2017/5/17.
 * 包装类型
 */
public class UserQueryVo {

    //在这里包装查询条件
    private UserCustom userCustom;
    public UserCustom getUserCustom() {
        return userCustom;
    }
    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    //可以包装其他类型如：商品信息、订单信息等
}
