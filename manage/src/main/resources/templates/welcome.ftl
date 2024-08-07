<#assign path="${springMacroRequestContext.getContextPath()}">
<!DOCTYPE html>
<html lang="en" class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>我的桌面</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8" />

        <link rel="stylesheet" href="${path}/css/font.css">
        <link rel="stylesheet" href="${path}/css/xadmin.css">

        <script src="${path}/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${path}/js/xadmin.js"></script>
    </head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <blockquote class="layui-elem-quote">欢迎
                                <span class="x-red">${userInfo.userName}</span>！当前时间：<span id="show_time"></span>
                            </blockquote>
                        </div>
                    </div>
                </div>
                <#--<div class="layui-col-md12">-->
                    <#--<div class="layui-card">-->
                        <#--<div class="layui-card-header">数据统计</div>-->
                        <#--<div class="layui-card-body ">-->
                            <#--<ul class="layui-row layui-col-space10 layui-this x-admin-carousel x-admin-backlog">-->
                                <#--<li class="layui-col-md2 layui-col-xs6">-->
                                    <#--<a href="javascript:;" class="x-admin-backlog-body">-->
                                        <#--<h3>文章数</h3>-->
                                        <#--<p>-->
                                            <#--<cite>66</cite></p>-->
                                    <#--</a>-->
                                <#--</li>-->
                                <#--<li class="layui-col-md2 layui-col-xs6">-->
                                    <#--<a href="javascript:;" class="x-admin-backlog-body">-->
                                        <#--<h3>会员数</h3>-->
                                        <#--<p>-->
                                            <#--<cite>12</cite></p>-->
                                    <#--</a>-->
                                <#--</li>-->
                                <#--<li class="layui-col-md2 layui-col-xs6">-->
                                    <#--<a href="javascript:;" class="x-admin-backlog-body">-->
                                        <#--<h3>回复数</h3>-->
                                        <#--<p>-->
                                            <#--<cite>99</cite></p>-->
                                    <#--</a>-->
                                <#--</li>-->
                                <#--<li class="layui-col-md2 layui-col-xs6">-->
                                    <#--<a href="javascript:;" class="x-admin-backlog-body">-->
                                        <#--<h3>商品数</h3>-->
                                        <#--<p>-->
                                            <#--<cite>67</cite></p>-->
                                    <#--</a>-->
                                <#--</li>-->
                                <#--<li class="layui-col-md2 layui-col-xs6">-->
                                    <#--<a href="javascript:;" class="x-admin-backlog-body">-->
                                        <#--<h3>文章数</h3>-->
                                        <#--<p>-->
                                            <#--<cite>67</cite></p>-->
                                    <#--</a>-->
                                <#--</li>-->
                                <#--<li class="layui-col-md2 layui-col-xs6 ">-->
                                    <#--<a href="javascript:;" class="x-admin-backlog-body">-->
                                        <#--<h3>文章数</h3>-->
                                        <#--<p>-->
                                            <#--<cite>6766</cite></p>-->
                                    <#--</a>-->
                                <#--</li>-->
                            <#--</ul>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="layui-col-sm6 layui-col-md3">-->
                    <#--<div class="layui-card">-->
                        <#--<div class="layui-card-header">下载-->
                            <#--<span class="layui-badge layui-bg-cyan layuiadmin-badge">月</span></div>-->
                        <#--<div class="layui-card-body  ">-->
                            <#--<p class="layuiadmin-big-font">33,555</p>-->
                            <#--<p>新下载-->
                                <#--<span class="layuiadmin-span-color">10%-->
                                    <#--<i class="layui-inline layui-icon layui-icon-face-smile-b"></i></span>-->
                            <#--</p>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="layui-col-sm6 layui-col-md3">-->
                    <#--<div class="layui-card">-->
                        <#--<div class="layui-card-header">下载-->
                            <#--<span class="layui-badge layui-bg-cyan layuiadmin-badge">月</span></div>-->
                        <#--<div class="layui-card-body ">-->
                            <#--<p class="layuiadmin-big-font">33,555</p>-->
                            <#--<p>新下载-->
                                <#--<span class="layuiadmin-span-color">10%-->
                                    <#--<i class="layui-inline layui-icon layui-icon-face-smile-b"></i></span>-->
                            <#--</p>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="layui-col-sm6 layui-col-md3">-->
                    <#--<div class="layui-card">-->
                        <#--<div class="layui-card-header">下载-->
                            <#--<span class="layui-badge layui-bg-cyan layuiadmin-badge">月</span></div>-->
                        <#--<div class="layui-card-body ">-->
                            <#--<p class="layuiadmin-big-font">33,555</p>-->
                            <#--<p>新下载-->
                                <#--<span class="layuiadmin-span-color">10%-->
                                    <#--<i class="layui-inline layui-icon layui-icon-face-smile-b"></i></span>-->
                            <#--</p>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="layui-col-sm6 layui-col-md3">-->
                    <#--<div class="layui-card">-->
                        <#--<div class="layui-card-header">下载-->
                            <#--<span class="layui-badge layui-bg-cyan layuiadmin-badge">月</span></div>-->
                        <#--<div class="layui-card-body ">-->
                            <#--<p class="layuiadmin-big-font">33,555</p>-->
                            <#--<p>新下载-->
                                <#--<span class="layuiadmin-span-color">10%-->
                                    <#--<i class="layui-inline layui-icon layui-icon-face-smile-b"></i></span>-->
                            <#--</p>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="layui-col-md12">-->
                    <#--<div class="layui-card">-->
                        <#--<div class="layui-card-header">系统信息</div>-->
                        <#--<div class="layui-card-body ">-->
                            <#--<table class="layui-table">-->
                                <#--<tbody>-->
                                    <#--<tr>-->
                                        <#--<th>xxx版本</th>-->
                                        <#--<td>1.0.180420</td></tr>-->
                                    <#--<tr>-->
                                        <#--<th>服务器地址</th>-->
                                        <#--<td>x.xuebingsi.com</td></tr>-->
                                    <#--<tr>-->
                                        <#--<th>操作系统</th>-->
                                        <#--<td>WINNT</td></tr>-->
                                    <#--<tr>-->
                                        <#--<th>运行环境</th>-->
                                        <#--<td>Apache/2.4.23 (Win32) OpenSSL/1.0.2j mod_fcgid/2.3.9</td></tr>-->
                                    <#--<tr>-->
                                        <#--<th>PHP版本</th>-->
                                        <#--<td>5.6.27</td></tr>-->
                                    <#--<tr>-->
                                        <#--<th>PHP运行方式</th>-->
                                        <#--<td>cgi-fcgi</td></tr>-->
                                    <#--<tr>-->
                                        <#--<th>MYSQL版本</th>-->
                                        <#--<td>5.5.53</td></tr>-->
                                    <#--<tr>-->
                                        <#--<th>ThinkPHP</th>-->
                                        <#--<td>5.0.18</td></tr>-->
                                    <#--<tr>-->
                                        <#--<th>上传附件限制</th>-->
                                        <#--<td>2M</td></tr>-->
                                    <#--<tr>-->
                                        <#--<th>执行时间限制</th>-->
                                        <#--<td>30s</td></tr>-->
                                    <#--<tr>-->
                                        <#--<th>剩余空间</th>-->
                                        <#--<td>86015.2M</td></tr>-->
                                <#--</tbody>-->
                            <#--</table>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="layui-col-md12">-->
                    <#--<div class="layui-card">-->
                        <#--<div class="layui-card-header">开发团队</div>-->
                        <#--<div class="layui-card-body ">-->
                            <#--<table class="layui-table">-->
                                <#--<tbody>-->
                                    <#--<tr>-->
                                        <#--<th>版权所有</th>-->
                                        <#--<td>xuebingsi(xuebingsi)-->
                                            <#--<a href="http://x.xuebingsi.com/" target="_blank">访问官网</a></td>-->
                                    <#--</tr>-->
                                    <#--<tr>-->
                                        <#--<th>开发者</th>-->
                                        <#--<td>马志斌(113664000@qq.com)</td></tr>-->
                                <#--</tbody>-->
                            <#--</table>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<style id="welcome_style"></style>-->
                <#--<div class="layui-col-md12">-->
                    <#--<blockquote class="layui-elem-quote layui-quote-nm">感谢layui,百度Echarts,jquery,本系统由x-admin提供技术支持。</blockquote></div>-->
            </div>
        </div>
        </div>
    </body>
<script type="text/javascript">
    setInterval("fun(show_time)",1);

    function fun(timeID) {
        var date = new Date();
        var y = date.getFullYear();
        var M = date.getMonth() + 1;
        var d = date.getDate();

        var w = date.getDay();
        var ww = '  星期'+'日一二三四五六'.charAt(w);

        var H = date.getHours();
        var m = date.getMinutes();
        var s = date.getSeconds();

        if (M < 10) {
            M = "0" + M;
        }
        if (d < 10) {
            d = "0" + d;
        }
        if (H < 10) {
            H = "0" + H;
        }
        if (m < 10) {
            m = "0" + m;
        }
        if (s < 10) {
            s = "0" + s;
        }

        document.getElementById(timeID.id).innerHTML
                = y + "-" + M + "-" + d + "&nbsp;&nbsp;" + H + ":" + m + ":" + s + "&nbsp;&nbsp;&nbsp;" + ww;

    }
</script>
</html>