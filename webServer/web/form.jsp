<%--
  Created by IntelliJ IDEA.
  User: yangzhe
  Date: 17/4/12
  Time: 上午10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <form action="/abc/FormDemo2" method="post">
            <input type="hidden" name="token" value="${token}">
            用户名<input type="text" name="username"><br>
            <input type="submit" value="提交">

        </form>
</body>
</html>
