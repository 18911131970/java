package cn.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yangzhe on 17/4/12.
 */
public class FormDemo2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean b = isTokenValid(req);
        if (!b){
            System.out.println("请勿重复提交");
            return;
        }
        req.getSession().removeAttribute("token");
        System.out.println("用户注册");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    /*服务端判断token是否有效，无效为重复，有效继续提交*/
    private boolean isTokenValid(HttpServletRequest req) {
        String clientToken = (String) req.getParameter("token");
        if (clientToken == null){
            return  false;
        }
        String serverToken = (String) req.getSession().getAttribute("token");
        if (serverToken == null){
            return false;
        }
        if (!serverToken.equals(clientToken)){
            return false;
        }
        return true;
    }
}
