<#assign path="${springMacroRequestContext.getContextPath()}">
<!DOCTYPE html>
<html lang="en" class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>小程序产品菜单列表</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8" />

        <link rel="stylesheet" href="${path}/css/font.css">
        <link rel="stylesheet" href="${path}/css/xadmin.css">

        <script src="${path}/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${path}/js/xadmin.js"></script>
        <script type="text/javascript" src="${path}/js/jquery.min.js"></script>
    </head>
    <body>
        <div class="x-nav">
          <span class="layui-breadcrumb">
            <a><cite>产品菜单管理</cite></a>
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
                            <form class="layui-form layui-col-space5">
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="menuName"  placeholder="请输菜单名称" autocomplete="off" class="layui-input" value="${menuName!''}">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <select name="categoryId">
                                        <option value="">菜单分类</option>
                                        <#list categoryList as category>
                                            <option value="${category.id!}"
                                            <#if category.id == categoryId!-1>
                                                selected
                                            </#if>
                                            >${category.categoryName!}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                                </div>
                            </form>
                        </div>
                        <div class="layui-card-header">
                            <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
                            <button class="layui-btn" onclick="xadmin.open('添加','${path}/productmenu/add',600,550)"><i class="layui-icon"></i>添加</button>
                            <button class="layui-btn layui-btn-warm" style="float: right" onclick="window.parent.xadmin.add_tab('产品菜单分类','${path}/productmenucategory/list')">产品菜单分类</button>
                        </div>
                        <div class="layui-card-body ">
                            <table class="layui-table layui-form">
                              <thead>
                                <tr>
                                  <th width="10px">
                                    <input type="checkbox" lay-filter="checkall" name=""  lay-skin="primary">
                                  </th>
                                  <th width="80px">菜单名称</th>
                                  <th width="100px">产品说明</th>
                                  <th width="100px">菜单分类</th>
                                  <th width="100px">负责人工号</th>
                                  <th width="100px">是否需要登陆</th>
                                  <#--<th width="100px">业务类型</th>-->
                                  <#--<th width="100px">可购页面</th>-->
                                  <#--<th width="100px">可购页面参数</th>-->
                                  <#--<th width="100px">持有页面</th>-->
                                  <#--<th width="100px">持有页面参数</th>-->
                                  <th width="100px">是否启用</th>
                                  <th width="100px">首页是否展示</th>
                                  <th width="20px">排序</th>
                                  <th width="140px">操作</th>
                              </thead>
                              <tbody>
                                  <#list productMenuList as productMenu>
                                      <tr data-id="${productMenu.id!}">
                                          <td>
                                              <input type="checkbox" name="rowId"  lay-skin="primary">
                                          </td>
                                          <td>${productMenu.menuName!}</td>
                                          <td>${productMenu.productDesc!}</td>
                                          <td>${productMenu.categoryName!}</td>
                                          <td>${productMenu.consultWorkNo!}</td>
                                          <td><#if productMenu.needLogin == '1'>是<#else>否</#if></td>
                                          <#--<td>${productMenu.businessType!}</td>-->
                                          <#--<td>${productMenu.jumpUrl!}</td>-->
                                          <#--<td>${productMenu.jumpParam!}</td>-->
                                          <#--<td>${productMenu.holdUrl!}</td>-->
                                          <#--<td>${productMenu.holdParam!}</td>-->
                                          <#if (productMenu.usable == '1')>
                                          <td>
                                              <input type="checkbox" name="usable" lay-text="启用|禁用" value="${productMenu.id!}" lay-skin="switch" lay-filter="usable" checked>
                                          </td>
                                          <#else>
                                          <td>
                                              <input type="checkbox" name="usable" lay-text="启用|禁用" value="${productMenu.id!}" lay-skin="switch" lay-filter="usable">
                                          </td>
                                          </#if>
                                          <#if (productMenu.showFirst == '1')>
                                          <td>
                                              <input type="checkbox" name="showFirst" lay-text="展示|隐藏" value="${productMenu.id!}" lay-skin="switch" lay-filter="showFirst" checked>
                                          </td>
                                          <#else>
                                          <td>
                                              <input type="checkbox" name="showFirst" lay-text="展示|隐藏" value="${productMenu.id!}" lay-skin="switch" lay-filter="showFirst">
                                          </td>
                                          </#if>
                                          <td><input style="width: 10px;padding: 5px 15px;" type="text" name="sort" value="${productMenu.sort!}"></td>
                                          <td class="td-manage" style="white-space: nowrap">
                                              <button class="layui-btn layui-btn-xs layui-btn-normal"  onclick="xadmin.open('编辑','${path}/productmenu/edit?id=${productMenu.id!}',600,550)" >
                                                  <i class="layui-icon layui-icon-edit"></i>编辑
                                              </button>
                                              <button class="layui-btn layui-btn-xs layui-btn-danger"  onclick="member_del(this,'${productMenu.id!}')" >
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
      layui.use(['laypage','form'], function(){
        var form = layui.form;
        var laypage = layui.laypage;
          var menuName;
          var categoryId;
          //监听提交
          form.on('submit(sreach)', function(data){
              menuName = data.field.menuName;
              categoryId = data.field.categoryId;
              window.location.href = '${path}/productmenu/list?menuName='+menuName+'&categoryId='+categoryId;
              return false;
          });

          //监听是否启用开关
          form.on('switch(usable)', function (data) {
              if (data.elem.checked) {
                  usable(data.value);
              } else {
                  disable(data.value);
              }
          });

          //监听首页是否展示开关
          form.on('switch(showFirst)', function (data) {
              if (data.elem.checked) {
                  show(data.value);
              } else {
                  hidden(data.value);
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
                      window.location.href = '${path}/productmenu/list?page='+page+'&size='+size+'&menuName='+menuName+'&categoryId='+categoryId;
                  }
              }
          });

          // 监听全选
          form.on('checkbox(checkall)', function(data){
              if(data.elem.checked){
                  $('tbody input[name="rowId"]').prop('checked',true);
              }else{
                  $('tbody input[name="rowId"]').prop('checked',false);
              }
              form.render('checkbox');
          });

      });

      /**
       * 启用
       */
      function usable(id) {
          $.ajax({
              type:'POST',
              url:'${path}/productmenu/usable',
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
      /**
       * 禁用
       */
      function disable(id) {
          $.ajax({
              type:'POST',
              url:'${path}/productmenu/disable',
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
      /**
       * 展示
       */
      function show(id) {
          $.ajax({
              type:'POST',
              url:'${path}/productmenu/show',
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
      /**
       * 隐藏
       */
      function hidden(id) {
          $.ajax({
              type:'POST',
              url:'${path}/productmenu/hidden',
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

      /* 排序 */
      $("[name='sort']").on('change',function (obj) {
          var sort = $(this).val();
          if (isNaN(sort) || parseInt(sort) === 0 || sort === "") {
              layer.msg('请输入非零数字', {icon: 2,time:1000});
              setTimeout(function () {
                  window.location.reload();
              },1000);
          } else {
              var id = $(this).parents('tr').data('id');
              $.ajax({
                  type:'POST',
                  url:'${path}/productmenu/sort',
                  data:{id:id,sort:sort},
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
      });

      /*角色-删除*/
      function member_del(obj,id){
          var ids = [];
          ids.push(id);
          layer.confirm('确认要删除吗？',function(index){
              del(ids)
          });
      }

      /*角色-批量删除*/
      function delAll (argument) {
          var ids = [];

          // 获取选中的id
          $('tbody input[name="rowId"]').each(function(index, el) {
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
              url:'${path}/productmenu/delete',
              data:{ids:ids},
              traditional:true,
              success:function (data) {
                  if (data.success){
                      layer.msg(data.msg, {icon: 1,time:1000});
                      setTimeout(function () {
                          window.location.reload();
                      },1000);
                  }else{
                      layer.msg(data.msg, {icon: 2,time:1500});
                  }
              }
          });
      }
    </script>
</html>