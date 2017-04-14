<%--
  Created by IntelliJ IDEA.
  User: yangzhe
  Date: 17/4/7
  Time: 下午5:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>message</title>
</head>
<body>

    <%--$(data);--%>
    <%
        String message = (String)request.getAttribute("message");
        out.write(message);
    %>
    <%--<%--%>
         <%--String message = (String) application.getAttribute("message");--%>
         <%--out.write(message);--%>
    <%--%>--%>
</body>
</html>
