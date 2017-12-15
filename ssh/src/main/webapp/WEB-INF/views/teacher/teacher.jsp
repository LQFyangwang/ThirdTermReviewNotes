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
        url:'<%=path %>/teacher/pager_criteria',
        method:'post'">
    <thead>
    <tr>
        <th data-options="field:'id',width:80,checkbox:true">编号</th>
        <th data-options="field:'name',width:100">姓名</th>
        <th data-options="field:'phone',width:100">手机号</th>
    </tr>
    </thead>
</table>

<div id="tb">
    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" onclick="openWin('addWin');">添加</a>
    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEditWin('list', 'editWin', 'editForm', 'teacher')">编辑</a>
    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" onclick="openClazzWin()">分配班级</a>
    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" onclick="openClazzInfoWin()">查看班级</a>
    <div>
        <form id="searchForm">
            <input class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入姓名',required:true,validType:'length[0,20]',novalidate:true" name="teacher.name" />
            <input class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入手机号',required:true,validType:'length[0,20]',novalidate:true" name="teacher.phone" />
            <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch('list', 'searchForm');">搜索</a>
        </form>
    </div>
</div>

<div id="addWin" class="easyui-window normal-win" title="添加教师" data-options="closed:true">
    <form id="addForm">
        <table>
            <tr>
                <td><label>姓名</label></td>
                <td>
                    <input  name="teacher.name" class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入姓名',required:true,validType:'length[2,20]',novalidate:true" />
                </td>
            </tr>
            <tr>
                <td><label>手机号</label></td>
                <td>
                    <input  name="teacher.phone" class="easyui-numberbox easyui-validatebox" data-options="prompt:'请输入手机号',required:true,validType:'length[11,11]',novalidate:true" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="save('/teacher/save', 'addForm', 'list', 'addWin');">添加</a></td>
            </tr>
        </table>
    </form>
</div>

<div id="editWin" class="easyui-window normal-win" title="修改教师" data-options="closed:true">
    <form id="editForm">
        <input type="hidden" name="teacher.id" />
        <table>
            <tr>
                <td><label>姓名</label></td>
                <td>
                    <input  name="teacher.name" class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入姓名',required:true,validType:'length[2,20]',novalidate:true" />
                </td>
            </tr>
            <tr>
                <td><label>手机号</label></td>
                <td>
                    <input  name="teacher.phone" class="easyui-numberbox easyui-validatebox" data-options="prompt:'请输入手机号',required:true,validType:'length[11,11]',novalidate:true" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="edit('/teacher/update', 'editForm', 'list', 'editWin')">修改</a></td>
            </tr>
        </table>
    </form>
</div>


<div id="clazzWin" class="easyui-window large-win" title="分配班级" data-options="closed:true">
    <table id="clazzList" class="easyui-datagrid"
           data-options="
        singleSelect:false,
        collapsible:true,
        rownumbers:true,
        pagination:true,
        pageSize:10,
        toolbar:'#clazzTb'">
        <thead>
        <tr>
            <th data-options="field:'id',width:80,checkbox:true">编号</th>
            <th data-options="field:'title',width:100">名称</th>
        </tr>
        </thead>
    </table>

    <div id="clazzTb">
        <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" onclick="confirmClazz();">确认选择</a>
        <div>
            <form id="clazzSearchForm">
                <input class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入班级名称',required:true,validType:'length[0,20]',novalidate:true" name="clazz.title" />
                <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch('clazzList', 'clazzSearchForm');">搜索</a>
            </form>
        </div>
    </div>
</div>

<div id="clazzInfoWin" class="easyui-window large-win" title="班级信息" data-options="closed:true">
    <table id="clazzInfoList" class="easyui-datagrid"
           data-options="
        singleSelect:false,
        collapsible:true,
        rownumbers:true,
        pagination:true,
        pageSize:10">
        <thead>
        <tr>
            <th data-options="field:'id',width:80,checkbox:true">编号</th>
            <th data-options="field:'title',width:100">名称</th>
        </tr>
        </thead>
    </table>
</div>

</body>

<%@include file="../master/footer.jsp"%>

<script>
    function openClazzWin() {
        var row = $("#list").datagrid("getSelected");
        if (row) {
            openWin("clazzWin");
            var options = getPagerOptions('clazzList');
            $("#clazzList").datagrid({
                url:contextPath + '/class/pager_criteria',
                method:'post',
                pageSize:options.pageSize
            });
        } else {
            showAlert("请选择需要分配班级的教师");
        }
    }

    function confirmClazz() {
        var row = $("#list").datagrid("getSelected");
        var rows = $("#clazzList").datagrid("getSelections");
        if (rows !== null && rows.length > 0) {
            var classIds = "";
            for (var i = 0, len = rows.length; i < len; i++) {
                if (classIds === "") {
                    classIds = rows[i].id;
                } else {
                    classIds = classIds + "," + rows[i].id
                }
            }
            $.post(contextPath + "/teacher/save_class",
                {
                    'teacherId':row.id,
                    'classIds':classIds
                },
                function (data) {
                    if (data.result === 'success') {
                        closeWin("clazzWin");
                    } else {
                        showAlert(data.message);
                    }
                }
            )
        } else {
            showAlert("请选择需要分配的班级")
        }
    }

    function openClazzInfoWin() {
        var row = $("#list").datagrid("getSelected");
        if (row) {
           openWin("clazzInfoWin");
            $("#clazzInfoList").datagrid({
                url:contextPath + '/teacher/class',
                method:'post',
                queryParams:{
                    teacherId:row.id
                }
            });
        } else {
            showAlert("请选择需要查看班级的教师");
        }
    }
</script>

</html>
