<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="detailWin" class="easyui-window normal-win" title="修改学生" data-options="closed:true">
    <form id="editDetailForm">
        <input type="hidden" id="stuId" name="stuDetail.stu.id"/>
        <input type="hidden" name="stuDetail.id" />
        <table>
            <tr>
                <td><label>性别</label></td>
                <td>
                    <select class="easyui-combobox" name="stuDetail.gender" style="width:175px;">
                        <option value="0">请选择</option>
                        <option value="1">男</option>
                        <option value="2">女</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>手机号</label></td>
                <td>
                    <input  name="stuDetail.phone" class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入手机号',required:true,validType:'length[2,20]',novalidate:true" />
                </td>
            </tr>
            <tr>
                <td><label>身份证号</label></td>
                <td>
                    <input name="stuDetail.identityNo" class="easyui-combobox easyui-validatebox" data-options="prompt:'请输入身份证号',required:true,novalidate:true" />
                </td>
            </tr>
            <tr>
                <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="closeWin('detailWin');">取消</a></td>
                <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="edit('/stuDetail/update', 'editDetailForm', 'list', 'detailWin')">修改</a></td>
            </tr>
        </table>
    </form>
</div>
