<#assign path="${springMacroRequestContext.getContextPath()}">
<!DOCTYPE html>
<html lang="en" class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>小程序产品菜单分类列表</title>
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
            <a href="" onclick="window.parent.xadmin.add_tab('产品菜单管理','${path}/productmenu/list')">产品菜单管理</a>
            <a><cite>产品菜单分类</cite></a>
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
                                    <input type="text" name="categoryName"  placeholder="请输入分类名称" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                                </div>
                            </form>
                        </div>
                        <div class="layui-card-header">
                            <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
                            <button class="layui-btn" onclick="xadmin.open('添加','${path}/productmenucategory/add',600,400)"><i class="layui-icon"></i>添加</button>
                        </div>
                        <div class="layui-card-body ">
                            <table class="layui-table layui-form">
                              <thead>
                                <tr>
                                  <th width="10px">
                                    <input type="checkbox" lay-filter="checkall" name=""  lay-skin="primary">
                                  </th>
                                  <th width="130px">分类名称</th>
                                  <th width="400">描述</th>
                                  <th width="80px">展示风格</th>
                                  <th width="20px">排序</th>
                                  <th width="140px">操作</th>
                                </tr>
                              </thead>
                              <tbody>
                                  <#list productMenuCategoryList as productMenuCategory>
                                      <tr data-id="${productMenuCategory.id!}">
                                          <td>
                                              <input type="checkbox"  name="id"  lay-skin="primary">
                                          </td>
                                          <td>${productMenuCategory.categoryName!}</td>
                                          <td>${productMenuCategory.categoryDesc!}</td>
                                          <#if productMenuCategory.showStyle == '1'>
                                              <td>横向</td>
                                          <#else>
                                              <td>竖向</td>
                                          </#if>
                                          <td>
                                              <input style="width: 10px;padding: 5px 15px;" type="text" name="sort" value="${productMenuCategory.sort!}">
                                          </td>
                                          <td class="td-manage">
                                              <button class="layui-btn layui-btn-xs layui-btn-normal"  onclick="xadmin.open('编辑','${path}/productmenucategory/edit?id=${productMenuCategory.id!}',600,400)" >
                                                  <i class="layui-icon layui-icon-edit"></i>编辑
                                              </button>
                                              <button class="layui-btn layui-btn-xs layui-btn-danger"  onclick="member_del(this,'${productMenuCategory.id!}')" >
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

          var categoryName;
          //监听提交
          form.on('submit(sreach)', function(data){
              categoryName = data.field.categoryName;
              window.location.href = '${path}/productmenucategory/list?categoryName='+categoryName;
              return false;
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
                      window.location.href = '${path}/productmenucategory/list?page='+page+'&size='+size+'&categoryName='+categoryName;
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
                  url:'${path}/productmenucategory/sort',
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
              url:'${path}/productmenucategory/delete',
              data:{ids:ids},
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
    </script>
</html>