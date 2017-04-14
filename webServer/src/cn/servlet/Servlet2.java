package cn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by yangzhe on 17/4/6.
 */
public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        test2();

    }

    public void test2() throws IOException {

        //这种方法可以获取资源文件的名称
        String path = this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");
        String filename = path.substring(path.lastIndexOf("/") +1);
        System.out.println("filename:" + filename);

        FileInputStream fileInputStream = new FileInputStream(path);
        Properties prop = new Properties();
        prop.load(fileInputStream);

        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        System.out.println("url:" + url);
    }

    public void test1() throws IOException {
        InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
        Properties prop = new Properties();
        prop.load(in);

        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        System.out.println("url:" + url);
    }
}
