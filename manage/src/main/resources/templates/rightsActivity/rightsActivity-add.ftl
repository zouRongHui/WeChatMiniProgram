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

    <script type="text/javascript" src="${path}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${path}/js/xadmin.js"></script>
    <script type="text/javascript" src="${path}/js/jquery.min.js"></script>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form" lay-filter="form_add">
            <#--页面展示元素的配置 开始-->
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="x-red">*</span>主标题</label>
                <div class="layui-input-block">
                    <input type="text" id="title" name="title" lay-verify="title" autocomplete="off" class="layui-input" maxlength="10" placeholder="最大10个汉字">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="x-red">*</span>副标题</label>
                <div class="layui-input-block">
                    <input type="text" id="subtitle" name="subtitle" lay-verify="subtitle" autocomplete="off" class="layui-input" maxlength="20" placeholder="最大20个汉字">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="x-red">*</span>背景图</label>
                <div class="layui-input-inline layui-upload">
                    <div class="layui-upload-list" style="margin-top: 0px;">
                        <input type="hidden" id="imageBackground_url" name="imageBackground" lay-verify="imageBackground">
                        <a href="javascript:void(0)"><img class="layui-upload-img" id="imageBackground" src="${path}/images/upload.png"  style="width: 125px;height: 241.3px;object-fit: cover;"></a>
                    </div>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <i class="layui-icon layui-icon-tips" style="color: red"></i>
                    背景图尺寸: 375px*724px
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="x-red">*</span>LOGO图</label>
                <div class="layui-input-inline layui-upload">
                    <div class="layui-upload-list" style="margin-top: 0px;">
                        <input type="hidden" id="imageLogo_url" name="imageLogo" lay-verify="imageLogo">
                        <a href="javascript:void(0)"><img class="layui-upload-img" id="imageLogo" src="${path}/images/upload.png"  style="width: 128px;height: 128px;object-fit: cover;"></a>
                    </div>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <i class="layui-icon layui-icon-tips" style="color: red"></i>
                    LOGO图尺寸: 128px*128px
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="x-red">*</span>介绍</label>
                <div class="layui-input-block">
                    <textarea placeholder="请输入内容" id="introduce" name="introduce" lay-verify="introduce" style="display:block;" class="layui-textarea"></textarea>
                </div>
            </div>
            <#--页面展示元素的配置 结束-->

            <#--领取的限制配置 开始-->
            <div class="layui-form-item">
                <label class="layui-form-label">活动开始日期</label>
                <div class="layui-input-inline">
                    <input type="text" id="startDate" name="startDate" lay-verify="startDate" autocomplete="off" class="layui-input wd-laydate" readonly>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">活动截止日期</label>
                <div class="layui-input-inline">
                    <input type="text" id="endDate" name="endDate" lay-verify="endDate" autocomplete="off" class="layui-input wd-laydate" readonly>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">领取开始时间</label>
                <div class="layui-input-inline">
                    <input type="text" id="startTime" name="startTime" lay-verify="startTime" autocomplete="off" class="layui-input wd-laytime" readonly>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">领取截止时间</label>
                <div class="layui-input-inline">
                    <input type="text" id="endTime" name="endTime" lay-verify="endTime" autocomplete="off" class="layui-input wd-laytime" readonly>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">领取周期</label>
                <div class="layui-input-block">
                    <input type="hidden" name="receiveCycle" value="" lay-verify="">
                    <input type="checkbox" class="receiveCycle" value="2" title="周一" lay-filter="receiveCycle">
                    <input type="checkbox" class="receiveCycle" value="3" title="周二" lay-filter="receiveCycle">
                    <input type="checkbox" class="receiveCycle" value="4" title="周三" lay-filter="receiveCycle">
                    <input type="checkbox" class="receiveCycle" value="5" title="周四" lay-filter="receiveCycle">
                    <input type="checkbox" class="receiveCycle" value="6" title="周五" lay-filter="receiveCycle">
                    <input type="checkbox" class="receiveCycle" value="7" title="周六" lay-filter="receiveCycle">
                    <input type="checkbox" class="receiveCycle" value="1" title="周日" lay-filter="receiveCycle">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label" id="label_receiveTimesTotal">活动总领取次数<i class="layui-icon layui-icon-about" onclick="showExplain('label_receiveTimesTotal', '整个活动期间内客户能进入二维码领取的总次数')"></i></label>
                <div class="layui-input-inline">
                    <input type="number" id="receiveTimesTotal" name="receiveTimesTotal" lay-verify="receiveTimesTotal" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">领取频率</label>
                <div class="layui-input-inline">
                    <select name="phaseRightsNumCycle" id="sel_phaseRightsNumCycle">
                <#list phaseRightsNumCycles as phaseRightsNumCycle>
                    <option value="${phaseRightsNumCycle.getCode()}">${phaseRightsNumCycle.getName()}</option>
                </#list>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label" id="label_phaseRightsTotalNum">领取频率总次数<i class="layui-icon layui-icon-about" onclick="showExplain('label_phaseRightsTotalNum', '在具体的频率内客户能进入二维码领取的总次数')"></i></label>
                <div class="layui-input-inline">
                    <input type="number" id="phaseRightsTotalNum" name="phaseRightsTotalNum" lay-verify="phaseRightsTotalNum" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">单手机号领取频率</label>
                <div class="layui-input-inline">
                    <select name="receiveTimesSingleFrequency" id="sel_receiveTimesSingleFrequency">
            <#list receiveTimesSingleFrequencys as receiveTimesSingleFrequency>
                <option value="${receiveTimesSingleFrequency.getCode()}">${receiveTimesSingleFrequency.getName()}</option>
            </#list>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label" id="label_receiveTimesSingle">单手机号领取次数<i class="layui-icon layui-icon-about" onclick="showExplain('label_receiveTimesSingle', '每个手机号在具体的频率内能进入二维码领取的次数')"></i></label>
                <div class="layui-input-inline">
                    <input type="number" id="receiveTimesSingle" name="receiveTimesSingle" lay-verify="receiveTimesSingle" value="1" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">是否配置白名单</label>
                <div class="layui-input-inline">
                    <select name="hasAllowList" id="sel_hasAllowList">
                    <#list hasAllowLists as hasAllowList>
                        <option value="${hasAllowList.getCode()}">${hasAllowList.getName()}</option>
                    </#list>
                    </select>
                </div>
            </div>
            <#--领取的限制配置 结束-->

            <#--商城的权益信息配置 开始-->
            <div class="layui-form-item">
                <label class="layui-form-label" id="label_rightsId"><span class="x-red">*</span>商城权益id<i class="layui-icon layui-icon-about" onclick="showExplain('label_rightsId', '商城系统下发权益接口所需的数据，具体数值从商城系统获取')"></i></label>
                <div class="layui-input-block">
                    <input type="text" id="rightsId" name="rightsId" lay-verify="rightsId" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label" id="label_rightsStartDate"><span class="x-red">*</span>权益生效时间<i class="layui-icon layui-icon-about" onclick="showExplain('label_rightsStartDate', '让商城开始个客户下发权益的时间')"></i></label>
                <div class="layui-input-inline">
                    <input type="text" id="rightsStartDate" name="rightsStartDate" lay-verify="rightsStartDate" autocomplete="off" class="layui-input wd-laydate" readonly>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label" id="label_rightsEndDate"><span class="x-red">*</span>权益过期时间<i class="layui-icon layui-icon-about" onclick="showExplain('label_rightsEndDate', '让商城结束给客户下发权益的时间')"></i></label>
                <div class="layui-input-inline">
                    <input type="text" id="rightsEndDate" name="rightsEndDate" lay-verify="rightsEndDate" autocomplete="off" class="layui-input wd-laydate" readonly>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label" id="label_rightsNum"><span class="x-red">*</span>商城优惠券下发张数<i class="layui-icon layui-icon-about" onclick="showExplain('label_rightsNum', '每领取一次商城下发优惠券的张数')"></i></label>
                <div class="layui-input-inline">
                    <input type="number" id="rightsNum" name="rightsNum" lay-verify="rightsNum" autocomplete="off" class="layui-input">
                </div>
            </div>
            <#--商城的权益信息配置 结束-->
            <div class="layui-form-item">
                <button class="layui-btn" lay-filter="add" lay-submit="">增 加</button>
            </div>
        </form>
    </div>
