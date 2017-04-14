<%--
  Created by IntelliJ IDEA.
  User: yangzhe
  Date: 17/4/5
  Time: 下午4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>title</title>
  </head>
  <body>

    <font color="red">
      hello tomcat!!!
      <%
        String data = (String) application.getAttribute("data");
        if (data != null){
          out.write(data);
        }
        System.out.println("data:" + data);

      %>

      <a href="/abc/ServletRequest1?name=杨哲">传递数据</a>


      <form action="/abc/ServletRequest1" method="post">
        用户名：<input type="text" name="username">
        密码：<input type="text" name="password">
        <input type="submit" value="提交">
      </form>

    </font>


  </body>
</html>
