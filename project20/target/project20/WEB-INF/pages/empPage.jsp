<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Emp</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style1.css">
</head>
<body>
    <h3>员工列表</h3>
    <table>
        <tr><th>编号</th><th>姓名</th><th>职位</th><th>管理</th><th>录取时间</th><th>薪资</th><th>奖金</th><th>部门编号</th><th>删除</th><th>修改</th></tr>
        <c:forEach items="${emps}" var="emp" varStatus="s">
            <tr>
                <td>${emp.empno}</td><td>${emp.ename}</td><td>${emp.job}</td><td>${emp.mgr}</td>
                <td><fmt:formatDate type="date"  value="${emp.hiredate}" /></td>
                <td>${emp.sal}</td><td>${emp.comm}</td><td>${emp.deptno}</td>
                <td><a href="${pageContext.request.contextPath}/emp/delete?empno=${emp.empno}">删除</a></td>
                <td><a href="${pageContext.request.contextPath}/emp/updatePage?empno=${emp.empno}">修改</a></td>
            </tr>
        </c:forEach>
    </table>


    <h3>添加员工</h3>
    <form action="${pageContext.request.contextPath}/emp/add" method="post">
        姓名<input type="text" name="ename"/><br/>
        职位<input type="text" name="job"/><br/>
        管理
        <select  name="mgr" id="mgrlist">
            <c:forEach items="${emps}" var="emp">
                <option value="${emp.empno}">${emp.empno}-${emp.ename}</option>
            </c:forEach>
        </select><br/>
        所选管理信息：<div id="mrginfo"></div>
        录取时间<input type="date" name="hiredate"/><br/>
        薪资<input  type="number"  name="sal" step="0.01"  min="0" onkeyup="this.value= this.value.match(/\d+(\.\d{0,2})?/) ? this.value.match(/\d+(\.\d{0,2})?/)[0] : ''" ><br/>
        福利<input  type="number"  name="comm" step="0.01"  min="0" onkeyup="this.value= this.value.match(/\d+(\.\d{0,2})?/) ? this.value.match(/\d+(\.\d{0,2})?/)[0] : ''" ><br/>
        部门编号<input type="number" name="deptno"/><br/>
        <input type="submit" value="提交">
    </form>

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/empPage.js"></script>

</body>
</html>
