<%--
  Created by IntelliJ IDEA.
  User: yangzhe
  Date: 2017/4/19
  Time: 下午6:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form name="form1" action=${pageContext.request.contextPath}/login.action method="post">
        用户名：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        <input type="submit">
    </form>

</body>
</html>
