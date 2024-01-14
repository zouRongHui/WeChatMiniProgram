<#assign path="${springMacroRequestContext.getContextPath()}">
<!DOCTYPE html>
<html lang="en" class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>修改密码</title>
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
                    <input type="hidden" name="id" value="${id!}">
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class="x-red">*</span>原密码
                        </label>
                        <div class="layui-input-inline">
                            <input type="password" id="oldPassword" name="oldPassword" required="" lay-verify="oldPassword"
                                   autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-form-mid layui-word-aux">
                            <i class="layui-icon layui-icon-tips" style="color: red"></i> 忘记密码可联系管理员重置
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class="x-red">*</span>新密码
                        </label>
                        <div class="layui-input-inline">
                            <input type="password" id="newPassword" name="newPassword" required="" lay-verify="newPassword"
                                   autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-form-mid layui-word-aux">
                            <i class="layui-icon layui-icon-tips" style="color: red"></i> 3到12个字符
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class="x-red">*</span>确认密码
                        </label>
                        <div class="layui-input-inline">
                            <input type="password" id="rePassword" name="rePassword" required="" lay-verify="rePassword"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                  <div class="layui-form-item">
                      <label class="layui-form-label"></label>
                      <button  class="layui-btn" lay-filter="edit" lay-submit="">确  认</button>
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
                    oldPassword: function(value) {
                        if (value.length < 1) {
                            return '原密码不能为空';
                        }
                    },
                    newPassword: [/(.+){3,12}$/, '新密码必须3到12位'],
                    rePassword: function(value) {
                        if ($('#rePassword').val() != $('#rePassword').val()) {
                            return '两次密码不一致';
                        }
                    }
                });

                //监听提交
                form.on('submit(edit)', function(data){
                    $.ajax({
                        type:'POST',
                        url:'${path}/user/editpassword',
                        data:data.field,
                        success:function (data) {
                            if (data.success){
                                layer.alert(data.msg, {icon: 6},function () {
                                    window.parent.location.href="${path}/auth/logout";
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