</div>
<script>
    layui.use(['upload', 'form', 'layer', 'laydate'], function () {
        var intReg = /^[0-9][0-9]*$/;

        /* 上传背景图 */
        layui.upload.render({
            elem:'#imageBackground',
            url:'${path}/file/uploadImage',
            acceptMime:'image/*',
            data:{},
            before:function(obj){
                //预读本地文件示例
                obj.preview(function (index,file,result) {
                    $("#imageBackground").attr('src',result);
                });
            },
            done:function (res) {
                if (res.success) {
                    $("#imageBackground_url").val(res.obj);
                } else {
                    layui.layer.msg(res.msg, {icon: 2});
                }
            }
        });

        /* 上传Logo图 */
        layui.upload.render({
            elem:'#imageLogo',
            url:'${path}/file/uploadImage',
            acceptMime:'image/*',
            data:{},
            before:function(obj){
                //预读本地文件示例
                obj.preview(function (index,file,result) {
                    $("#imageLogo").attr('src',result);
                });
            },
            done:function (res) {
                if (res.success) {
                    $("#imageLogo_url").val(res.obj);
                } else {
                    layui.layer.msg(res.msg, {icon: 2});
                }
            }
        });

        lay('.wd-laydate').each(function () {
            layui.laydate.render({
                elem: this,
                trigger: 'click'
            });
        });

        lay('.wd-laytime').each(function () {
            layui.laydate.render({
                elem: this,
                type: 'time',
                trigger: 'click'
            });
        });

        layui.form.on("checkbox(receiveCycle)", function (data) {
            var receiveCycle = "";
            $(".receiveCycle:checked").each(function () {
                receiveCycle += $(this).val() + ",";
            });
            $("input[name=receiveCycle").val(receiveCycle);
        });

        // 自定义验证规则
        layui.form.verify({
            // 页面展示的元素
            title: function (value) {
                if (value.length < 1) {
                    return '请填写主标题';
                }
                if (value.length > 10) {
                    return '主标题最多支持10个汉字';
                }
            },
            subtitle: function (value) {
                if (value.length < 1) {
                    return '请填写副标题';
                }
                if (value.length > 20) {
                    return '副标题多支持20个汉字';
                }
            },
            imageBackground: function (value) {
                if (value.length < 1) {
                    return '请选择背景图';
                }
            },
            imageLogo: function (value) {
                if (value.length < 1) {
                    return '请选择LOGO图';
                }
            },
            introduce: function (value) {
                if (value.length < 1) {
                    return '请填写介绍';
                }
            },
            // 领取限制
            receiveTimesSingle: function (value) {
                if (value.length > 0) {
                    if (!intReg.test(value)) {
                        return '单人可领取次数需为自然数';
                    }
                }
            },
            phaseRightsTotalNum: function (value) {
                if (value.length > 0) {
                    if (!intReg.test(value)) {
                        return '阶段权益总领取数量需为自然数';
                    }
                }
            },
            receiveTimesTotal: function (value) {
                if (value.length > 0) {
                    if (!intReg.test(value)) {
                        return '总领取次数需为自然数';
                    }
                }
            },
            // 商城权益的配置
            rightsId: function (value) {
                if (value.length < 1) {
                    return '请填写权益id';
                }
            },
            rightsStartDate: function (value) {
                if (value.length < 1) {
                    return '请选择权益生效时间';
                }
            },
            rightsEndDate: function (value) {
                if (value.length < 1) {
                    return '请选择权益过期时间';
                }
            },
            rightsNum: function (value) {
                if (value.length < 1) {
                    return '请填写权益次数';
                }
            }
        });

        // 监听提交
        layui.form.on('submit(add)', function (data) {
            $.ajax({
                type: 'POST',
                url: '${path}/rightsActivity/add',
                data: data.field,
                success: function (data) {
                    if (data.success) {
                        layer.alert(data.msg, {icon: 6}, function () {
                            window.parent.location.reload();
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);
                        });
                    } else {
                        layui.layer.msg(data.msg, {icon: 2});
                    }
                }
            });
            return false;
        });
    });

    /**
     * 展示字段的说明
     * @param id
     * @param message
     */
    function showExplain(id, message) {
        layer.tips(message, '#' + id);
    }
</script>
</body>
</html>
