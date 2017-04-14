package cn;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by yangzhe on 17/4/13.
 */
public class Person {


    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Test
    public void add(){
        BigDecimal a = new BigDecimal("0.1231231231231235345645645453");
        BigDecimal b = new BigDecimal("9.23123123123123123123123123");
        BigDecimal result = a.multiply(b); //*
        a.add(b);//+
        a.subtract(b);//-
        a.divide(b,20,BigDecimal.ROUND_HALF_UP); //除 保留小数点后20位 四舍五入设置
        System.out.println(result.toString());
    }

}
