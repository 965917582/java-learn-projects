<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
  </head>
 
  <body>

    <form action="/emp/empManage_listEmp.do" method="post">
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr>
          <td width="60" align="left">员工姓名:</td>
          <td width="180" align="left"><input type="text"  name="empName" class="text" value="${emp.empName}"/></td>
          <td align="right">
            <input type="submit" class="btn find" value="查询"/>
            <c:forEach items="${ListUrl}" var="url">
              <c:if test="${'/emp/empManage_toAddEmp.do' eq url }">
                <input type="button" class="btn ok" style="width:90px" value="添加员工"
                       onclick="location='/emp/empManage_toAddEmp.do'"/>
              </c:if>
            </c:forEach>

          </td>
        </tr>
      </table>
    </form>
    <table class="table" <%--rowNum="15"--%> width="90%" align="center" >
      <tr>
        <th>姓名</th>        
        <th>电话</th>
        <th>类别</th>
        <th>部门</th>
        <th>备注</th>
        <%--<th>系统帐号</th>--%>
        <th>操作</th>
      </tr>
      <c:forEach items="${empList}" var="aemp">
        <tr>
          <td>${aemp.empName}</td>
          <td>${aemp.tel}</td>
          <td>${aemp.empTypeName}</td>
          <td>${aemp.deptName}</td>
          <td>${aemp.remark}</td>
          <td>
            <c:forEach items="${ListUrl}" var="url">
                    <c:if test="${'/emp/empManage_toEditEmp.do' eq url }">
                       <a href="${ctx}/emp/empManage_toEditEmp.do?empId=${aemp.empId}">编辑</a>
                     </c:if>
            </c:forEach>
            <c:forEach items="${ListUrl}" var="url">
              <c:if test="${'/emp/empManage_delEmp.do' eq url }">
                <a href="${ctx}/emp/empManage_delEmp.do?empId=${aemp.empId}" onclick="return confirm('确定要删除吗？');">删除</a>
              </c:if>
            </c:forEach>

          </td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
