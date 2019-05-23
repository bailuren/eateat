<%--
  Created by IntelliJ IDEA.
  User: YP
  Date: 2019/5/14
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/admin/logincheck" method="post">
    username:<input type="text" name="username" value="yanpeng">
    password:<input type="password" name="password" value="123456">
    <input type="submit" value="提交">
</form>
</body>
</html>
