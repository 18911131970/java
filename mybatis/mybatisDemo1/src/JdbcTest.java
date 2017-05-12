import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by yangzhe on 2017/5/12.
 */
public class JdbcTest {

    @Test
    public void test1(){


    }

//    public static void main(String[] args){
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        try{
//
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis","root","root");
//            String sql = "SELECT * FROM user WHERE username = ?";
//
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1,"zhangsan");
//
//            resultSet = preparedStatement.executeQuery();
//
//            //循环获取查询结果
//            while (resultSet.next()){
//
//            }
//
//        }catch (Exception e){
//
//        }final {
//
//        }
//
//    }
}
