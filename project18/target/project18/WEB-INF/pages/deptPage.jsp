<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>部门</title>
</head>
<body>
    <h3>部门列表</h3>
    <table border="1px solid">
        <tr><th>部门编号</th><th>部门名称</th><th>删除</th><th>修改</th></tr>
        <c:forEach items="${depts}" var="dept">
            <tr><td>${dept.deptno}</td><td>${dept.deptname}</td><td><a href="${pageContext.request.contextPath}/dept/delete?deptno=${dept.deptno}">删除</a></td><td><a href="${pageContext.request.contextPath}/dept/updatePage?deptno=${dept.deptno}">修改</a></td></tr>
        </c:forEach>
    </table>

    <h3>添加部门</h3>
    <form action="${pageContext.request.contextPath}/dept/add">
        部门编号<input type="number" name="deptno" /><br/>
        部门名称<input type="text" name="deptname"/><br/>
        <input type="submit" value="增加">
    </form>

</body>
</html>
