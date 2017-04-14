package cn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by yangzhe on 17/4/7.
 */
public class Servlet4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置response查询的码表，以控制response以什么码表向浏览器写数据
        resp.setCharacterEncoding("UTF-8");
        //程序以什么码表输出  程序就一定要控制用什么码表打开
        resp.setHeader("Content-type","text/html;charset=UTF-8");
        String data = "中国";
        OutputStream outputStream = resp.getOutputStream();
        outputStream.write(data.getBytes("UTF-8"));
    }

}
