package cn.Cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by yangzhe on 17/4/11.
 */
/*首页的servlet*/
public class CookieDemo3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.write("本网站有如下商品：<br>");
        Map map = DB.getAll();
        Iterator e = map.entrySet().iterator();
        for (int i = 0; i < map.size(); i++) {
            Map.Entry entry = (Map.Entry) e.next();
            Book book = (Book) entry.getValue();
            out.write("<a href='/abc/CookieDemo4?id="+book.getId()+"' target='_blank'>"+book.getName()+"</a><br>");
        }

        out.write("曾经看过的商品：<br>");
        //显示用户曾经看过的商品
        Cookie cookies[] = req.getCookies();
        for (int i = 0;cookies != null && i < cookies.length; i++) {
            if (cookies[i].getName().equals("bookHistory")){
                String[] ids = cookies[i].getValue().split("/");
                for (String id : ids){
                    Book book = (Book) DB.getAll().get(id);
                    out.write("<a href='/abc/CookieDemo4?id="+book.getId()+"' target='_blank'>"+book.getName()+"</a><br>");

                }
            }
        }

        out.print("<a href='/abc/CookieDemo2'>清除上次访问记录</a><br>");



    }
}

class DB {
    private static LinkedHashMap<String,Book> map = new LinkedHashMap<String,Book>();

    static {
        map.put("1",new Book("1","javaweb开发1","路人甲1","一本好书啊"));
        map.put("2",new Book("2","javaweb开发2","路人甲2","一本好书啊"));
        map.put("3",new Book("3","javaweb开发3","路人甲3","一本好书啊"));
        map.put("4",new Book("4","javaweb开发4","路人甲4","一本好书啊"));
        map.put("5",new Book("5","javaweb开发5","路人甲5","一本好书啊"));
        map.put("6",new Book("6","javaweb开发6","路人甲6","一本好书啊"));

    }

    public static LinkedHashMap<String,Book> getAll(){
        return map;
    }

}

class Book {
    private String id;
    private String name;
    private String author;
    private String description;

    public Book() {
        super();
    }

    public Book(String id, String name, String author, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
