<%--
  Created by IntelliJ IDEA.
  User: yangzhe
  Date: 17/4/13
  Time: 上午10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>javaBean</title>
</head>
<body>
    <jsp:useBean id="person" class="cn.Person" scope="page" />

        <jsp:setProperty name="person" property="name" value="zhangsan" />
        <%=person.getName()%>


</body>
</html>
