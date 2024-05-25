<#assign path="${springMacroRequestContext.getContextPath()}">
<!DOCTYPE html>
<html lang="en" class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>产品菜单更新</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8" />

    <link rel="stylesheet" href="${path}/css/font.css">
    <link rel="stylesheet" href="${path}/css/xadmin.css">

    <script type="text/javascript" src="${path}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${path}/js/xadmin.js"></script>
    <script type="text/javascript" src="${path}/js/jquery.min.js"></script>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form">
            <input type="hidden" name="id" value="${productMenu.id!}">
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>菜单名称
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="menuName" name="menuName" required="" lay-verify="menuName"
                           autocomplete="off" class="layui-input" value="${productMenu.menuName!}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red"></span>菜单分类
                </label>
                <div class="layui-input-inline">
                    <select id="sel_categoryId" name="categoryId">
                        <option value="">请选择</option>
                        <#list categoryList as category>
                            <option value="${category.id!}">${category.categoryName!}</option>
                        </#list>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red"></span>负责人工号
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="consultWorkNo" name="consultWorkNo" required="" lay-verify=""
                           autocomplete="off" class="layui-input" value="${(productMenu.consultWorkNo)!}">
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <i class="layui-icon layui-icon-tips" style="color: red"></i> 多个工号以 # 井号符分割
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red"></span>业务种类
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="businessType" name="businessType" required="" lay-verify=""
                           autocomplete="off" class="layui-input" value="${(productMenu.businessType)!}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>菜单图标
                </label>
                <div class="layui-input-inline layui-upload">
                    <input type="hidden" name="menuIcon" required="" lay-verify="menuIcon" autocomplete="off" class="layui-input" value="${productMenu.menuIcon!}">
                    <div class="layui-upload-list" style="margin-top: 0px;" id="menuIcon-show">
                        <a href="javascript:void(0)">
                            <img class="layui-upload-img" id="menuIcon" src="${productMenu.menuIcon!}"  style="width: 136px;height: 136px;">
                        </a>
                    </div>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <i class="layui-icon layui-icon-tips" style="color: red"></i>尺寸: 68px*68px
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>广告图
                </label>
                <div class="layui-input-inline layui-upload">
                    <input type="hidden" name="advertPhoto" required="" lay-verify="advertPhoto" autocomplete="off" class="layui-input" value="${productMenu.advertPhoto!}">
                    <div class="layui-upload-list" style="margin-top: 0px;" id="advertPhoto-show">
                        <a href="javascript:void(0)">
                            <img class="layui-upload-img" id="advertPhoto"  src="${productMenu.advertPhoto!}"  style="width: 175.5px;height: 106px;">
                        </a>
                    </div>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <i class="layui-icon layui-icon-tips" style="color: red"></i>尺寸: 702px*424px
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red"></span>可购页面
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="jumpUrl" name="jumpUrl" required="" lay-verify=""
                           autocomplete="off" class="layui-input"  value="${(productMenu.jumpUrl)!}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red"></span>可购页面参数
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="jumpParam" name="jumpParam" required="" lay-verify=""
                           autocomplete="off" class="layui-input" value="${(productMenu.jumpParam)!}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red"></span>持有页面
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="holdUrl" name="holdUrl" required="" lay-verify=""
                           autocomplete="off" class="layui-input" value="${(productMenu.holdUrl)!}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red"></span>持有页面参数
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="holdParam" name="holdParam" required="" lay-verify=""
                           autocomplete="off" class="layui-input" value="${(productMenu.holdParam)!}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red"></span>是否需要登陆
                </label>
                <div class="layui-input-inline">
                    <select name="needLogin" id="sel_needLogin" lay-verify="">
                        <option value="0" selected>否</option>
                        <option value="1">是</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">支持的用户类型</label>
                <div class="layui-input-block">
                    <input type="hidden" name="supportUserType" value="${(productMenu.supportUserType)!}" lay-verify="">
                    <input type="checkbox" class="supportUserType" value="1" title="超级VIP" lay-filter="supportUserType">
                    <input type="checkbox" class="supportUserType" value="2" title="高级VIP" lay-filter="supportUserType">
                    <input type="checkbox" class="supportUserType" value="3" title="一般VIP" lay-filter="supportUserType">
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">
                    <span class="x-red"></span>产品说明
                </label>
                <div class="layui-input-block">
                    <textarea placeholder="请输入内容" id="productDesc" name="productDesc" lay-verify=""
                              style="display:block;" class="layui-textarea">${(productMenu.productDesc)!}</textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"></label>
                <button  class="layui-btn" lay-filter="edit" lay-submit="">更  新</button>
            </div>
        </form>
    </div>
