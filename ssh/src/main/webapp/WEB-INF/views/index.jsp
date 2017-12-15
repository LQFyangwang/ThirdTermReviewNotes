<%--
  Created by IntelliJ IDEA.
  User: Master
  Date: 2017/7/3
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>EasyUI</title>
    <%@include file="master/header.jsp"%>
</head>
<body class="easyui-layout">

    <div id="top" data-options="region:'north'">
        <div id="logo">
            <img src="<%=path %>/static/images/logo.png" />
        </div>
        <div id="welcome">
            欢迎您：<a href="#">admin@126.com</a>,&nbsp;<a href="#">安全退出</a>
        </div>
    </div>
    <div id="footer" data-options="region:'south',split:true">

    </div>
    <div id="menu" data-options="region:'west',split:true" title="主菜单">
        <div class="easyui-accordion">
            <div title="班级管理" data-options="iconCls:'icon-ok',selected:true">
                <ul>
                    <li><a href="javascript:void(0);" class="site-navi-tab" data-src="<%=path %>/class/class_page">所有班级</a></li>
                </ul>
            </div>
            <div title="学生管理" data-options="iconCls:'icon-help'">
                <ul>
                    <li><a href="javascript:void(0);" class="site-navi-tab" data-src="<%=path %>/stu/stu_page">所有学生</a></li>
                </ul>
            </div>
            <div title="教师管理" data-options="iconCls:'icon-search'">
                <ul>
                    <li><a href="javascript:void(0);" class="site-navi-tab" data-src="<%=path %>/teacher/teacher_page">所有教师</a></li>

                </ul>
            </div>
        </div>
    </div>
    <div id="tabs" class="easyui-tabs" data-options="region:'center'">
        <div title="主页">
            <div class="easyui-panel my-panel" title="系统状态" data-options="iconCls:'icon-save',collapsible:true,minimizable:true,maximizable:true,closable:true">
                系统状态
            </div>
            <div class="easyui-panel my-panel" title="待办任务">
                待办任务
            </div>
            <div class="easyui-panel my-panel" title="报表统计">
                统计
            </div>
        </div>
    </div>

    <!-- 选项卡的右键菜单  -->
    <div id="mm" class="easyui-menu">
        <div id="mm-tabupdate">刷新</div>
        <div class="menu-sep"></div><!--分割线 -->
        <div id="mm-tabclose">关闭</div>
        <div id="mm-tabcloseother">关闭其他</div>
        <div id="mm-tabcloseall">关闭全部</div>
    </div>

    <div id="editDetailWin" class="easyui-window normal-win" data-options="title:'编辑任务',closed:true,modal:true">
        编辑任务详情的form表单
    </div>

</body>
<%@include file="master/footer.jsp"%>
</html>
