package com.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by yangzhe on 2017/4/26.
 */
public class OrdersDao {

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void lessMoney(){
        System.out.println("lessMoney");
        String sql = "UPDATE account SET money = money-? where username=?";
        jdbcTemplate.update(sql,1000,"xiaowang");
    }

    public void moreMoney(){
        String sql = "UPDATE account SET money = money+? where username=?";
        jdbcTemplate.update(sql,1000,"xiaoma");

    }
}