</div>
<script>
    $(function () {
        var categoryId = "${productMenu.categoryId!''}";
        $("#sel_categoryId").val(categoryId);

        $("#sel_needLogin").val("${productMenu.needLogin!'0'}");

        var supportUserTypes = "${(productMenu.supportUserType)!''}";
        $(".supportUserType").each(function () {
            if (supportUserTypes.indexOf($(this).val()) > -1) {
                $(this).attr("checked", true);
            }
        });
    });

    layui.use(['upload','form', 'layer'], function() {
            $ = layui.jquery;
            var form = layui.form,
                    layer = layui.layer;
            var upload = layui.upload;

        /*上传菜单图标*/
        upload.render({
            elem:'#menuIcon',
            url:'${path}/file/uploadImage',
            acceptMime:'image/*',
            data:{oldImg:function () {
                    return $("[name='menuIcon']").val();
                }},
            before:function(obj){
                //预读本地文件示例
                obj.preview(function (index,file,result) {
                    $("#menuIcon").attr('src',result);
                });
            },
            done:function (res) {
                if (res.success) {
                    $("[name='menuIcon']").val(res.obj);
                } else {
                    layer.msg(res.msg, {icon: 2});
                }
            }
        });

        /*上传广告图 */
        upload.render({
            elem:'#advertPhoto',
            url:'${path}/file/uploadImage',
            acceptMime:'image/*',
            data:{oldImg:function () {
                    return $("[name='advertPhoto']").val();
                }},
            before:function(obj){
                //预读本地文件示例
                obj.preview(function (index,file,result) {
                    $("#advertPhoto").attr('src',result);
                });
            },
            done:function (res) {
                if (res.success) {
                    $("[name='advertPhoto']").val(res.obj);
                } else {
                    layer.msg(res.msg, {icon: 2});
                }
            }
        });



        //创建一个富文本编辑器实例
        // var index = layedit.build('productDesc',{hideTool:['face','image','help'],height:200});

        //自定义验证规则
        form.verify({
            menuName: function(value) {
                if (value.length < 1) {
                    return '菜单名称不能为空';
                }
            },categoryId: function(value) {
                if (value.length < 1) {
                    return '请选择菜单分类';
                }
            },consultWorkNo: function(value) {
                if (value.length < 1) {
                    return '负责人工号不能为空';
                }
            },menuIcon: function(value) {
                if (value.length < 1) {
                    return '请选择菜单图标';
                }
            },advertPhoto: function(value) {
                if (value.length < 1) {
                    return '广告图地址不能为空';
                }
            },jumpUrl: function(value) {
                if (value.length < 1) {
                    return '跳转URL不能为空';
                }
            },jumpParam: function(value) {
                if (value.length < 1) {
                    return '跳转参数不能为空';
                }
            },productDesc: function(value) {
                if (value.length < 1) {
                    return '产品说明不能为空';
                }
            },businessType: function(value) {
                if (value.length < 1) {
                    return '业务种类不能为空';
                }
            },supportUserType: function(value) {
                if (value.length < 1) {
                    return '支持的用户类型不能为空';
                }
            }
        });

        //监听提交
        form.on('submit(edit)', function(data){
            $.ajax({
                type:'POST',
                url:'${path}/productmenu/edit',
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

        form.on("checkbox(supportUserType)", function (data) {
            var supportUserType = "";
            $(".supportUserType:checked").each(function () {
                supportUserType += $(this).val() + ",";
            });
            $("input[name=supportUserType").val(supportUserType);
        });
    });
</script>
</body>
</html>
