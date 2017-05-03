<%--
  Created by IntelliJ IDEA.
  User: yangzhe
  Date: 2017/5/3
  Time: 下午3:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>查询</title>
</head>
<body>
    <form name="form1" id="form1" method="post" action="${pageContext.request.contextPath}/customer_listcondition">
        用户名：<input type="text" name="cname">
        <input type="submit" value="查询">
    </form>

    <s:iterator value="list" var="customer">
        姓名：<s:property value="#customer.cname"/>
        地址：<s:property value="#customer.caddress"/>
        手机号：<s:property value="#customer.cphone"/>
        <a href="${pageContext.request.contextPath}/customer_delete.action?cid=<s:property value="#customer.cid"/>">删除</a>
        <a href="${pageContext.request.contextPath}/customer_show.action?cid=<s:property value="#customer.cid"/>">修改</a>
        <br>
    </s:iterator>

</body>
</html>
