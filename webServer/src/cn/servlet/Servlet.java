package cn.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yangzhe on 17/4/5.
 */
@WebServlet(name = "cn.servlet.Servlet")
public class Servlet extends HttpServlet implements SingleThreadModel {

    private  ServletConfig config = null;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String config = this.getServletConfig().getInitParameter("data");

//        response.getOutputStream().write(config.getBytes());

        ServletContext context = this.getServletContext();
        System.out.println("doGet");
        System.out.println((String) context.getAttribute("data"));

        //获取全局配置的初始化参数
        String name = this.getServletContext().getServletContextName();
        System.out.println(name);

        String values = this.getServletContext().getInitParameter("data");
        System.out.println(values);


        //转发
        String forwardString = "forwardString";
        //不能通过该方式传递数据，会有线程问题
        this.getServletContext().setAttribute(forwardString,"data");
        //转发对象
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request,response);



    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
        super.destroy();
    }
}


