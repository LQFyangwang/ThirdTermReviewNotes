<%--
  Created by IntelliJ IDEA.
  User: Master
  Date: 2017/7/5
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>Title</title>
    <%@include file="../master/header.jsp"%>
</head>
<body>

<table id="list" class="easyui-datagrid"
       data-options="
        singleSelect:true,
        collapsible:true,
        rownumbers:true,
        pagination:true,
        pageSize:10,
        toolbar:'#tb',
        url:'<%=path %>/class/pager_criteria',
        method:'post'">
    <thead>
    <tr>
        <th data-options="field:'id',width:80,checkbox:true">编号</th>
        <th data-options="field:'title',width:100">名称</th>
    </tr>
    </thead>
</table>

<div id="tb">
    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" onclick="openWin('addWin');">添加</a>
    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEditWin('list', 'editWin', 'editForm', 'clazz');">编辑</a>
    <div>
        <form id="searchForm">
            <input class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入班级名称',required:true,validType:'length[0,20]',novalidate:true" name="clazz.title" />
            <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch('list', 'searchForm');">搜索</a>
        </form>
    </div>
</div>

<div id="addWin" class="easyui-window normal-win" title="添加班级" data-options="closed:true">
    <form id="addForm">
        <table>
            <tr>
                <td><label>名称</label></td>
                <td>
                    <input  name="clazz.title" class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入班级名称',required:true,validType:'length[2,20]',novalidate:true" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="save('/class/save', 'addForm', 'list', 'addWin');">添加</a></td>
            </tr>
        </table>
    </form>
</div>

<div id="editWin" class="easyui-window normal-win" title="修改班级" data-options="closed:true">
    <form id="editForm">
        <input type="hidden" name="clazz.id" />
        <table>
            <tr>
                <td><label>名称</label></td>
                <td>
                    <input  name="clazz.title" class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入班级名称',required:true,validType:'length[2,20]',novalidate:true" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="edit('/class/update', 'editForm', 'list', 'editWin')">修改</a></td>
            </tr>
        </table>
    </form>
</div>

</body>

<%@include file="../master/footer.jsp"%>
</html>
