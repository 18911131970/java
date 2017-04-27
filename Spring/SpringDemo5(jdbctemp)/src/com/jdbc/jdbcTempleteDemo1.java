package com.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.List;

class myRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}

/**
 * Created by yangzhe on 2017/4/25.
 */
public class jdbcTempleteDemo1 {



    @Test
    /*查询list*/
    public void testc3p0(){


    }


    @Test
    /*查询list*/
    public void testList() throws PropertyVetoException {

//        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
//        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
//        comboPooledDataSource.setJdbcUrl("jdbc:mysql:///Spring");
//        comboPooledDataSource.setUser("root");
//        comboPooledDataSource.setPassword("root");
//


        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///Spring");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM t_user";


        List<User> list = jdbcTemplate.query(sql,new myRowMapper());
        System.out.println(list);

    }

    @Test
    /*查询一个对象*/
    public void testObj() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///Spring");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM t_user where username = ?";

        User user = jdbcTemplate.queryForObject(sql,new myRowMapper(),"zhangsan");
        System.out.println(user.getUsername() + user.getPassword());

    }



    @Test
    //添加操作
    public void queryCount(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///Spring");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT COUNT(*) FROM t_user";
        int count = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(count);
    }


    @Test
    //添加操作
    public void delete(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///Spring");
        dataSource.setUsername("root");
        dataSource.setPassword("root");


        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "DELETE FROM t_user WHERE username=?";
        int count = jdbcTemplate.update(sql,"1asdf");
        System.out.println(count);
    }


    @Test
    //添加操作
    public void update(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///Spring");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "UPDATE t_user  SET password=? WHERE username=?";
        int count = jdbcTemplate.update(sql,"1314","zhangsan");
        System.out.println(count);
    }

    @Test
    //添加操作
    public void add(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///Spring");
        dataSource.setUsername("root");
        dataSource.setPassword("root");


        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "insert into t_user values(?,?)";
        int count = jdbcTemplate.update(sql,"1asdf","lisi");
        System.out.println(count);
    }
}
