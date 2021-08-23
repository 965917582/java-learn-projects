<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改员工信息</title>
</head>
<body>

    <%--<h3>员工编号：${empno}</h3>--%>

    <h3>修改员工</h3>
    <form action="${pageContext.request.contextPath}/emp/update" method="post">
        <input hidden="hidden" name="empno" value="${emp.empno}">
        姓名<input type="text" name="ename" value="${emp.ename}"/><br/>
        职位<input type="text" name="job" value="${emp.job}"/><br/>
        管理<input type="number" name="mgr" value="${emp.mgr}"/><br/>
        录取时间<input type="date" name="hiredate"/><br/>
        薪资<input  type="number"  name="sal" value="${emp.sal}" step="0.01"  min="0" onkeyup="this.value= this.value.match(/\d+(\.\d{0,2})?/) ? this.value.match(/\d+(\.\d{0,2})?/)[0] : ''" ><br/>
        福利<input  type="number"  name="comm" value="${emp.comm}" step="0.01"  min="0" onkeyup="this.value= this.value.match(/\d+(\.\d{0,2})?/) ? this.value.match(/\d+(\.\d{0,2})?/)[0] : ''" ><br/>
        部门编号<input type="number" name="deptno" value="${emp.deptno}"/><br/>
        <input type="submit" value="提交">
    </form>

</body>
</html>
