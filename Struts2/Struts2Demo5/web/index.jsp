<%--
  Created by IntelliJ IDEA.
  User: yangzhe
  Date: 17/4/18
  Time: 下午4:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>登录成功</title>
  </head>
  <body>
  用户名：<s:property value="user.username"/>
  密码：<s:property value="user.password"/>
  恭喜您，登录成功！！！！！！！！

  <form name="form1" action=${pageContext.request.contextPath}/book.action method="post">

    <input type="submit">
  </form>
  </body>
</html>
