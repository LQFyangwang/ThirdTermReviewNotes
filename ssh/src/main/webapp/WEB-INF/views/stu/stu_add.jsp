<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="addWin" class="easyui-window normal-win" title="添加学生" data-options="closed:true">
    <form id="addForm">
        <table>
            <tr>
                <td><label>学号</label></td>
                <td>
                    <input  name="stu.num" class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入学号',required:true,validType:'length[2,20]',novalidate:true" />
                </td>
            </tr>
            <tr>
                <td><label>姓名</label></td>
                <td>
                    <input  name="stu.realName" class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入姓名',required:true,validType:'length[2,20]',novalidate:true" />
                </td>
            </tr>
            <tr>
                <td><label>班级</label></td>
                <td>
                    <input  id="clazz" name="stu.clazz.id" class="easyui-combobox easyui-validatebox" data-options="prompt:'请选择班级',required:true,novalidate:true" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="save('/stu/save', 'addForm', 'list', 'addWin');">添加</a></td>
            </tr>
        </table>
    </form>
</div>