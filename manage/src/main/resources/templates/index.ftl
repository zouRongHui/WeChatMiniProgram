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
        <link rel="stylesheet" href="${path}/css/font.css">
        <link rel="stylesheet" href="${path}/css/xadmin.css">

        <script src="${path}/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${path}/js/xadmin.js"></script>
        <script>
            // 是否开启刷新记忆tab功能
            var is_remember = false;
        </script>
    </head>
    <body class="index">
        <!-- 顶部开始 -->
        <div class="container">
            <div class="logo">
                <a href="${path}/auth/index">微信小程序-后台管理</a></div>
            <div class="left_open">
                <a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
            </div>

            <ul class="layui-nav right" lay-filter="">
                <li class="layui-nav-item">
                    <a><i class="layui-icon layui-icon-username left-nav-li" style="font-size: 20px"></i>&nbsp;${userInfo.userName!}</a>
                    <dl class="layui-nav-child">
                        <!-- 二级菜单 -->
                        <dd>
                            <a onclick="xadmin.open('修改密码','${path}/user/editpassword?id=${userInfo.id!}',600,300)">
                                <i class="layui-icon layui-icon-edit left-nav-li" style="font-size: 15px"></i>修改密码
                            </a>
                        </dd>
                        <dd>
                            <a href="${path}/auth/logout"><i class="layui-icon layui-icon-close-fill left-nav-li" style="font-size: 15px"></i>退出</a>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>
        <!-- 顶部结束 -->
        <!-- 中部开始 -->
        <!-- 左侧菜单开始 -->
        <div class="left-nav">
            <div id="side-nav">
                <ul id="nav">
                    <#-- 递归 宏定义 -->
                    <#macro bpTree childList>
                        <#if childList?? && childList?size gt 0>
                            <#list childList as child>
                                <#if child.childList?? && child.childList?size gt 0>
                                    <li>
                                        <a href="javascript:">
                                            <i class="layui-icon left-nav-li  ${child.menuIcon!}" style="font-size: 22px"></i>
                                            <cite style="font-size: 15px">${child.menuName!}</cite>
                                            <i class="iconfont nav_right">&#xe6a7;</i>
                                        </a>
                                        <ul class="sub-menu">
                                            <@bpTree childList=child.childList />
                                        </ul>
                                    </li>
                                <#else>
                                    <li>
                                        <a onclick="xadmin.add_tab('${child.menuName!}','${path}${child.url!}')">
                                            <i class="layui-icon left-nav-li ${child.menuIcon!}" style="font-size: 22px"></i>
                                            <cite style="font-size: 15px">${child.menuName!}</cite>
                                            <i class="iconfont nav_right">&#xe6a7;</i>
                                        </a>
                                    </li>
                                </#if>
                            </#list>
                        </#if>
                    </#macro>
                    <#-- 调用宏 生成递归菜单 -->
                    <@bpTree childList=treeMenu />
                </ul>
            </div>
        </div>
        <!-- 左侧菜单结束 -->
        <!-- 右侧主体开始 -->
        <div class="page-content">
            <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
                <ul class="layui-tab-title">
                    <li class="home">
                        <i class="layui-icon">&#xe68e;</i>我的桌面</li></ul>
                <div class="layui-unselect layui-form-select layui-form-selected" id="tab_right">
                    <dl>
                        <dd data-type="this">关闭当前</dd>
                        <dd data-type="other">关闭其它</dd>
                        <dd data-type="all">关闭全部</dd></dl>
                </div>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <iframe src='${path}/auth/welcome' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
                    </div>
                </div>
                <div id="tab_show"></div>
            </div>
        </div>
        <div class="page-content-bg"></div>
        <style id="theme_style"></style>
        <!-- 右侧主体结束 -->
    </body>

</html>