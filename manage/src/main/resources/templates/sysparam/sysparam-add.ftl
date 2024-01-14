<#assign path="${springMacroRequestContext.getContextPath()}">
<!DOCTYPE html>
<html lang="en" class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>系统参数新增</title>
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
                    <div class="layui-form-item">
                      <label class="layui-form-label">
                          <span class="x-red">*</span>参数key
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="paramKey" name="paramKey" required="" lay-verify="paramKey"
                          autocomplete="off" class="layui-input">
                      </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class="x-red">*</span>参数名称
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="paramName" name="paramName" required="" lay-verify="paramName"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                  <div class="layui-form-item">
                      <label class="layui-form-label">
                          <span class="x-red">*</span>参数值
                      </label>
                      <div class="layui-input-block">
                          <textarea placeholder="请输入内容" id="paramValue" name="paramValue" lay-verify="paramValue" class="layui-textarea"></textarea>
                      </div>
                  </div>
                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">描述</label>
                        <div class="layui-input-block">
                            <textarea placeholder="请输入内容" id="description" name="description" lay-verify="description" class="layui-textarea"></textarea>
                        </div>
                    </div>
                  <div class="layui-form-item">
                      <label class="layui-form-label"></label>
                      <button  class="layui-btn" lay-filter="add" lay-submit="">增  加</button>
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
                    paramKey: function(value) {
                        if (value.length < 1) {
                            return '参数key不能为空';
                        }
                    },
                    paramName: function(value) {
                        if (value.length < 1) {
                            return '参数名称不能为空';
                        }
                    },
                    paramValue: function(value) {
                        if (value.length < 1) {
                            return '参数值不能为空';
                        }
                    }
                });

                //监听提交
                form.on('submit(add)', function(data){
                    $.ajax({
                        type:'POST',
                        url:'${path}/sysparam/add',
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
