<%--
  Created by IntelliJ IDEA.
  User: yangzhe
  Date: 17/4/12
  Time: 下午1:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
      <%
        Date date = new Date(0);
        out.write("当前时间：" + date.toString());
      %>


      <%--jsp拥有自己的方法（<%!  %>）--%>
      <%!
        public static void run(){

        }
      %>

      <%@page
              contentType="text/html; ISO-8859-1"
              language="java"
              extends="cn.Servlet"
              import="java.util.Date"
              session="true"
              buffer="8kb"
              errorPage="/error.jsp"
              isErrorPage="true"
              pageEncoding="GB2312"
      %>
      <%@ page import="java.sql.Time" %>
      <%@ page import="cn.Person" %>
      <%@ page import="java.util.ArrayList" %>
      <%@ page import="java.util.Map" %>
      <%@ page import="java.util.*" %>

      <%--当前页面导入某个jsp页面，静态包含（编译时包含），包含的所有jsp会编译成一个servlet--%>
      <%@include file="error.jsp"
      %>
      <%--动态包含，生成2个servlet文件--%>
      <%
        request.getRequestDispatcher("/jsp/error.jsp").include(request,response);
      %>

      <%--常用的标签--%>
      <jsp:include page="error.jsp">
        <jsp:param name="data" value="23"></jsp:param>
      </jsp:include>

      <jsp:forward page="error.jsp"></jsp:forward>



      <%--el表达式--%>
        <%
            //单个数据
            String data = "123";
            request.setAttribute("data",data);

            //一个javaBean
            Person p1 = new Person();
            p1.setName("zhangsan");
            request.setAttribute("p1",p1);

            //一个集合
            ArrayList<Person> list = new ArrayList<Person>();
            list.add(new Person());
            list.add(new Person());
            list.add(new Person());
            request.setAttribute("list",list);

            //一个map
            Map<String,Person> map = new java.util.HashMap();
            map.put("aa",new Person());
            map.put("bb",new Person());
            request.setAttribute("map",map);
        %>
      <%-- 查找顺序：pageContext.findAttribute()  ->  page request -> session -> application--%>
      <%--取单个数据--%>
      ${data}
      <br>
      <%--取一个javaBean--%>
      ${p1.name}
      <br>
      <%--取一个list--%>
      ${list[2]}
      <br>
      <%--取一个map--%>
      ${map.aa.name}
      <%--获取当前web的名称--%>
      <a href="/${pageContext.request.contextPath}/index.jsp">click me</a>


  </body>
</html>
