<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/3/15
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="account/findAll">测试</a>

    <h3>测试添加</h3>
    <form action="account/save" method="post">
        姓名：<input type="text" name="name"/><br>
        金额：<input type="text" name="money"/><br>
        <input type="submit" name="提交"/>

    </form>
</body>
</html>
