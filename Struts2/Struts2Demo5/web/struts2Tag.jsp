<%--
  Created by IntelliJ IDEA.
  User: yangzhe
  Date: 2017/4/20
  Time: 上午11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <input type="radio" name="sex" value="nv">女
    <input type="radio" name="sex" value="nan">男

    <s:form>
        <%--普通文本--%>
        <s:textfield name="username" label="用户名"></s:textfield>
        <%--密码文本--%>
        <s:password name="password" label="密码"></s:password>

        <!--
        单选框
        -->
        <%--value与显示相同--%>
        <s:radio list="{'女','男'}" name="sex" label="性别"></s:radio>
        <%--value与显示不同--%>
        <s:radio list="#{'nv':'女','nan':'男'}" name="sex1" label="性别"></s:radio>

        <%--复选框--%>
        <s:checkboxlist list="{'1','2','3','4'}" name="like" label="爱好"></s:checkboxlist>
        <%--下拉选框--%>
        <s:select list="{'本科','硕士','博士'}" name="college" label="学历"></s:select>

        <%--多文本输入--%>
        <s:textarea rows="5" cols="5" name="description" label="描述"></s:textarea>

        <%--文件上传--%>
        <s:file name="file" label="上传文件"></s:file>

        <%--隐藏项--%>
        <s:hidden name="hidden" value="隐藏内容"></s:hidden>

        <%--提交按钮--%>
        <s:submit value="提交"></s:submit>

        <%--重置按钮--%>
        <s:reset value="重置"></s:reset>

    </s:form>
</body>
</html>
