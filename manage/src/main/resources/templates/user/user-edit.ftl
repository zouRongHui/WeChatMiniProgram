<#assign path="${springMacroRequestContext.getContextPath()}">
<!DOCTYPE html>
<html lang="en" class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>用户修改</title>
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
                    <input type="hidden" name="id" value="${userInfo.id!}">
                  <div class="layui-form-item">
                      <label class="layui-form-label"><span class="x-red">*</span>用户名</label>
                      <div class="layui-input-inline">
                          <input type="text" id="userName" name="userName" required="" lay-verify="userName"
                          autocomplete="off" class="layui-input" value="${userInfo.userName!}">
                      </div>
                  </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">账号</label>
                        <div class="layui-input-inline">
                            <input type="text" id="account" name="account" required="" lay-verify="account"
                                   autocomplete="off" class="layui-input"  value="${userInfo.account!}" readonly>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">角色</label>
                        <div class="layui-input-block">
                          <#list roleInfoList as roleInfo>
                              <#if (roleInfo.id == userInfo.roleId)>
                                  <input type="radio" name="roleId" value="${roleInfo.id!}"  title="${roleInfo.roleName!}" checked>
                              <#else>
                                  <input type="radio" name="roleId" value="${roleInfo.id!}"  title="${roleInfo.roleName!}">
                              </#if>
                          </#list>
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
                    userName: function(value) {
                        if (value.length < 1) {
                            return '用户名不能为空';
                        }
                    }
                });

                //监听提交
                form.on('submit(edit)', function(data){
                    $.ajax({
                        type:'POST',
                        url:'${path}/user/edit',
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
