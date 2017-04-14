package cn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yangzhe on 17/4/10.
 */
public class Servlet8 extends HttpServlet {


    int index = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.sendRedirect("/abc/index.jsp");

        //重定向
//        resp.setStatus(302);
//        resp.setHeader("location","/index.jsp");

    }

    public void cacheDemo(HttpServletResponse resp) throws IOException {
        //控制浏览器缓存
        resp.setDateHeader("expires", System.currentTimeMillis() + 1000 * 3600);
        String data = "ddddddddd" + index;
        index ++;
        resp.getWriter().write(data);
    }


}
