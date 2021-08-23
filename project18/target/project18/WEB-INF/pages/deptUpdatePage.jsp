<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>更新部门信息</title>
</head>
<body>
    <h3>更新部门</h3>
    <form action="${pageContext.request.contextPath}/dept/update">
        <input hidden="hidden" name="deptno" value="${dept.deptno}">
        部门名称<input type="text" name="deptname" value="${dept.deptname}"/><br/>
        <input type="submit" value="提交">
    </form>

</body>
</html>
