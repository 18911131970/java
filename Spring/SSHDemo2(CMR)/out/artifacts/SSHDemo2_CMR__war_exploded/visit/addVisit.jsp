<%--
  Created by IntelliJ IDEA.
  User: yangzhe
  Date: 2017/5/10
  Time: 下午4:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>添加客户拜访</title>
</head>
<body>

    <form name="form1" action="${pageContext.request.contextPath}/visit_add">
        客户：
        <select name="customer.cid">
            <c:forEach items="${customerList}" var="customer">
                <option value="${customer.cid}">${customer.cname}</option>
            </c:forEach>
        </select>
        用户：
        <select name="user.uid">
            <c:forEach items="${userList}" var="user">
                <option value="${user.uid}">${user.username}</option>
            </c:forEach>
        </select>
        拜访地址：<input type="text" name="vaddress">
        拜访内容：<input type="text" name="vcontent">

        <input type="submit" value="提交">
    </form>


</body>
</html>
