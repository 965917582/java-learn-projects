<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.pojo.SysMenu"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>菜单管理</title>   
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript">
      $().ready(function() {
        if ($("input[name=refreshTree]").val() == "true") {
          window.parent.loadTree();
        }
      });
    </script> 
  </head>

  <body>
    <input type="hidden" name="refreshTree" value="${refreshTree}" />
    <table width="98%" align="center" border="0">
      <tr><td>当前菜单：<span style="font-weight:bold;color:#000099">${menu.menuName}</span></td></tr>
    </table>
    <table width="98%" align="center" class="table">
      <tr>       
        <th>菜单类型</th>
        <th>菜单动作</th>       
        <th>说明</th>
        <th>父菜单</th>
        <th>操作</th>
      </tr>
      <tr>
        <td>${menu.type}</td>
        <td>${menu.sysAction.actionName}</td>
        <td>${menu.remark}</td>
        <td><a href="/menu/menu_detail?menuId=${parentMenu.menuId}&type=${parentMenu.type}">${parentMenu.menuName}</a></td>
        <td>        
               <c:if test="${menu.menuId != 0}">
                 <c:forEach items="${ListUrl}" var="url">
                   <c:if test="${'/menu/menuManage_toEditMenu.do' eq url }">
                     <a href="/menu/menuManage_toEditMenu.do?menuId=${menu.menuId}&parentId=${menu.parentId}&actionId=${menu.actionId}">编辑</a>
                   </c:if>
                 </c:forEach>
               </c:if>
           <c:if test="${menu.type == 1}">
             <c:forEach items="${ListUrl}" var="url">
               <c:if test="${'/menu/toAddSubMenu' eq url }">
                 <a href="${pageContext.request.contextPath}/menu/toAddSubMenu?menuId=${menu.menuId}&type=${menu.type}">添加子菜单</a>
               </c:if>
             </c:forEach>
           </c:if>
           <c:if test="${menu.type == 2}">
             <c:forEach items="${ListUrl}" var="url">
               <c:if test="${'/menu/toAddAction' eq url }">
                 <a href="${pageContext.request.contextPath}/menu/toAddAction?menuId=${menu.menuId}">添加动作</a>
               </c:if>
             </c:forEach>
           </c:if>
        </td>
      </tr>
    </table>
    <s:if test="subMenuList != null">
      <table width="98%" align="center" border="0" style="margin-top:15px">
        <tr><td>子菜单列表：</td></tr>
      </table>
      <table width="98%" align="center" class="table">
        <tr>
          <th>菜单名称</th>
          <th>菜单类型</th>
          <th>菜单动作</th>       
          <th>说明</th>        
          <th>操作</th>       
        </tr>     
        <c:forEach items="${subMenuList}" var="subMenu">
          <tr>
            <td>
              <c:if test="${subMenu.type eq 3}">
                ${subMenu.menuName}
              </c:if>
              <c:if test="${subMenu.type != 3}">
                <a href="/menu/menu_detail?menuId=${subMenu.menuId}&type=${subMenu.type}">${subMenu.menuName}</a></td>
              </c:if>
            <td>${subMenu.type}</td>
            <td>${subMenu.sysAction.actionName}</td>
            <td>${subMenu.remark}</td>
            <td>
              <c:forEach items="${ListUrl}" var="url">
              <c:if test="${'/menu/menuManage_delMenu.do' eq url }">
                <a href="/menu/menuManage_delMenu.do?menuId=${subMenu.menuId}&parentId=${subMenu.parentId}&type=${subMenu.type}" onclick="return confirm('此操作将删除所有相关子菜单或动作,确定要删除吗?');">删除</a>
            </c:if>
            </c:forEach>
<%--              <a href="menuManage_upMenu.do?menuId=${subMenu.menuId}">上移</a>
                  <a href="menuManage_downMenu.do?menuId=${subMenu.menuId}">下移</a>--%>
            </td>
          </tr>
        </c:forEach>
      </table>
    </s:if>    
    <s:elseif test="normalActionList!=null || authorActionList!=null">
       <table width="98%" align="center" border="0" style="margin-top:15px">
        <tr><td>普通动作列表：</td></tr>
      </table>
      <table width="98%" align="center" class="table">
        <tr>
          <th>动作名称</th>
          <th>动作类型</th>
          <th>说明</th>        
          <th>操作</th>       
        </tr>     
        <c:forEach items="${normalActionList}" var="normalAction">
          <tr>
            <td>${normalAction.actionName}</td>
            <td>普通动作</td>
            <td <c:if test="${normalAction.actionId == menu.actionId}">style="color:red"</c:if>>${normalAction.remark}</td>
            <td>
              <c:if test="${normalAction.actionId != menu.actionId}">
                <c:forEach items="${ListUrl}" var="url">
                  <c:if test="${'/menu/menuManage_toEditAction.do' eq url }">
                    <a href="/menu/menuManage_toEditAction.do?actionId=${normalAction.actionId}&menuId=${normalAction.menuId}">编辑</a>
                  </c:if>
                </c:forEach>

                <c:forEach items="${ListUrl}" var="url">
                  <c:if test="${'/menu/menuManage_delAction.do' eq url }">
                    <a href="/menu/menuManage_delAction.do?actionId=${normalAction.actionId}&menuId=${normalAction.menuId}" onclick="return confirm('确定要删除吗?');">删除</a>
                  </c:if>
                </c:forEach>

              </c:if>
            </td>
          </tr>
        </c:forEach>
      </table>
       <table width="98%" align="center" border="0" style="margin-top:15px">
        <tr><td>授权动作列表：</td></tr>
      </table>
      <table width="98%" align="center" class="table">
        <tr>
          <th>动作名称</th>
          <th>动作类型</th>
          <th>说明</th>        
          <th>操作</th>       
        </tr>     
        <c:forEach items="${authorActionList}" var="authorAction">
          <tr>
            <td>${authorAction.actionName}</td>
            <td>授权动作</td>
            <td>${authorAction.remark}</td>
            <td>
              <c:forEach items="${ListUrl}" var="url">
                <c:if test="${'/menu/menuManage_toEditAction.do' eq url }">
                  <a href="/menu/menuManage_toEditAction.do?actionId=${authorAction.actionId}&menuId=${authorAction.menuId}">编辑</a>
                </c:if>
              </c:forEach>
              <c:forEach items="${ListUrl}" var="url">
                <c:if test="${'/menu/menuManage_delAction.do' eq url }">
                  <a href="/menu/menuManage_delAction.do?actionId=${authorAction.actionId}&menuId=${authorAction.menuId}" onclick="return confirm('确定要删除吗?');">删除</a>
                </c:if>
              </c:forEach>

            </td>
          </tr>
        </c:forEach>
      </table>
    </s:elseif>
  </body>
</html>
