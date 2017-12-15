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
        url:'<%=path %>/cash/pager_criteria',
        method:'post'">
    <thead>
    <tr>
        <th data-options="field:'id',width:80,checkbox:true">编号</th>
        <th data-options="field:'money',width:100">金额</th>
        <th data-options="field:'customer',width:100">客户名称</th>
        <th data-options="field:'cashType',width:100">收支类型</th>
        <th data-options="field:'payType',width:100">支付方式</th>
        <th data-options="field:'cashTime',width:150,formatter:formatDate">收支时间</th>
        <th data-options="field:'createTime',width:150,formatter:formatDate">创建时间</th>
    </tr>
    </thead>
</table>

<div id="tb">
    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" onclick="openWin('addWin');">添加</a>
    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEditWin('list', 'editWin', 'editForm')">编辑</a>
    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" onclick="exportExcel('list')">导出Excel</a>
    <div>
        <form id="searchForm">
            <input class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入最大金额',required:false,validType:'length[0,20]',novalidate:true" name="money" />
            <input class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入客户名称',required:false,validType:'length[0,20]',novalidate:true" name="customer" />
            <input class="easyui-datetimebox" name="cashTime" data-options="prompt:'请输入最大支付时间',required:false,novalidate:true,showSeconds:true"/>
            <input class="easyui-datetimebox" name="createTime" data-options="prompt:'请输入最大创建时间',required:false,novalidate:true,showSeconds:true"/>
            <br/>
            <input class="easyui-combobox easyui-validatebox cashTypeParent" data-options="prompt:'请选择收支类别',required:false,validType:'length[0,20]',novalidate:true" name="pid" />
            <input class="easyui-combobox easyui-validatebox cashType" data-options="prompt:'请选择收支子类别',required:false,validType:'length[0,20]',novalidate:true" name="cashType" />
            <input class="easyui-combobox easyui-validatebox payType" data-options="prompt:'请选择支付方式',required:false,validType:'length[0,20]',novalidate:true" name="payType" />
            <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch('list', 'searchForm');">搜索</a>
            <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearchAll('list', 'searchForm');">搜索所有</a>
        </form>
    </div>
</div>

<div id="addWin" class="easyui-window normal-win" title="添加现金流水" data-options="closed:true">
    <form id="addForm">
        <table>
            <tr>
                <td><label>客户名称</label></td>
                <td>
                    <input  name="customer" class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入客户名称',required:true,validType:'length[2,20]',novalidate:true" />
                </td>
            </tr>
            <tr>
                <td><label>收入或支出</label></td>
                <td>
                    <input class="easyui-combobox easyui-validatebox cashTypeParent" data-options="prompt:'请选择收支类别',required:true,validType:'length[0,20]',novalidate:true" name="pid" />
                </td>
            </tr>
            <tr>
                <td><label>收支子类别</label></td>
                <td>
                    <input class="easyui-combobox easyui-validatebox cashType" data-options="prompt:'请选择收支子类别',required:true,validType:'length[0,20]',novalidate:true" name="cashType" />
                </td>
            </tr>
            <tr>
                <td><label>金额</label></td>
                <td>
                    <input  name="money" class="easyui-numberbox easyui-validatebox" data-options="prompt:'请输入金额',required:true,validType:'length[0,12]',novalidate:true" />
                </td>
            </tr>
            <tr>
                <td><label>支付方式</label></td>
                <td>
                    <input class="easyui-combobox easyui-validatebox payType" data-options="prompt:'请选择支付方式',required:true,validType:'length[0,20]',novalidate:true" name="payType" />
                </td>
            </tr>
            <tr>
                <td><label>收支时间</label></td>
                <td>
                    <input class="easyui-datetimebox" name="cashTime" data-options="prompt:'请选择收支时间',required:true,novalidate:true,showSeconds:true"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="save('/cash/save', 'addForm', 'list', 'addWin');">添加</a></td>
            </tr>
        </table>
    </form>
</div>

<div id="editWin" class="easyui-window normal-win" title="修改现金流水" data-options="closed:true">
    <form id="editForm">
        <input type="hidden" name="id" />
        <table>
            <tr>
                <td><label>客户名称</label></td>
                <td>
                    <input  name="customer" class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入客户名称',required:true,validType:'length[2,20]',novalidate:true" />
                </td>
            </tr>
            <tr>
                <td><label>收入或支出</label></td>
                <td>
                    <input id="cashTypeParent" class="easyui-combobox easyui-validatebox cashTypeParent" data-options="prompt:'请选择收支类别',required:true,validType:'length[0,20]',novalidate:true" name="pid" />
                </td>
            </tr>
            <tr>
                <td><label>收支子类别</label></td>
                <td>
                    <input id="cashType" class="easyui-combobox easyui-validatebox cashType" data-options="prompt:'请选择收支子类别',required:true,validType:'length[0,20]',novalidate:true" name="cashType" />
                </td>
            </tr>
            <tr>
                <td><label>金额</label></td>
                <td>
                    <input  name="money" class="easyui-numberbox easyui-validatebox" data-options="prompt:'请输入金额',required:true,validType:'length[0,12]',novalidate:true" />
                </td>
            </tr>
            <tr>
                <td><label>支付方式</label></td>
                <td>
                    <input id="payType" class="easyui-combobox easyui-validatebox payType" data-options="prompt:'请选择支付方式',required:true,validType:'length[0,20]',novalidate:true" name="payType" />
                </td>
            </tr>
            <tr>
                <td><label>收支时间</label></td>
                <td>
                    <input class="easyui-datetimebox" name="cashTime" data-options="prompt:'请选择收支时间',required:true,novalidate:true,showSeconds:true"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="edit('/cash/update', 'editForm', 'list', 'editWin')">修改</a></td>
            </tr>
        </table>
    </form>
</div>

</body>

<%@include file="../master/footer.jsp"%>
<script src="<%=path %>/static/js/excel.js"></script>

<script>

    $(function () {
        setPagination("list");

        $(".cashTypeParent").combobox(
            {
                url:contextPath + "/cash_type/list/0",
                valueField:'id',
                textField:'text',
                onSelect:function (record) {
                    $(".cashType").combobox(
                        {
                            url:contextPath + "/cash_type/list/" + record.id,
                            valueField:'id',
                            textField:'text',
                        }
                    );
                }
            }
        );

        $(".payType").combobox(
            {
                url:contextPath + "/pay_type/list",
                valueField:'id',
                textField:'text',
            }
        );

    });

    function openEditWin(listId, winId, formId) {
        var row = $("#" + listId).datagrid("getSelected");
        if (row) {
            row.cashTime = formatDate(row.cashTime);
            $("#" + formId).form("load", row);
            $("#cashTypeParent").combobox("select", row.cashTypePid);
            $("#cashType").combobox("select", row.cashTypeId);
            $("#payType").combobox("select", row.payTypeId);
            openWin(winId);
        } else {
            showAlert("请选中要修改的数据");
        }
    }
</script>

</html>
