<%--
  Created by IntelliJ IDEA.
  User: yangzhe
  Date: 2017/5/3
  Time: 下午5:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>添加联系人</title>
</head>
<body>
    <form name="form1" id="form1" method="post" enctype="multipart/form-data"
          action="${pageContext.request.contextPath}/linkMan_updataLinkMan.action">
        所属客户：
        <select name="customer.cid">
            <c:forEach var="customer" items="${listCustomer}">
                <%--<c:if test="${linkMan.customer.cid == customer.cid}">selected</c:if>--%>
                <%--<option  value="${customer.cid}" >${customer.cname}</option>--%>
                <option <c:if test="${linkMan.customer.cid == customer.cid}">selected</c:if> value="${customer.cid}">${customer.cname}</option>

            </c:forEach>
        </select>
        <br>

        联系人名称：<input type="text" name="lkmName" value="${linkMan.lkmName}"><br>
        联系人性别：<input type="radio" name="lkmGender" <c:if test="${linkMan.lkmGender ==  'famale'}">checked</c:if>  value="famale">女
                  <input type="radio" name="lkmGender" <c:if test="${linkMan.lkmGender ==   'male'}">checked</c:if>  value="male">男<br>
        联系人办公电话：<input type="text" name="lkmPhone" value="${linkMan.lkmPhone}"><br>
        联系人手机：<input type="text" name="lkmMobile" value="${linkMan.lkmMobile}" ><br>
        选择文件：<input type="file" name="upload"><br>

        <input type="hidden" name="linkId" value="${linkMan.linkId}">

        <input type="submit" value="保存">

    </form>

</body>
</html>
