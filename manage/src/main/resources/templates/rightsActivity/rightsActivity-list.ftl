<#assign path="${springMacroRequestContext.getContextPath()}">
<!DOCTYPE html>
<html lang="en" class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>权益活动配置</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8"/>

    <link rel="stylesheet" href="${path}/css/font.css">
    <link rel="stylesheet" href="${path}/css/xadmin.css">

    <script src="${path}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${path}/js/xadmin.js"></script>
    <script type="text/javascript" src="${path}/js/jquery.min.js"></script>
</head>
<body>
<div class="x-nav">
    <span class="layui-breadcrumb">
        <a><cite>权益活动配置</cite></a>
    </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
    </a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5" id="form_queryCondition">
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="title"  placeholder="主标题" class="layui-input" value="${qo.title!''}">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn" lay-submit="" lay-filter="sreach"><i class="layui-icon ">&#xe615;</i></button>
                        </div>
                    </form>
                </div>
                <div class="layui-card-header">
                    <button class="layui-btn layui-btn-danger" onclick="delChecked()"><i class="layui-icon">&#xe640;</i>删除选中</button>
                    <button class="layui-btn" onclick="xadmin.open('添加','${path}/rightsActivity/add',600,null,false)"><i class="layui-icon">&#xe61f;</i>添加</button>
                </div>
                <div class="layui-card-body ">
                    <table class="layui-table layui-form">
                        <thead>
                        <tr>
                            <th width="10">
                                <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                            </th>
                            <th>主标题</th>
                            <th>副标题</th>
                            <th>领取次数(总/已领)</th>
                            <th>状态</th>
                            <th width="330">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                            <#list datas as data>
                            <tr data-id="${data.id!}">
                                <td>
                                    <input type="checkbox" class="batch-operate" name="" lay-skin="primary"
                                           value="${data.id!''}">
                                </td>
                                <td>${data.title!}</td>
                                <td>${data.subtitle!}</td>
                                <td>${data.receiveTimesTotal!''}/${data.receiveTimesDone!}</td>
                                <#if (data.status == '1')>
                                <td>
                                    <input type="checkbox" name="enable" lay-text="启用|停用" value="${data.id!''}" lay-skin="switch" lay-filter="enable" checked>
                                </td>
                                <#else>
                                <td>
                                    <input type="checkbox" name="enable" lay-text="启用|停用" value="${data.id!''}" lay-skin="switch" lay-filter="enable">
                                </td>
                                </#if>
                                <td class="td-manage" style="white-space: nowrap">
                                    <button class="layui-btn layui-btn-xs" onclick="xadmin.open('小程序码','${path}/rightsActivity/miniAppCode?id=${data.id!}',300,325,false)">
                                        <i class="layui-icon layui-icon-picture"></i>小程序码
                                    </button>
                                    <button class="layui-btn layui-btn-xs layui-btn-normal" onclick="xadmin.open('编辑','${path}/rightsActivity/edit?id=${data.id!}',600,null,false)">
                                        <i class="layui-icon layui-icon-edit"></i>编辑
                                    </button>
                                    <#if (data.hasAllowList == '1')>
                                    <button class="layui-btn layui-btn-xs" onclick="window.parent.xadmin.add_tab('权益白名单', '${path}/rightsActivity/allowListView?id=${data.id!}')">
                                        <i class="layui-icon layui-icon-form"></i>白名单
                                    </button>
                                    </#if>
                                    <button class="layui-btn layui-btn-xs layui-btn-danger" onclick="member_del(this,'${data.id!}')">
                                        <i class="layui-icon layui-icon-delete"></i>删除
                                    </button>
                                </td>
                            </tr>
                            </#list>
                        </tbody>
                    </table>
                </div>
                <div class="layui-card-body ">
                    <div id="page"></div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    layui.use(['laypage', 'form'], function () {
        var form = layui.form;
        var laypage = layui.laypage;

        //监听是否启用开关
        form.on('switch(enable)', function (data) {
            if (data.elem.checked) {
                usable(data.value);
            } else {
                disable(data.value);
            }
        });

        //执行一个laypage实例
        laypage.render({
            elem: 'page', //指定元素
            count:${total}, //总条数
            limit:${size}, //每页展示条数
            curr:${page}, //页码
            jump: function (obj, first) {
                var page = obj.curr;
                var size = obj.limit;
                if (!first) {
                    window.location.href = '${path}/rightsActivity/list?page=' + page + '&size=' + size + "&" + $("#form_queryCondition").serialize();
                }
            }
        });

        // 监听全选
        form.on('checkbox(checkall)', function (data) {
            if (data.elem.checked) {
                $('.batch-operate').prop('checked', true);
            } else {
                $('.batch-operate').prop('checked', false);
            }
            form.render('checkbox');
        });

    });

    /**
     * 启用
     */
    function usable(id) {
        $.ajax({
            type: 'POST',
            url: '${path}/rightsActivity/usable',
            data: {id: id},
            success: function (data) {
                if (data.success) {
                    layer.msg(data.msg, {icon: 1, time: 1000});
                } else {
                    layer.msg(data.msg, {icon: 2, time: 1000});
                }
            }
        });
    }

    /**
     * 停用
     */
    function disable(id) {
        $.ajax({
            type: 'POST',
            url: '${path}/rightsActivity/disable',
            data: {id: id},
            success: function (data) {
                if (data.success) {
                    layer.msg(data.msg, {icon: 1, time: 1000});
                } else {
                    layer.msg(data.msg, {icon: 2, time: 1000});
                }
            }
        });
    }

    /*删除*/
    function member_del(obj, id) {
        var ids = [];
        ids.push(id);
        layer.confirm('确认要删除吗？', function (index) {
            del(ids)
        });
    }

    /*批量删除*/
    function delChecked(argument) {
        var ids = [];
        // 获取选中的id
        $('.batch-operate').each(function (index, el) {
            if ($(this).prop('checked')) {
                ids.push($(this).val());
            }
        });
        if (ids.length <= 0) {
            return;
        }
        layer.confirm('确认要删除吗？', function (index) {
            del(ids);
        });
    }

    function del(ids) {
        $.ajax({
            type: 'POST',
            url: '${path}/rightsActivity/delete',
            data: {ids: ids},
            traditional: true,
            success: function (data) {
                if (data.success) {
                    layer.msg(data.msg, {icon: 1, time: 1000});
                    setTimeout(function () {
                        window.location.reload();
                    }, 1000);
                } else {
                    layer.msg(data.msg, {icon: 2, time: 1500});
                }
            }
        });
    }
</script>
</html>