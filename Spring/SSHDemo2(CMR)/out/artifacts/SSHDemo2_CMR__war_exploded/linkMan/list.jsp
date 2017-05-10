<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: yangzhe
  Date: 2017/5/2
  Time: 下午1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>已经添加联系人信息列表</title>
</head>
<body>
    <div>当前已添加联系人为：</div>

    <c:forEach var="linkMan" items="${linkManList}">
        姓名：${linkMan.lkmName}
        性别：${linkMan.lkmGender}
        办公室电话：${linkMan.lkmPhone}
        手机号：${linkMan.lkmMobile}
        <%--session 关闭 导致取不到值，需要配置过滤器使session 延时关闭--%>
        客户名：${linkMan.customer.cname}
        <a href="${pageContext.request.contextPath}/linkMan_delete.action?linkId=${linkMan.linkId}">删除</a>
        <a href="${pageContext.request.contextPath}/linkMan_show.action?linkId=${linkMan.linkId}"/>修改</a>
        <br>
    </c:forEach>
    <br>
    <a href="${pageContext.request.contextPath}/linkMan_toAddPage.action">新增联系人</a>&nbsp;&nbsp;&nbsp;

</body>
</html>
