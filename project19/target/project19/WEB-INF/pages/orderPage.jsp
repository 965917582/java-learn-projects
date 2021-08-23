<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/commodit/commoditPage">商品列表页面</a><br/>
    <a href="${pageContext.request.contextPath}/cart/cartPage">购物车页面</a>
    <table border="1px">
        <th>订单编号</th><th>提交时间</th><th>商品</th><th>单价</th><th>数量</th><th>总价</th><th>取消订单</th></tr>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.orderId}</td>
                <td>${order.orderSubmitTime}</td>
                <td></td><td></td><td></td><td></td>
                <td><a href="${pageContext.request.contextPath}/order/cancelOrder?orderId=${order.orderId}">取消</a></td>
            </tr>
            <c:forEach items="${order.orderCommodits}" var="commodit">
                <tr>
                    <td></td><td></td>
                    <td>${commodit.commName}</td>
                    <td>${commodit.commPrice}</td>
                    <td>${commodit.commNum}</td>
                    <td>${commodit.commNum * commodit.commPrice}</td>
                </tr>
            </c:forEach>
        </c:forEach>
    </table>

</body>
</html>
