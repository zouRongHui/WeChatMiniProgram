<#assign path="${springMacroRequestContext.getContextPath()}">
<!DOCTYPE html>
<html lang="en" class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8" />
    <link rel="stylesheet" href="${path}/css/font.css">
    <link rel="stylesheet" href="${path}/css/xadmin.css">
    <script src="${path}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${path}/js/xadmin.js"></script>
</head>
<body>
<div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">系统管理</a>
            <a>
              <cite>用户管理</cite></a>
          </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5">
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="userName"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </form>
                </div>
                <div class="layui-card-header">
                    <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
                    <button class="layui-btn" onclick="xadmin.open('添加用户','${path}/user/add',600,400)"><i class="layui-icon"></i>添加</button>
                </div>
                <div class="layui-card-body layui-table-body layui-table-main">
                    <table class="layui-table layui-form">
                        <thead>
                        <tr>
                            <th>
                                <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                            </th>
                            <th>用户名</th>
                            <th>账号</th>
                            <th>角色</th>
                            <th>加入时间</th>
                            <th>状态</th>
                            <th>操作</th>
                        </thead>
                        <tbody>
                            <#list userInfoList as userInfo>
                              <tr>
                                  <td>
                                      <input type="checkbox" value="${userInfo.id!}" name="id"  lay-skin="primary" >
                                  </td>
                                  <td>${userInfo.userName!}</td>
                                  <td>${userInfo.account!}</td>
                                  <td>${userInfo.roleName!}</td>
                                  <td>${userInfo.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                                  <#if (userInfo.started == '1')>
                                      <td>
                                          <input type="checkbox" name="started" lay-text="启用|停用" value="${userInfo.id!}" lay-skin="switch" lay-filter="started" checked>
                                      </td>
                                  <#else>
                                      <td>
                                          <input type="checkbox" name="started" lay-text="启用|停用" value="${userInfo.id!}" lay-skin="switch" lay-filter="started">
                                      </td>
                                  </#if>
                                  <td class="td-manage">
                                      <button class="layui-btn layui-btn-xs layui-btn-normal"  onclick="xadmin.open('编辑','${path}/user/edit?id=${userInfo.id}',600,400)" >
                                          <i class="layui-icon layui-icon-edit"></i>编辑
                                      </button>
                                      <button class="layui-btn layui-btn-xs layui-btn-danger"  onclick="member_del(this,'${userInfo.id!}')" >
                                          <i class="layui-icon layui-icon-delete"></i>删除
                                      </button>
                                      <button class="layui-btn layui-btn-xs"  onclick="pass_refresh(this,'${userInfo.id!}')" >
                                          <i class="layui-icon layui-icon-refresh"></i>密码重置
                                      </button>
                                  </td>
                              </tr>
                            </#list>
                        </tbody>
                    </table>
                </div>
                <div class="layui-card-body ">
                    <div id="page"</div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    layui.use(['laypage','form'], function(){
        var form = layui.form;
        var laypage = layui.laypage;

        var userName;
        //监听提交
        form.on('submit(sreach)', function(data){
            userName = data.field.userName;
            window.location.href = '${path}/user/list?userName='+userName;
            return false;
        });

        //执行一个laypage实例
        laypage.render({
            elem: 'page', //指定元素
            count:${total}, //总条数
            limit:${size}, //每页展示条数
            curr:${page}, //页码
            jump:function (obj,first) {
                var page = obj.curr;
                var size = obj.limit;
                if (!first) {
                    window.location.href = '${path}/user/list?page='+page+'&size='+size+'&userName='+userName;
                }
            }
        });

        // 监听全选
        form.on('checkbox(checkall)', function(data){

            if(data.elem.checked){
                $('tbody input[name="id"]').prop('checked',true);
            }else{
                $('tbody input[name="id"]').prop('checked',false);
            }
            form.render('checkbox');
        });

        //监听开关
        form.on('switch(started)', function (data) {
            if (data.elem.checked) {
                member_start(data.value);
            } else {
                member_stop(data.value);
            }
            return false;
        });

    });

    /*停用*/
    function member_stop(id){
        $.ajax({
            type:'POST',
            url:'${path}/user/stop',
            data:{id:id},
            success:function (data) {
                if (data.success){
                    layer.msg(data.msg,{icon: 1,time:1000});
                }else{
                    layer.msg(data.msg, {icon: 2,time:1000});
                    setTimeout(function () {
                        window.location.reload();
                    },1000)
                }
            }
        });
    }

    /*启用*/
    function member_start(id){
        $.ajax({
            type:'POST',
            url:'${path}/user/start',
            data:{id:id},
            success:function (data) {
                if (data.success){
                    layer.msg(data.msg,{icon: 1,time:1000});
                }else{
                    layer.msg(data.msg, {icon: 2,time:1000});
                }
            }
        });
    }

    /* 密码重置 */
    function pass_refresh(obj,id) {
        $.ajax({
            type:'POST',
            url:'${path}/user/passwordrefresh',
            data:{id:id},
            traditional:true,
            success:function (data) {
                if (data.success){
                    layer.alert(data.msg, {icon: 1});
                }else{
                    layer.msg(data.msg, {icon: 2,time:1000});
                }
            }
        });
    }

    /*用户-删除*/
    function member_del(obj,id){
        var ids = [];
        ids.push(id);
        layer.confirm('确认要删除吗？',function(index){
           del(ids);
        });
    }

    /*用户-批量删除*/
    function delAll (argument) {
        var ids = [];

        // 获取选中的id
        $('tbody input[name="id"]').each(function(index, el) {
            if($(this).prop('checked')){
                ids.push($(this).val());
            }
        });

        layer.confirm('确认要删除吗？',function(index){
           del(ids);
        });
    }

    function del(ids) {
        $.ajax({
            type:'POST',
            url:'${path}/user/delete',
            data:{ids:ids},
            traditional:true,
            success:function (data) {
                if (data.success){
                    layer.msg(data.msg, {icon: 1,time:1000});
                    setTimeout(function () {
                        window.location.reload();
                    },1000);
                }else{
                    layer.msg(data.msg, {icon: 2,time:1000});
                }
            }
        });
    }
</script>
</html>
