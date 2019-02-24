<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录界面</title>
</head>
<body>
<script type="text/javascript" src="/assets/js/jquery-1.8.0.js"></script>
<form action="/sso/login" method="POST">
    <label>用户名:</label><input type="text" name="username" /><br>
    <label>密码:</label><input type="password" name="password" /><br>
    <input type="hidden" name="gotoUrl" value="${gotoUrl}" />
    <input type="submit" value="commit" />
</form>
</body>
</html>