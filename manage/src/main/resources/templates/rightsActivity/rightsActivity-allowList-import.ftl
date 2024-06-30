<#assign path="${springMacroRequestContext.getContextPath()}">
<!DOCTYPE html>
<html lang="en" class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>权益白名单-导入</title>
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
    <div class="layui-row ">
        <button type="button" class="layui-btn" onclick="downloadImportTemplate()">
            <i class="layui-icon">&#xe601;</i>白名单模板下载
        </button>
        <button type="button" class="layui-btn" id="btn_upload">
            <i class="layui-icon">&#xe67c;</i>白名单上传
        </button>
    </div>
    </br>
    <div class="layui-row x-red">
        <p>1.导入模式为增量导入(即不影响现有的白名单数据)</p>
        <p>2.导入的excel文件仅会处理第一个sheet页，若数据很多请多次操作</p>
    </div>
</div>
<script>
    layui.use(['upload', 'layer'], function() {
        $ = layui.jquery;
        var upload = layui.upload;
        var layer = layui.layer;
        var uploadMsg;
        upload.render({
            elem: '#btn_upload',
            accept: 'file',// 指定上传的文件类型
            exts: 'xlsx',// 指定支持上传的文件后缀
            url: '${path}/rightsActivity/allowListImport',
            data: {rightsActivityId: '${id}'},
            before:function(obj){
                uploadMsg = loading("文件上传中");
            },
            done: function (data) {
                if(uploadMsg){
                    layer.close(uploadMsg);
                }
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
            },error:function(){
                if(uploadMsg){
                    layer.close(uploadMsg);
                }
            }
        });
    });

    /**
     * 加载中
     * @param content
     * @returns {*}
     */
    function loading(content){
        return layer.msg(content,{icon:16,shade:[0.5,'#f5f5f5'],scrollbar:false,offset:'auto',time:0});
    }

    /**
     * 下载导入模板
     */
    function downloadImportTemplate() {
        window.open("${path}/excel/rightsActivity-allowListImport.xlsx");
    }
</script>
</body>
</html>
