package cn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * Created by yangzhe on 17/4/7.
 */
public class Servlet7 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        test3(req, resp);

    }

    //常用的定时刷新
    public void test3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = "<meta http-equiv='refresh' content='3';url=/abc/index.jsp>恭喜您登录成功，3秒后跳转到首页。如果没有跳转请点击这里<a href='http://www.baidu.com'>超链接</a>";
        this.getServletContext().setAttribute("message",message);
        this.getServletContext().getRequestDispatcher("/message.jsp").forward(req,resp);
    }

    //内容传递到jsp然后刷新
    public void test2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type","text/html;charset=UTF-8");
        resp.setHeader("refresh","3,url=/abc/index.jsp");
        String message = "恭喜您登录成功，3秒后跳转到首页。如果没有跳转请点击这里<a href='http://www.baidu.com'>超链接</a>";
        this.getServletContext().setAttribute("message",message);
        this.getServletContext().getRequestDispatcher("/message.jsp").forward(req,resp);
    }

    //刷新操作
    public void test1(HttpServletResponse resp) throws IOException {
        //定时刷新  隔3秒刷新一次
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type","text/html;charset=UTF-8");
        resp.setHeader("refresh","3,url=/abc/index.jsp");
        String data = new Random() + "";
        resp.getWriter().write("恭喜您登录成功，3秒后跳转到首页。如果没有跳转请点击这里<a href='http://www.baidu.com'>超链接</a>");
    }
}
