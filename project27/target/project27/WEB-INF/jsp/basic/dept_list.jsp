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

    <form action="/emp/deptManage_listDept.do" method="post">
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr>
          <td width="60" align="left">部门名称:</td>
          <td width="180" align="left"><input name="deptName" class="text" value="${deptName}"/></td>
          <td width="60" align="left">部门地址:</td>
          <td width="180" align="left"><input name="address" class="text" value="${address}"/></td>
          
          <td align="right">
            <input type="submit" class="btn find" value="查询"/>
            <c:forEach items="${ListUrl}" var="url">
              <c:if test="${'/emp/deptManage_toAddDept.do' eq url }">
                <input type="button" class="btn ok" style="width:90px" value="添加部门"
                       onclick="location='/emp/deptManage_toAddDept.do'"/>
              </c:if>
            </c:forEach>

          </td>
        </tr>
      </table>
    </form>
    <table class="table" <%--rowNum="15"--%> width="90%" align="center" >
      <tr>
        <th>部门名称</th>
        <th>地址</th>
        <th>电话</th>
        <th>联系人</th>
        <th>备注</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${deptList}" var="adept">
        <tr>
          <td>${adept.deptName}</td>
          <td>${adept.address}</td>
          <td>${adept.tel}</td>
          <td>${adept.linkman}</td>
          <td>${adept.remark}</td>
          <td>
            <c:forEach items="${ListUrl}" var="url">
              <c:if test="${'/emp/deptManage_toEditDept.do' eq url }">
                <a href="${ctx}/emp/deptManage_toEditDept.do?deptId=${adept.deptId}">编辑</a>
              </c:if>
            </c:forEach>
            <c:forEach items="${ListUrl}" var="url">
              <c:if test="${'/emp/deptManage_delDept.do' eq url }">
                <a href="${ctx}/emp/deptManage_delDept.do?deptId=${adept.deptId}" onclick="return confirm('确定要删除吗？');">删除</a>
              </c:if>
            </c:forEach>

          </td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
