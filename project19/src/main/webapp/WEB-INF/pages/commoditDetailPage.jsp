<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品详情</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/commodit/commoditPage">商品列表页面</a><br/>
    <a href="${pageContext.request.contextPath}/cart/cartPage">购物车页面</a><br/>
    <a href="${pageContext.request.contextPath}/order/orderPage">订单页面</a><br/>

    <span>商品id：${commodit.commId}</span><br/>
    <span>商品名：${commodit.commName}</span><br/>
    <span>商品单价：${commodit.commPrice}</span>

    <form action="${pageContext.request.contextPath}/cart/addToCart" method="get">
        <input type="text" name="commId" hidden="hidden" value="${commodit.commId}">
        <input type="text" name="commName" hidden="hidden" value="${commodit.commName}">
        <input type="text" name="commPrice" hidden="hidden" value="${commodit.commPrice}">
        输入数量：<input type='text' name="commoditNum" onkeyup="value=value.replace(/^(0+)|[^\d]+/g,'')"/>
        <input type="submit" value="加入购物车"/>
    </form>

    <!--添加购物车条目后的回显信息-->
    <span>${msg}</span>

</body>
</html>
