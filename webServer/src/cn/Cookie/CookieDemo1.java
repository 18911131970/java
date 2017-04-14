package cn.Cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by yangzhe on 17/4/11.
 */
//网站首页
public class CookieDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.print("<a href='/abc/CookieDemo2'>清除上次访问时间</a><br>");
        writer.print("上次访问时间：");

        //获得用户的时间cookie
        Cookie cookies[] = req.getCookies();
        for (int i = 0; i < cookies.length && cookies != null; i++) {
            System.out.println(cookies[i].getName());
            if (cookies[i].getName().equals("lastAccessTime")){
                //获取上次访问的时间
                long cookieValue = Long.parseLong(cookies[i].getValue());
                Date date = new Date(cookieValue);
                writer.print(date.toLocaleString());
            } else {

            }
        }

        //给用户回送最新的访问时间
        Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis() + "");
        //设置时间
        cookie.setMaxAge(1 * 30 * 24 * 3600);
        //设置路径
        cookie.setPath("/abc");
        //添加
        resp.addCookie(cookie);

    }
}
