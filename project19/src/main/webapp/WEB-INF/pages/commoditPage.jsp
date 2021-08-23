<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/cart/cartPage">购物车页面</a><br/>
    <a href="${pageContext.request.contextPath}/order/orderPage">订单页面</a>
    <table border="1px">
        <tr><th>商品id</th><th>商品名</th><th>单价</th><th>商品详情</th></tr>
        <c:forEach items="${commodits}" var="commodit">
            <tr><td>${commodit.commId}</td><td>${commodit.commName}</td><td>${commodit.commPrice}</td><td><a href="${pageContext.request.contextPath}/commodit/detailPage?commId=${commodit.commId}">详情</a></td></tr>
        </c:forEach>
    </table>
</body>
</html>
