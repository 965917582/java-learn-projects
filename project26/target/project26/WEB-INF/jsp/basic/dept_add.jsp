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
  <form action="/emp/deptManage_addDept.do" method="post" onsubmit="return checkFrm();">
      <table width="500" align="center" style="margin-top:30px" class="inputTable">
        <tr>
          <th>部门名称：</th>
          <td><input class="text" name="deptName"/></td>
        </tr>
        <tr>
          <th>电话：</th>
          <td><input class="text" name="tel"/></td>
        </tr>
        <tr>
          <th>联系人：</th>
          <td><input class="text" name="linkman"/></td>
        </tr>
        <tr>
          <th>地址：</th>
          <td><textarea class="text" name="address" style="width:300px;height:46px"/></textarea></td>
        </tr>
        <tr>
          <th>备注：</th>
          <td><textarea class="text" name="remark" style="width:300px;height:46px"/></textarea></td>
        </tr>
      
      </table>
      <table border="0" width="500" align="center" style="margin-top:20px">
        <tr><td align="center">
          <input type="submit" class="btn ok" value="确定" />
          <input type="button" class="btn cancel" value="取消" onclick="location='${ctx}/emp/deptManage_listDept.do'"/>
        </td></tr>
      </table>
    </form>    
  </body>
</html>
