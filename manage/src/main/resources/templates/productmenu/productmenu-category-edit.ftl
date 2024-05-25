<#assign path="${springMacroRequestContext.getContextPath()}">
<!DOCTYPE html>
<html lang="en" class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>产品菜单分类更新</title>
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
        <form class="layui-form">
            <input type="hidden" name="id" value="${productMenuCategory.id!}">
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>分类名称
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="categoryName" name="categoryName" required="" lay-verify="categoryName"
                           autocomplete="off" class="layui-input" value="${productMenuCategory.categoryName!}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>展示风格
                </label>
                <div class="layui-input-inline">
                    <#if productMenuCategory.showStyle == '1'>
                        <input type="radio" name="showStyle" value="1" title="横向" checked>
                        <input type="radio" name="showStyle" value="2" title="竖向">
                    <#else>
                        <input type="radio" name="showStyle" value="1" title="横向">
                        <input type="radio" name="showStyle" value="2" title="竖向" checked>
                    </#if>
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">描述</label>
                <div class="layui-input-block">
                    <textarea placeholder="请输入内容" id="categoryDesc" name="categoryDesc" lay-verify="categoryDesc"
                              class="layui-textarea">${productMenuCategory.categoryDesc!}</textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"></label>
                <button  class="layui-btn" lay-filter="edit" lay-submit="">更  新</button>
            </div>
        </form>
    </div>
</div>
<script>layui.use(['form', 'layer'],
        function() {
            $ = layui.jquery;
            var form = layui.form,
                    layer = layui.layer;

            //自定义验证规则
            form.verify({
                categoryName: function(value) {
                    if (value.length < 1) {
                        return '分类名称不能为空';
                    }
                }
            });

            //监听提交
            form.on('submit(edit)', function(data){
                $.ajax({
                    type:'POST',
                    url:'${path}/productmenucategory/edit',
                    data:data.field,
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
                            layer.msg(data.msg, {icon: 2});
                        }
                    }
                });
                return false;
            });
        });
</script>
</body>
</html>
