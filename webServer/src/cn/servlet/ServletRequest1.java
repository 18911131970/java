package cn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

/**
 * Created by yangzhe on 17/4/10.
 */
public class ServletRequest1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //链接填写的总结
        /*
        * 1、给服务器用的  ／代表当前web应用
        * */
        req.getRequestDispatcher("/").forward(req,resp);

        /*
        *  重点向
        *  客户端用  当前网站
        *  abc这个web应用下的某个网页
        * */
        resp.sendRedirect("/abc");

    }

    //请求转发
    public void requestFormword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //客户端的地址没有发生变化
        String data = "request 请求转发";
        req.setAttribute("message",data);
        req.getRequestDispatcher("/message.jsp").forward(req,resp);
    }

    /*请求数据编码问题*/
    public void test2(HttpServletRequest req) throws UnsupportedEncodingException {
        //解决get提交的乱码
        String name1 = req.getParameter("name");
//        name1 = new String(name1.getBytes("ios8859-1"),"UTF-8");


        //设置获取的数据的编码方式 只对post有效
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        System.out.println(name);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username:" + username + "\n" + "password:" + password);
    }

    /*获取请求数据（先检查再使用）
    * 通过表单、通过超链接
    * */
    public void getParams(HttpServletRequest req) {

        //第一种获取数据的方式
        String name = req.getParameter("name");

        if (name != null && !name.trim().equals("")){
            System.out.println(name);
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username:" + username + "\n" + "password:" + password);

        //第2种获取数据的方式
        Enumeration e = req.getParameterNames();
        while (e.hasMoreElements()){
            String key = (String) e.nextElement();
            String value = req.getParameter(key);
            System.out.println(value);
        }

        //第3种获取数据的方式
        //获取key 为"username" 的所有值
        String[] values =  req.getParameterValues("username");
        for (int i=0;i < values.length && values != null ; i++){
            System.out.println(values[i]);
        }

        //第4种获取数据的方式
        //转换为对象
//        Map<String,String[]> map =  req.getParameterMap();

        //第5种获取数据的方式
        //文件上传
        try {
            InputStream in = req.getInputStream();
            int len = 0;

            OutputStream out  = null;
            byte[] buffer = new byte[1024];
            while ((len = in.read(buffer)) != -1){
                out.write(buffer,0,len);
            }

        } catch (Exception e1){
            e1.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }



    /*获取请求头的一些方法*/
    public void getHeader(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userAgent = req.getHeader("User-Agent");
        resp.getWriter().write(userAgent);

        Enumeration e = req.getHeaderNames();
        while (e.hasMoreElements()){
            String name = (String)e.nextElement();
            String value = req.getHeader(name);
            System.out.println(value);
        }
    }

    public void test1(HttpServletRequest req) {
        System.out.println(req.getRequestURI());

        //请求的参数
        System.out.println("getQueryString：" +  req.getQueryString());

        //请求方式
        System.out.println("getMethod：" +  req.getMethod());

        //获取ip地址
        System.out.println("getRemoteAddr：" +  req.getRemoteAddr());

        System.out.println("getRemoteHost：" +  req.getRemoteHost());

        System.out.println("getRemoteUser：" +  req.getRemoteUser());

        System.out.println("getRemotePort：" +  req.getRemotePort());

        System.out.println("getLocalAddr：" +  req.getLocalAddr());
    }
}
