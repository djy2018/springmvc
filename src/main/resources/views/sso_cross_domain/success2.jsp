<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>DEMO2登录成功界面</title>
</head>
<body>
   欢迎登录Demo2
   <c:forEach var="url" items="${hiddenUrl}">
       <iframe src="${url}" width="0px" height="0px" style="display: none"></iframe>
   </c:forEach>
</body>
</html>