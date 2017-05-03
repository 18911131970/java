<%--
  Created by IntelliJ IDEA.
  User: yangzhe
  Date: 2017/5/2
  Time: 下午1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<form id="form1" name="form1" method="post" action="${pageContext.request.contextPath}/customer_add.action">
    <div>
        <div style="text-align: center">注册</div>
    </div>
    <div style="align-content: center" >
        <div>用户名：<input name="username" type="text"></div>
        <div>密  码：<input name="password" type="text"></div>
        <div>地  址：<input name="address" type="text"></div>
        <div><input value="注册" type="submit"></div>
    </div>




</form>
</body>
</html>
