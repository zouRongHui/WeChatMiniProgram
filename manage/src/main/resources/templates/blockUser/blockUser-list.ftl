<#assign path="${springMacroRequestContext.getContextPath()}">
<!DOCTYPE html>
<html lang="en" class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>黑名单用户管理</title>
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
        <a><cite>黑名单用户管理</cite></a>
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
                            <input type="text" name="createTimeStart" id="date_createTimeStart"  placeholder="加入黑名单起始日期" autocomplete="off" class="layui-input" value="${qo.createTimeStart!''}">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="createTimeEnd" id="date_createTimeEnd" placeholder="加入黑名单截止日期" autocomplete="off" class="layui-input" value="${qo.createTimeEnd!''}">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                            <button type="button" class="layui-btn layui-btn-primary" onclick="resetQuery()">重置</button>
                        </div>
                    </form>
                </div>
                <div class="layui-card-header">
                    <button class="layui-btn" onclick="xadmin.open('新增','${path}/blockUser/addView',600,null,false)"><i class="layui-icon">&#xe61f;</i>新增</button>
                    <button class="layui-btn layui-btn-normal" onclick="delSelected()"><i class="layui-icon">&#xe640;</i>删除选中
                    </button>
                </div>
                <div class="layui-card-body" style="width: 100%;overflow: scroll;">
                    <table class="layui-table layui-form" style="width: 100%;">
                        <thead>
                        <tr>
                            <th>
                                <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                            </th>
                            <th style="min-width: 75px;">客户手机号</th>
                            <th style="min-width: 200px;">微信号open_id</th>
                            <th style="min-width: 190px;">违反反欺诈规则</th>
                            <th style="min-width: 120px;">加入黑名单时间</th>
                            <th style="min-width: 60px;">状态</th>
                            <th style="min-width: 60px;">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                            <#list datas as data>
                            <tr data-id="${data.id!?c}">
                                <td>
                                    <input type="checkbox" class="batch-operate" name="" lay-skin="primary" value="${data.id!?c}">
                                </td>
                                <td>${data.phone!}</td>
                                <td>${data.openId!}</td>
                                <td>${data.rule!}</td>
                                <td><#if (data.createTime)??>${(data.createTime)?string('yyyy-MM-dd HH:mm:ss')}</#if></td>
                                <#if (data.status == '1')>
                                <td>
                                    <input type="checkbox" name="enable" lay-text="启用|停用" value="${data.id!?c}" lay-skin="switch" lay-filter="enable" checked>
                                </td>
                                <#else>
                                <td>
                                    <input type="checkbox" name="enable" lay-text="启用|停用" value="${data.id!?c}" lay-skin="switch" lay-filter="enable">
                                </td>
                                </#if>
                                <td class="td-manage" style="white-space: nowrap">
                                    <button class="layui-btn layui-btn-xs layui-btn-danger" onclick="singleDelete(this,'${data.id!?c}')">
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
    var form;
    layui.use(['laypage', 'form', 'laydate'], function () {
        form = layui.form;
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
            count:${total?c}, //总条数
            limit:${size?c}, //每页展示条数
            curr:${page?c}, //页码
            jump: function (obj, first) {
                var page = obj.curr;
                var size = obj.limit;
                if (!first) {
                    window.location.href = '${path}/blockUser/list?page=' + page + '&size=' + size + "&" + $("#form_queryCondition").serialize();
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

        // 日期组件
        layui.laydate.render({
            elem: '#date_createTimeStart'
        });
        layui.laydate.render({
            elem: '#date_createTimeEnd'
        });
    });

    /**
     * 启用
     */
    function usable(id) {
        $.ajax({
            type: 'POST',
            url: '${path}/blockUser/usable',
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
            url: '${path}/blockUser/disable',
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
    function singleDelete(obj, id) {
        var ids = [];
        ids.push(id);
        layer.confirm('确认要删除吗？删除后数据无法恢复！', function (index) {
            del(ids)
        });
    }

    /*删除选中*/
    function delSelected(argument) {
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

        layer.confirm('确认要删除吗？删除后数据无法恢复！', function (index) {
            del(ids);
        });
    }

    function del(ids) {
        $.ajax({
            type: 'POST',
            url: '${path}/blockUser/delete',
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

    function resetQuery() {
        $("#form_queryCondition input[name='createTimeStart']").val("");
        $("#form_queryCondition input[name='createTimeEnd']").val("");
        form.render('select');
    }
</script>
</html>