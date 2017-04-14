package cn.servlet.UserDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by yangzhe on 17/4/7.
 * 在java代码中读取配置文件
 * 通过类装载器 读取资源文件
 */
public class UserDao {


    static {

        try {
            InputStream in = UserDao.class.getClassLoader().getResourceAsStream("db.properties");
            Properties pro = new Properties();
            pro.load(in);
            System.out.println(pro.getProperty("url"));
        } catch (IOException e){
            //抛出
            throw new ExceptionInInitializerError();
        }

    }

    public void update() throws IOException {

        //修改了配置文件  但不重启服务  获取到新的文件内容
        //通过类装载的方式获取到文件路径
        String path = UserDao.class.getClassLoader().getResource("db.properties").getPath();
        FileInputStream fileInputStream = new FileInputStream(path);
        Properties prop = new Properties();
        prop.load(fileInputStream);
        System.out.println(prop.getProperty("url"));


    }
}
