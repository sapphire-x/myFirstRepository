
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <script>
        window.onload = function(){
            document.getElementById("img_check").onclick = function () {
                this.src = "/checkCodeServlet?" +new Date();
            }


        }
    </script>
    <style>
        div{
            color: red;
        }

    </style>
</head>

<body>
<form action="/loginServlet" method="post">
    用户名：<input name="username" type="text" placeholder="请输入用户名"><br>
    密码：<input name="password" type="text" placeholder="请输入密码"><br>
    验证码：<input name="checkCode" type="text" placeholder="请输入验证码"><br>
    <img src="/checkCodeServlet" id="img_check"><br>
    <input type="submit" value="登录"><br>

 <%--   <div>
        <%=request.getSession().getAttribute("error_check") == null ? " " :request.getSession().getAttribute("error_check")%>
    </div>
 --%>

    <div>
        ${error_check}
    </div>
    <div>
        ${error_up}
    </div>
    <%--
     ${}  { 从域中获取数据，域中有，直接输出；如果域中没有这和数据，什么都不显示}
        从域中获取数据，域对象 jsp中有4个，servlet中有3个

        如果域中有相同key,则会从小到大获取
        request>session>servletContext
    --%>
</form>
</body>
</html>
