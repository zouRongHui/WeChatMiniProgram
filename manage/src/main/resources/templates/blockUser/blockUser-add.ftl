<#assign path="${springMacroRequestContext.getContextPath()}">
<!DOCTYPE html>
<html lang="en" class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>黑名单用户</title>
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
            <div class="layui-form-item">
                <label class="layui-form-label">手机号</label>
                <div class="layui-input-block">
                    <input type="text" id="phone" name="phone" autocomplete="off" class="layui-input" maxlength="11" placeholder="">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="x-red">*</span>微信号open_id</label>
                <div class="layui-input-block">
                    <input type="text" id="openId" name="openId" lay-verify="openId" autocomplete="off" class="layui-input" maxlength="60" placeholder="">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="x-red">*</span>违反的规则</label>
                <div class="layui-input-block">
                    <textarea placeholder="" id="rule" name="rule" lay-verify="rule" style="display:block;" class="layui-textarea"></textarea>
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
            // 页面展示的元素
            openId: function (value) {
                if (value.length < 1) {
                    return '请填写微信号open_id';
                }
            },
            rule: function (value) {
                if (value.length < 1) {
                    return '请填写违反反欺诈规则';
                }
                if (value.length > 64) {
                    return '姓名最多支持64个汉字';
                }
            }
        });

        // 监听提交
        layui.form.on('submit(add)', function (data) {
            $.ajax({
                type: 'POST',
                url: '${path}/blockUser/add',
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
