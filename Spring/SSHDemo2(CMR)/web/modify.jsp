<%--
  Created by IntelliJ IDEA.
  User: yangzhe
  Date: 2017/5/2
  Time: 下午5:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form id="form1" name="form1" method="post" action="${pageContext.request.contextPath}/customer_modify.action">
    <div style="text-align: center">修改</div>
    </div>
    <div style="align-content: center" >
        <div>姓名：<input name="cname" type="text"    value=<s:property value="customer.cname"/>></div>
        <div>地址：<input name="caddress" type="text" value=<s:property value="customer.caddress"/>></div>
        <div>手机号：<input name="cphone"  type="text" value=<s:property value="customer.cphone"/>></div>
        <input type="hidden" name="cid" value=<s:property value="customer.cid"/>>
        <div><input value="确认修改" type="submit"></div>
    </div>
</form>
</body>
</html>
