<#assign path="${springMacroRequestContext.getContextPath()}">
<!DOCTYPE html>
<html lang="en" class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>权益活动-白名单</title>
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
        <a><cite>权益活动-白名单</cite></a>
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
                        <input type="hidden" name="id" value="${id}">
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="phone"  placeholder="手机号" class="layui-input" value="${phone!''}">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </form>
                </div>
                <div class="layui-card-header">
                    <button class="layui-btn layui-btn-danger" onclick="delChecked()">
                        <i class="layui-icon">&#xe640;</i>删除选中
                    </button>
                    <button class="layui-btn" onclick="xadmin.open('添加','${path}/rightsActivity/allowListAddView?id=${id}',480,350)">
                        <i class="layui-icon">&#xe61f;</i>添加
                    </button>
                    <button class="layui-btn" onclick="xadmin.open('Excel导入','${path}/rightsActivity/allowListImportView?id=${id}',400,230)">
                        <i class="layui-icon">&#xe67c;</i>Excel导入
                    </button>
                    <button class="layui-btn layui-btn-danger" onclick="delAll()">
                        <i class="layui-icon">&#xe640;</i>全部删除
                    </button>
                </div>
                <div class="layui-card-body ">
                    <table class="layui-table layui-form">
                        <thead>
                        <tr>
                            <th width="10">
                                <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                            </th>
                            <th width="30">序号</th>
                            <th>手机号</th>
                            <th width="60">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                            <#list datas as data>
                            <tr data-id="${data.phone!}">
                                <td>
                                    <input type="checkbox" class="batch-operate" name="" lay-skin="primary"
                                           value="${data.phone!''}">
                                </td>
                                <td>${data?counter}</td>
                                <td>${data.phone!}</td>
                                <td class="td-manage" style="white-space: nowrap">
                                    <button class="layui-btn layui-btn-xs layui-btn-danger" onclick="member_del('${data.phone!}')">
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

        //执行一个laypage实例
        laypage.render({
            elem: 'page', //指定元素
            count:${total?c}, //总条数
            limit:${size?c}, //每页展示条数
            curr:${page?c}, //页码
            jump: function (obj, first) {
                var pageNum = obj.curr;
                var pageSize = obj.limit;
                if (!first) {
                    window.location.href = '${path}/rightsActivity/allowListView?pageNum=' + pageNum + '&pageSize=' + pageSize + "&" + $("#form_queryCondition").serialize();
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

    /*删除*/
    function member_del(phone) {
        var phones = [];
        phones.push(phone);
        layer.confirm('确认要删除吗？', function (index) {
            del(phones)
        });
    }

    /*批量删除*/
    function delChecked(argument) {
        var phones = [];
        $('.batch-operate').each(function (index, el) {
            if ($(this).prop('checked')) {
                phones.push($(this).val());
            }
        });
        if (phones.length <= 0) {
            return;
        }
        layer.confirm('确认要删除吗？', function (index) {
            del(phones);
        });
    }

    function del(phones) {
        $.ajax({
            type: 'POST',
            url: '${path}/rightsActivity/allowListDelete',
            data: {
                phones: phones,
                rightsActivityId: '${id}'
            },
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

    function delAll() {
        layer.confirm('确认要全部删除吗？', function (index) {
            $.ajax({
                type: 'POST',
                url: '${path}/rightsActivity/allowListDeleteAll',
                data: {rightsActivityId: '${id}'},
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
        });
    }
</script>
</html>