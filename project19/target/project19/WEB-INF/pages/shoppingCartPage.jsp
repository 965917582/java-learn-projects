<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style1.css">
</head>
<body>
    <a href="${pageContext.request.contextPath}/commodit/commoditPage">商品列表页面</a><br/>
    <a href="${pageContext.request.contextPath}/order/orderPage">订单页面</a>

    <%--表单接收复选框--%>
    <form action="${pageContext.request.contextPath}/order/generateOrder" method="post">
        <table border="1px">
            <tr><td>选择</td><td>商品编号</td><td>商品名称</td><td>商品单价</td><td>商品数量</td><td>总价</td><td>移出购物车</td></tr>
            <c:forEach items="${items}" var="item">
                <tr>
                    <td><input type="checkbox" name="checkComm" value="${item.commodit.commId}"/></td>
                    <td>${item.commodit.commId}</td><td>${item.commodit.commName}</td>
                    <td>${item.commodit.commPrice}</td>
                    <%--以下使用ajax,涉及到复杂的数据同步--%>
                    <%--<td>
                        <span  class="changebtn decreaseCommNum" data-commNum="${item.commoditNum}" data-commId="${item.commodit.commId}"> - </span>
                        <span>${item.commoditNum}</span>
                        <span class="changebtn increaseCommNum" data-commNum="${item.commoditNum}"  data-commId="${item.commodit.commId}"> + </span>
                    </td>--%>

                    <%--以下直接访问控制器--%>
                    <td>
                        <a href="${pageContext.request.contextPath}/cart/decreaseCommNum?commId=${item.commodit.commId}&commNum=${item.commoditNum}" class="decreaseA" data-commNum="${item.commoditNum}"> - </a>
                        ${item.commoditNum}
                        <a href="${pageContext.request.contextPath}/cart/increaseCommNum?commId=${item.commodit.commId}"> + </a>
                    </td>
                    <td>${item.commodit.commPrice * item.commoditNum}</td>
                    <td><a href="${pageContext.request.contextPath}/cart/removeFromCart?commId=${item.commodit.commId}">移出</a></td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" value="生成订单">
    </form>

    <!--生成订单后的回显信息-->
    <span>${msg}</span>

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <%--<script src="${pageContext.request.contextPath}/js/shoppingCart.js"></script>--%>
</body>
</html>
