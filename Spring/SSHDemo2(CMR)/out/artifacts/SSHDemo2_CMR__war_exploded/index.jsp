<%--
  Created by IntelliJ IDEA.
  User: yangzhe
  Date: 2017/4/28
  Time: 下午5:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  当前用户名：${sessionScope.user.username}<br>
  <a href="${pageContext.request.contextPath}/customer_find.action">查看所有注册用户</a>
  <a href="customerSearch.jsp" >查询单个用户信息</a><br>
  <a href="${pageContext.request.contextPath}/linkMan_toAddPage.action">新增联系人</a>
  <a href="${pageContext.request.contextPath}/linkMan_list.action">查看联系人</a>

  </body>
</html>
