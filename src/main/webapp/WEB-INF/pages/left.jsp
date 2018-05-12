<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="active treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>马甲管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a id="load-product-id" href="#"><i class="fa fa-circle-o"></i>产品管理</a></li>
            <li><a id="load-article-id" href="#"><i class="fa fa-circle-o"></i>资讯管理</a></li>
            <li><a id="load-problem-id" href="#"><i class="fa fa-circle-o"></i>常见问题</a></li>
            <li><a id="load-model-id" href="#"><i class="fa fa-circle-o"></i>模块管理</a></li>
          </ul>
        </li>
<!--         <li class="treeview">
          <a href="#">
            <i class="fa fa-files-o"></i>
            <span>系统管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#"><i class="fa fa-circle-o"></i>组织管理</a></li>
            <li><a id="load-role-id"><i class="fa fa-circle-o"></i>角色管理</a></li>
            <li><a id="load-menu-id"><i class="fa fa-circle-o"></i>菜单管理</a></li>
            <li><a id="load-user-id"><i class="fa fa-circle-o"></i>用户管理</a></li>
          </ul>
        </li>
         -->
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
<script type="text/javascript">
$('#load-product-id').click(function(){
	var url="showProduct?t="+Math.random(1000);
	$(".content").load(url);
})
$('#load-article-id').click(function(){
	var url="showArticle?t="+Math.random(1000);
	$(".content").load(url);
})
$('#load-problem-id').click(function(){
	var url="?t="+Math.random(1000);
	$(".content").load(url);
})
$('#load-model-id').click(function(){
	var url="showModel?t="+Math.random(1000);
	$(".content").load(url);
})
</script>