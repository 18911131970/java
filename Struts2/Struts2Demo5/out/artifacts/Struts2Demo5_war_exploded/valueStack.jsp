<%--
  Created by IntelliJ IDEA.
  User: yangzhe
  Date: 17/4/18
  Time: 下午4:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
    使用struts2标签查看结构
    --%>
    <s:debug></s:debug>

    <%--获取值栈中字符串--%>
    <s:property value="username"/>
    <s:property value="password"/>

    <%--获取值栈中的对象--%>
    <s:property value="user.username"/>
    <s:property value="user.password"/>

    <%--获取值栈中的list--%>
    <%--第一种方式--%>
    <s:property value="list[0]"/><br>
    <%--第二种方式--%>
    <s:iterator value="list">
        <%--遍历list中的每个对象--%>
        <s:property value="username"/>
    </s:iterator><br>
    <%--第三种方式--%>
    <s:iterator value="list" var="user">
        <s:property value="#user.username"/>
        <s:property value="#user.password"/>
    </s:iterator>


    <%--set方法放入值栈的值，获取方式--%>
    <s:property value="username"/>

    <%--push方法放入值栈的值，获取方式--%>
    <s:property value="[0].top"/>
</body>
</html>
