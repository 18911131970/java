<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: yangzhe
  Date: 2017/5/2
  Time: 下午1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>已经添加用户信息列表</title>
</head>
<body>
    <div>当前已添加用户为：</div>
    <s:iterator value="list" var="customer">
        姓名：<s:property value="#customer.cname"/>
        地址：<s:property value="#customer.caddress"/>
        手机号：<s:property value="#customer.cphone"/>
        <a href="${pageContext.request.contextPath}/customer_delete.action?cid=<s:property value="#customer.cid"/>">删除</a>
        <a href="${pageContext.request.contextPath}/customer_show.action?cid=<s:property value="#customer.cid"/>">修改</a>
        <br>
    </s:iterator>
    <br>
    <a href="add.jsp">新增客户</a>&nbsp;&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/customer_listPage.action?currentPage=1">分页查看</a>

</body>
</html>
