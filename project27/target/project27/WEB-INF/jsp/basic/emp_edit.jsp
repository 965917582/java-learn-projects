<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.pojo.Emp"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  

  </head>
  
  <body>

    <form action="/emp/empManage_editEmp.do" method="post" onsubmit="">
      <table width="500" align="center" style="margin-top:30px" class="inputTable">
        <tr>
          <th>姓名：</th>
          <td>
            <input class="text" name="empName" value="${empName}"/>
            <input type="hidden" name="empId" value="${empId}"/>
          </td>
        </tr>
        <tr>
          <th>电话：</th>
          <td><input class="text" name="tel" value="${tel}"/></td>
        </tr>
        <tr>
          <th>类别：</th>
          <td>
            <select class="text" name="type">
              <c:forEach items="${empTypeList}" var="empType">
                <option value="${empType.type}"
                  <c:if test="${empType.type eq type}">selected</c:if>
                >${empType.empTypeName}</option>
              </c:forEach>
            </select>
          </td>
        </tr>
        <tr>
          <th>部门：</th>
          <td>
            <select class="text" name="deptId">
              <c:forEach items="${deptList}" var="dept">
                <option value="${dept.deptId}"
                  <c:if test="${dept.deptId eq deptId}">selected</c:if>
                >${dept.deptName}</option>
              </c:forEach>
            </select>
          </td>
        </tr>
        <tr>
          <th>备注：</th>
          <td><textarea class="text" name="remark" style="width:300px;height:46px">${remark}</textarea></td>
        </tr>       
      </table>
      <table border="0" width="500" align="center" style="margin-top:20px">
        <tr><td align="center">
            <input type="submit" class="btn ok" value="确定" />
           <input type="button" class="btn cancel" value="取消" onclick="location='${ctx}/emp/empManage_listEmp.do'"/>
        </td></tr>
      </table>
    </form>    
  </body>
</html>
