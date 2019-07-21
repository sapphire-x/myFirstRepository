<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/7/21
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
登录成功，欢迎<%=request.getSession().getAttribute("user") %>成功页面
</body>
</html>
