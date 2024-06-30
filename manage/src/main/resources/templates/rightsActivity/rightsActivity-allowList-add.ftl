<#assign path="${springMacroRequestContext.getContextPath()}">
<!DOCTYPE html>
<html lang="en" class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>权益活动白名单</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8"/>

    <link rel="stylesheet" href="${path}/css/font.css">
    <link rel="stylesheet" href="${path}/css/xadmin.css">

    <script type="text/javascript" src="${path}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${path}/js/xadmin.js"></script>
    <script type="text/javascript" src="${path}/js/jquery.min.js"></script>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form" lay-filter="form_add">
            <input type="hidden" name="rightsActivityId" value="${id}">
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="x-red">*</span>手机号</label>
                <div class="layui-input-inline">
                    <input type="text" id="phone" name="phone" lay-verify="phone" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <button class="layui-btn" lay-filter="add" lay-submit="">增 加</button>
            </div>
        </form>
    </div>
</div>
<script>
    layui.use(['upload', 'form', 'layer', 'laydate'], function () {
        // 自定义验证规则
        layui.form.verify({
            phone: function (value) {
                if (value.length < 1) {
                    return '请填写手机号';
                }
            }
        });

        // 监听提交
        layui.form.on('submit(add)', function (data) {
            $.ajax({
                type: 'POST',
                url: '${path}/rightsActivity/allowListAdd',
                data: data.field,
                success: function (data) {
                    if (data.success) {
                        layer.alert(data.msg, {icon: 6}, function () {
                            window.parent.location.reload();
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);
                        });
                    } else {
                        layui.layer.msg(data.msg, {icon: 2});
                    }
                }
            });
            return false;
        });
    });
</script>
</body>
</html>
