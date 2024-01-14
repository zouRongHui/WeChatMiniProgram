<#assign path="${springMacroRequestContext.getContextPath()}">
<!DOCTYPE html>
<html lang="en" class="x-admin-sm">
<head>
	<meta charset="UTF-8">
	<title>后台登录-微信小程序</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link type="text/css" rel="stylesheet" href="${path}/css/font.css">
    <link type="text/css" rel="stylesheet" href="${path}/css/login.css">
    <link type="text/css" rel="stylesheet" href="${path}/css/xadmin.css">

    <script type="text/javascript" src="${path}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/lib/layui/layui.js" charset="utf-8"></script>
</head>
<body class="login-bg">
    <div class="login layui-anim layui-anim-up">
        <div class="message">微信小程序-管理登录</div>
        <div id="darkbannerwrap"></div>
        
        <form method="post" class="layui-form" >
            <input name="account" placeholder="账号"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
            <input value="登  录" lay-submit="" lay-filter="login" style="width:100%;" type="submit">
            <hr class="hr20" >
        </form>
    </div>

    <script type="module">
        // 解决登陆过期时iframe嵌套结构展示问题
        if (window != top) {
            top.location.href = location.href;
        }

        $(function  () {
            layui.use('form', function(){
              var form = layui.form;
              //监听提交
              form.on('submit(login)', function(data){
                  $.ajax({
                      type:'POST',
                      url:'${path}/auth/login',
                      dataType:'json',
                      data:data.field,
                      success:function (data) {
                          if (data.success){
                              location.href='${path}/auth/index'
                          }else{
                              layer.msg(data.msg, {icon: 2});
                          }
                      }
                  });
                return false;
              });
            });
        })
    </script>
</body>
</html>