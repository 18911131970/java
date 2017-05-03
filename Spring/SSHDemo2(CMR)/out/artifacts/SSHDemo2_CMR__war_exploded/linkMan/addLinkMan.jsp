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
          action="${pageContext.request.contextPath}/linkMan_addLinkMan.action">
        所属客户：
        <select name="customer.cid">
            <c:forEach var="customer" items="${listCustomer}">
                <option value="${customer.cid}">${customer.cname}</option>
            </c:forEach>
        </select><br>

        联系人名称：<input type="text" name="lkmName"><br>
        联系人性别：<input type="radio" name="lkmGender" value="famale">女
                  <input type="radio" name="lkmGender" value="male">男<br>
        联系人办公电话：<input type="text" name="lkmPhone"><br>
        联系人手机：<input type="text" name="lkmMobile"><br>

        选择文件：<input type="file" name="upload"><br>
        <input type="submit" value="保存">

    </form>

</body>
</html>
