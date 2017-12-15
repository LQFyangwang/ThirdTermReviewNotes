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
        url:'<%=path %>/stu/pager_criteria',
        method:'post'">
    <thead>
    <tr>
        <th data-options="field:'id',width:80,checkbox:true">编号</th>
        <th data-options="field:'num',width:100">学号</th>
        <th data-options="field:'realName',width:100">姓名</th>
        <th data-options="field:'clazzId',width:100,hidden:true,formatter:formatterClazzId">班级</th>
        <th data-options="field:'clazzTitle',width:100,formatter:formatterClazzTitle">班级</th>
    </tr>
    </thead>
</table>

<div id="tb">
    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" onclick="openWin('addWin');">添加</a>
    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEditWin1('list')">编辑</a>
    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" onclick="openDetailWin('list')">查看详情</a>
    <div>
        <form id="searchForm">
            <input class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入学号',required:true,validType:'length[0,20]',novalidate:true" name="stu.num" />
            <input class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入姓名',required:true,validType:'length[0,20]',novalidate:true" name="stu.realName" />
            <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch('list', 'searchForm');">搜索</a>
        </form>
    </div>
</div>

<%@include file="stu_add.jsp"%>
<%@include file="stu_edit.jsp"%>
<%@include file="stu_detail.jsp"%>

</body>

<%@include file="../master/footer.jsp"%>

<script>
    $(function () {

        $('#clazz').combobox({
            url: contextPath + '/class/all',
            valueField:'id',
            textField:'text'
        });

        $("#detailWin").window(
            {
                onClose:function() {
                    $("#editDetailForm").form("clear");
                }
            }
        );
    });

    function formatterClazzId(value,row,index) {
        return row.clazz.id;
    }

    function formatterClazzTitle(value,row,index) {
        return row.clazz.title;
    }

    function openEditWin1(listId) {
        var row = $("#" + listId).datagrid("getSelected");
        if (row) {
            $("#editForm").form("load", datagridRowHandler(row, "stu"));
            $('#clazzEdit').combobox({
                url: contextPath + '/class/all?clazzId=' + row.clazz.id,
                valueField:'id',
                textField:'text'
            });
            openWin("editWin");
        } else {
            showAlert("请选择需要修改的数据 ");
        }
    }

    function openDetailWin(listId) {
        var row = $("#" + listId).datagrid("getSelected");
        if (row) {
            var stuId = row.id;
            $.post(contextPath + "/stuDetail/get",
                {'stuDetailId':stuId},
                function (data) {
                    $("#editDetailForm").form("load", datagridRowHandler(data, "stuDetail"));
                    $("#stuId").val(stuId);
                    openWin("detailWin");
                },
                'json'
            );
        } else {
            showAlert("请选择需要查看详情的数据或者双击行查看详情");
        }
    }


</script>

</html>
