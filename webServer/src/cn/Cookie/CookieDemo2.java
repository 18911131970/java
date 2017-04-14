package cn.Cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yangzhe on 17/4/11.
 */
/*清除Cookie*/
public class CookieDemo2  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("bookHistory","");
        //设置有效期时间为0
        cookie.setMaxAge(0);
        //设置相同路径
        cookie.setPath("/abc");
        //添加
        resp.addCookie(cookie);
        //重定向
        resp.sendRedirect("/abc/CookieDemo3");
    }
}
