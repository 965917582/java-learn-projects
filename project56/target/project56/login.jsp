<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/6/25
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <%
        String service = (String)request.getAttribute("service");
        System.out.println(service);
    %>
    <a href="http://localhost:8081/sso/login?username=zs&password=123&service=<%=service%>">登录</a>
    <%--<form action="http://localhost:8081/sso/login?username=za&password=123&service=${service}" >
        账户名
        <input type="text" nane="username" id="account"><br>
        密码
        <input type="password" nane="password" id="pwd"><br>
        <input type="text" nane="service" value="<%=service%>" hidden="hidden"><br>
        <input  type="submit" id="submit" value="登录"><br>

    </form>--%>
</body>
</html>
