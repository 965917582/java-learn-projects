<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.pojo.SysAction"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>菜单管理</title>   
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript" src="${ctx}/js/dev/menu.js"></script> 
  </head>

  <body>

    <form action="/menu/addAction" method="post" onsubmit="return validateActionFrm();">
    <table width="500" align="center" class="inputTable" style="margin-top:15px">
      <tr>
        <th>所属菜单：</th>
        <td>${menu.menuName}         
            <input type="hidden" name="menuId" value="${menu.menuId}"/>
        </td>
      </tr>
      <tr  id="menuNameRow">
        <th>动作：</th>
        <td><input name="actionName" class="text"/></td>
      </tr>
      <tr>
        <th>动作类型：</th>
        <td>
          <input type="radio" name="type" value="<%=SysAction.ACTIONTYPE_NORMAL%>" checked/>普通动作
          <input type="radio" name="type" value="<%=SysAction.ACTIONTYPE_AUTHOR%>"/>授权动作
        </td>
      </tr>      
      <tr>
        <th>动作说明</th>
        <td><textarea name="remark" class="text" style="width:300px;height:56px"></textarea></td>
      </tr>
    </table>
    <table width="500" align="center" style="margin-top:15px">
      <tr><td align="center">
        <input type="submit" class="btn ok" value="确定"/>
        <input type="button" class="btn cancel" value="取消" onclick="location='/menu/menu_detail?menuId=${menu.menuId}'"/>
      </td></tr>
    </table>
    </form>
  </body>
</html>
