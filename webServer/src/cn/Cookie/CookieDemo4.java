package cn.Cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yangzhe on 17/4/11.
 */
public class CookieDemo4 extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();


        //根据用户带来的id，显示相应商品的详细信息
        String id = req.getParameter("id");
        Book book = (Book) DB.getAll().get(id);
        out.write(book.getId() + "<br>");
        out.write(book.getName() + "<br>");
        out.write(book.getAuthor() + "<br>");
        out.write(book.getDescription() + "<br>");

        //创建cookie，回写给浏览器
        String cookieValue = buildCookie(id,req);
        Cookie cookie = new Cookie("bookHistory",cookieValue);

        cookie.setMaxAge(1 * 30 * 24 * 60 * 60);
        cookie.setPath("/abc");
        resp.addCookie(cookie);

    }

    private String buildCookie(String id, HttpServletRequest req) {
         /*
            4中情况
            bookHistory = null     1      1
            bookHistory = 2,5,1    1    1,2,5
            bookHistory = 2,5,4    1    1,2,5
            bookHistory = 2,5    1      1,2,5
          */

         String bookHistory = null;
         Cookie cookies[] = req.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if (cookies[i].getName().equals("bookHistory")){
                bookHistory = cookies[i].getValue();
            }
        }
        if (bookHistory == null){
            return id;
        }

        String[] ids = bookHistory.split("/");
        LinkedList list = new LinkedList(Arrays.asList(ids));

        /*
                  if (list.contains(id)){ //检查是否包含当前id
            list.remove(id);
            list.addFirst(id);
        } else  {
            if (list.size() >= 3){
                list.removeLast();
                list.addFirst(id);
            } else  {
                list.addFirst(id);
            }
        }

         */

        if (list.contains(id)){ //检查是否包含当前id
            list.remove(id);
        } else  {
            if (list.size() >= 3){
                list.removeLast();
            }
        }
        list.addFirst(id);

        StringBuffer buffer = new StringBuffer();
        for (Object bid : list){
            buffer.append(bid + "/");
        }
        return buffer.deleteCharAt(buffer.length() - 1).toString();
    }
}
