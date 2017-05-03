<%--
  Created by IntelliJ IDEA.
  User: yangzhe
  Date: 2017/5/2
  Time: 下午3:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>

<form id="form1" name="form1" method="post" action="${pageContext.request.contextPath}/customer_add.action">
    <div style="text-align: center">添加</div>
    </div>
    <div style="align-content: center" >
        <div>姓名：<input name="cname" type="text"></div>
        <div>地址：<input name="caddress" type="text"></div>
        <div>手机号：<input name="cphone" type="text"></div>
        <div><input value="添加" type="submit"></div>
    </div>
</form>

</body>
</html>
