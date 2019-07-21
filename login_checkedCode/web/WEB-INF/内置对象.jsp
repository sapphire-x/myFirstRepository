<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/7/21
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //共享数据
        pageContext.setAttribute("msg","hello");
        //获取其他八个内置对象
        ServletRequest request1 = pageContext.getRequest();
        HttpSession session1 = pageContext.getSession();
        ServletContext servletContext = pageContext.getServletContext();
        ServletResponse response1 = pageContext.getResponse();
        JspWriter out1 = pageContext.getOut();
        Object page1 = pageContext.getPage();
        Exception exception = pageContext.getException();
        ServletConfig servletConfig = pageContext.getServletConfig();

    %>
</body>
</html>
