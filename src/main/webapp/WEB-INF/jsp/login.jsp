<%--
  Created by IntelliJ IDEA.
  User: kazuha
  Date: 2023/2/24
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>验证你的用户信息</h2>
    <b style="color: red">${msg}</b>
    <form action="login" method="post">
        <label for="username">用户名：</label>
        <input type="text" name="username" id="username"><br>
        <label for="password">密码：</label>
        <input type="password" name="password" id="password"><br>
        <button type="submit">登录</button>
    </form>
</body>
</html>
