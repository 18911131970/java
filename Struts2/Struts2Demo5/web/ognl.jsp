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
    value 中写ognl表达式
    --%>
    <s:property value="'hello'.length()" />
</body>
</html>
