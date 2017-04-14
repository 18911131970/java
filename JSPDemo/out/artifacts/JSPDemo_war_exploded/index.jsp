<%@ page import="java.util.Date" %><%--
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
  </body>
</html>
