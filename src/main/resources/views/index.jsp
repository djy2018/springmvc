<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <form method="post" action="/springmvc/testModelAttribute">
        <input type="hidden" name="id" value="1" />
        <br>
        <br>
        <input type="text" name="username" value="djy" />
        <br>
        <input type="text" name="email" value="960925yong@gmail.com" />
        <br>
        <input type="text" name="age" value="15" />
        <br>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>