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
        url:'<%=path %>/login_log/pager',
        method:'post'">
    <thead>
    <tr>
        <th data-options="field:'id',width:80,checkbox:true">编号</th>
        <th data-options="field:'phone',width:100">用户名</th>
        <th data-options="field:'loginTime',width:150,formatter:formatDate">登录时间</th>
        <th data-options="field:'loginIp',width:100">登录IP</th>
        <th data-options="field:'isOnline',width:100,formatter:formatLoginStatus">登录状态</th>
    </tr>
    </thead>
</table>

<div id="tb">
    <div>
        <form id="searchForm">
            <input class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入姓名',required:true,validType:'length[0,20]',novalidate:true" name="teacher.name" />
            <input class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入手机号',required:true,validType:'length[0,20]',novalidate:true" name="teacher.phone" />
            <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch('list', 'searchForm');">搜索</a>
        </form>
    </div>
</div>
</body>

<%@include file="../master/footer.jsp"%>

<script>

    $(function () {
        setPagination("list");
    });

    function formatLoginStatus(value, row, index) {
        return value === 0 ? "离线" : "在线";
    }

</script>

</html>
