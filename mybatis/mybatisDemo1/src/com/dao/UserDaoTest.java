package com.dao;

import com.entity.User;
import com.entity.UserCustom;
import com.entity.UserQueryVo;
import com.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by yangzhe on 2017/5/15.
 */
public class UserDaoTest {

    private SqlSessionFactory sqlSessionFactory;



    @Test
    public void findUserList() throws  Exception{
        String config = "config/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserCustom userCustom = new UserCustom();
        userCustom.setSex("男");
        userCustom.setUsername("zhang");

        UserQueryVo userQueryVo = new UserQueryVo();
        userQueryVo.setUserCustom(userCustom);

        List<UserCustom> list = (List<UserCustom>)userMapper.findUserList(userQueryVo);
        System.out.println(list);

    }



    @Test
    public void testMapper() throws  Exception{
        String config = "config/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(1);
        System.out.println(user);

    }


    @Test
    public void updateUser() throws IOException {
        String config = "config/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(5);
        user.setUsername("李四");
        user.setAddress("北京");
        sqlSession.update("user.updateUser",user);
        sqlSession.commit();
        sqlSession.close();


    }



    @Test
    public void deleteUser() throws IOException {
        String config = "config/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("user.deleteUser",4);
        sqlSession.commit();
        sqlSession.close();


    }

    @Test
    public void addUser() throws IOException{

        String config = "config/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("王二小");
        user.setBirthday("20000001");
        user.setAddress("海南");
        user.setSex("男");
        sqlSession.insert("user.insertUser",user);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void findByUsername()  throws  IOException {
        String config = "config/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> list =  sqlSession.selectList("user.findUserByUsername","li");

        System.out.println(list);

        sqlSession.close();

    }



    @Test
    public void findOne() throws IOException {

        String config = "config/SqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(config);
        //创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //通过sqlSession操作数据库
        /*
        * 第一个参数：映射文件中statement的id，等于：namespace+statement的id
        * 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
        * 结果：是与映射文件中所匹配的resultType类型的对象
        * */
        User user =  (User) sqlSession.selectOne("user.findUserById",1);

        System.out.println(user.getUsername());

        //释放资源
        sqlSession.close();
    }
}
