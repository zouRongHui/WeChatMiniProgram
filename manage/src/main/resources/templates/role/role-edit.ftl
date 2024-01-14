<#assign path="${springMacroRequestContext.getContextPath()}">
<!DOCTYPE html>
<html lang="en" class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>角色修改</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8" />

    <link rel="stylesheet" href="${path}/css/font.css">
    <link rel="stylesheet" href="${path}/css/xadmin.css">

    <script type="text/javascript" src="${path}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${path}/js/xadmin.js"></script>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <form action="" method="post" class="layui-form layui-form-pane">
            <input type="hidden" name="id" value="${roleInfo.id!}">
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>角色名
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="roleName" name="roleName" required="" lay-verify="roleName"
                           autocomplete="off" class="layui-input" value="${roleInfo.roleName!}">
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">
                    <span class="x-red">*</span>拥有权限
                </label>
                <div id="p-tree" class="layui-input-block" style="border: 1px solid #e6e6e6;background-color: #fff;"></div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">角色说明</label>
                <div class="layui-input-block">
                    <textarea placeholder="请输入内容" id="roleDesc" name="roleDesc" lay-verify="roleDesc"
                              class="layui-textarea">${roleInfo.roleDesc!}</textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <button class="layui-btn" lay-submit="" lay-filter="edit">更  新</button>
            </div>
        </form>
    </div>
</div>
<script>
    layui.use(['form','layer','tree'], function(){
        $ = layui.jquery;
        var form = layui.form,
                layer = layui.layer,
                tree = layui.tree;

        //渲染
        var inst1 = tree.render({
            elem: '#p-tree',  //绑定元素
            data: ${treeData!},
            id:'id',
            showCheckbox: true  //是否显示复选框
        });

        <#list menuIdList as menuId>
            tree.setChecked('id', ${menuId!});
        </#list>

        //自定义验证规则
        form.verify({
            roleName: function(value){
                if(value.length < 1){
                    return '角色名不能为空';
                }
            }
        });

        //监听提交
        form.on('submit(edit)', function(data){
            var checked =  tree.getChecked('id');
            if (checked.length < 1) {
                layer.msg('请至少选中一个菜单！', {icon: 2});
            } else {
                $.ajax({
                    type:'POST',
                    url:'${path}/role/edit',
                    dataType:'json',
                    contentType:'application/json; charset=UTF-8',
                    data:JSON.stringify(data.field),
                    success:function (data) {
                        if (data.success){
                            layer.alert(data.msg, {icon: 6},function () {
                                window.parent.location.reload();
                                // 获得frame索引
                                var index = parent.layer.getFrameIndex(window.name);
                                //关闭当前frame
                                parent.layer.close(index);
                            });
                        }else{

                        }
                    }
                });
            }
            return false;
        });
    });
</script>
</body>
</html>
