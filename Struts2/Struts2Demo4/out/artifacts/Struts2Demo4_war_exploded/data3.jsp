<%--
  Created by IntelliJ IDEA.
  User: yangzhe
  Date: 17/4/18
  Time: 上午11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/data3.action" method="post">
        username:<input type="text" name="user.username"><br>
        password:<input type="text" name="user.password"><br>
        address: <input type="text" name="user.address"><br>
        phone:  <input type="text" name="user.phone"><br>
        <input type="submit" value="提交">

    </form>
</body>
</html>
