<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: yangzhe
  Date: 17/4/12
  Time: ����1:49
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
        out.write("��ǰʱ�䣺" + date.toString());
      %>


      <%--jspӵ���Լ��ķ�����<%!  %>��--%>
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

      <%--��ǰҳ�浼��ĳ��jspҳ�棬��̬����������ʱ������������������jsp������һ��servlet--%>
      <%@include file="error.jsp"
      %>
      <%--��̬����������2��servlet�ļ�--%>
      <%
        request.getRequestDispatcher("/jsp/error.jsp").include(request,response);
      %>

      <%--���õı�ǩ--%>
      <jsp:include page="error.jsp">
        <jsp:param name="data" value="23"></jsp:param>
      </jsp:include>

      <jsp:forward page="error.jsp"></jsp:forward>
  </body>
</html>
