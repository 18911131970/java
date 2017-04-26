package com.c3p0;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by yangzhe on 2017/4/26.
 */
public class UserDao {


    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(){
        System.out.println("UserDao-----add");
        String sql = "insert into t_user values(?,?)";
        jdbcTemplate.update(sql,"lisi","2222");
    }
}
