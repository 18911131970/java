package cn.Session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by yangzhe on 17/4/11.
 */
public class SessionDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("name","洗衣机");
        /*
           第一次访问服务器创建session，
           生成一个Jsessionid,
           以Cookie的形式回传给浏览器，
           这会cookie没有设置有效期
           浏览器关闭后cookie消失，刚刚创建的Session也无法使用
           如果需要浏览器关闭后session存在 则设置这个cookie的有效期
         */
        String sessionID = session.getId();
        Cookie cookie = new Cookie("JSESSIONID",sessionID);
//        cookie.setPath("/abc");
        cookie.setPath(req.getContextPath());
        cookie.setMaxAge(30 * 60);
        resp.addCookie(cookie);

        //只获取session  不创建session
        HttpSession session1 = req.getSession(false);

        //浏览器不获取Cookie(禁用Cookie)，通过resp.encodeURL 后 在链接后会拼接上jsessionid
        //encodeURL 如果禁用了禁用Cookie 就会拼接 如果没有禁用则不会
        //浏览器第一次访问服务器，服务器不知道浏览器是否禁用Cookie
        req.getSession();
        String url = resp.encodeURL("/abc/SessionDemo1");

    }
}
