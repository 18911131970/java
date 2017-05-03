<%--
  Created by IntelliJ IDEA.
  User: yangzhe
  Date: 2017/5/2
  Time: 上午10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>


    <form id="form1" name="form1" method="post" action="${pageContext.request.contextPath}/user_login.action">
        <div>
            <div style="text-align: center">登录</div>
        </div>
        <div style="align-content: center" >
            <div>用户名：<input name="username" type="text"></div>
            <div>密  码：<input name="password" type="text"></div>
            <div><input value="登录" type="submit"></div>
        </div>
    </form>

    <div style="align-content: center" >
        <a href="register.jsp">注册</a>
    </div>


</body>
</html>
