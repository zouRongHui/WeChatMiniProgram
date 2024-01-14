<#assign path="${springMacroRequestContext.getContextPath()}">
<!DOCTYPE html>
<html lang="en" class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>系统参数管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8" />
    <link rel="stylesheet" href="${path}/css/font.css">
    <link rel="stylesheet" href="${path}/css/xadmin.css">
    <script src="${path}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${path}/js/xadmin.js"></script>
    <style>
        .td-manage{
            white-space: nowrap;
        }
    </style>
</head>
<body>
<div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">系统管理</a>
            <a>
              <cite>系统参数管理</cite></a>
          </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5" id="form_queryCondition">
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="paramKey"  placeholder="请输入参数key" autocomplete="off" class="layui-input" value="${paramKey}">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="paramName"  placeholder="请输入参数名称" autocomplete="off" class="layui-input" value="${paramName}">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </form>
                </div>
                <div class="layui-card-header">
                    <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
                    <button class="layui-btn" onclick="xadmin.open('添加系统参数','${path}/sysparam/add',600,480)"><i class="layui-icon"></i>添加</button>
                </div>
                <div class="layui-card-body layui-table-body layui-table-main">
                    <table class="layui-table layui-form">
                        <thead>
                        <tr>
                            <th>
                                <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                            </th>
                            <th>参数key</th>
                            <th>参数名称</th>
                            <th>参数值</th>
                            <#--<th>描述</th>-->
                            <th>状态</th>
                            <th>操作</th>
                        </thead>
                        <tbody>
                            <#list sysParamList as sysParam>
                            <tr data-id="${sysParam.id!''}">
                                <td>
                                    <input type="checkbox" name="id"  lay-skin="primary" >
                                </td>
                                <td>${sysParam.paramKey!}</td>
                                <td>${sysParam.paramName!}</td>
                                <td>${sysParam.paramValue!}</td>
                                <#--<td>${sysParam.description!}</td>-->
                                  <#if (sysParam.status == '0')>
                                      <td>
                                          <input type="checkbox" name="status" lay-text="启用|停用" value="${sysParam.id!}" lay-skin="switch" lay-filter="status" checked>
                                      </td>
                                  <#else>
                                      <td>
                                          <input type="checkbox" name="status" lay-text="启用|停用" value="${sysParam.id!}" lay-skin="switch" lay-filter="status">
                                      </td>
                                  </#if>
                                <td class="td-manage">
                                    <button class="layui-btn layui-btn-xs layui-btn-normal"  onclick="xadmin.open('编辑','${path}/sysparam/edit?id=${sysParam.id}',600,480)" >
                                        <i class="layui-icon layui-icon-edit"></i>编辑
                                    </button>
                                    <button class="layui-btn layui-btn-xs layui-btn-danger"  onclick="member_del(this,'${sysParam.id!}')" >
                                        <i class="layui-icon layui-icon-delete"></i>删除
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

        var paramKey;
        var paramName;
        //监听提交
        form.on('submit(sreach)', function(data){
            paramKey = data.field.paramKey;
            paramName = data.field.paramName;
            window.location.href = '${path}/sysparam/list?paramKey='+paramKey+'&paramName='+paramName;
            return false;
        });

        //监听开关
        form.on('switch(status)', function (data) {
            if (data.elem.checked) {
                member_start(data.value);
            } else {
                member_stop(data.value);
            }
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
                    window.location.href = '${path}/sysparam/list?page='+page+'&size='+size+"&" + $("#form_queryCondition").serialize();
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

    });

    /*停用*/
    function member_stop(id){
        $.ajax({
            type:'POST',
            url:'${path}/sysparam/stop',
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

    /*启用*/
    function member_start(id){
        $.ajax({
            type:'POST',
            url:'${path}/sysparam/start',
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


    /*删除*/
    function member_del(obj,id){
        var ids = [];
        ids.push(id);
        layer.confirm('确认要删除吗？',function(index){
            del(ids);
        });
    }

    /*批量删除*/
    function delAll (argument) {
        var ids = [];

        // 获取选中的id
        $('tbody input[name="id"]').each(function(index, el) {
            if($(this).prop('checked')){
                ids.push($(this).parents('tr').data('id'));
            }
        });

        layer.confirm('确认要删除吗？',function(index){
            del(ids);
        });
    }

    function del(ids) {
        $.ajax({
            type:'POST',
            url:'${path}/sysparam/delete',
            data:{ids:ids},
            traditional:true,
            success:function (data) {
                if (data.success){
                    layer.msg(data.msg, {icon: 1,time:1000});
                    setTimeout(function () {
                        window.location.href = '${path}/sysparam/list';
                    },1000);
                }else{
                    layer.msg(data.msg, {icon: 2,time:1000});
                }
            }
        });
    }
</script>
</html>
