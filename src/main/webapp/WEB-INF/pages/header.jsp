<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="base" scope="request" value="${pageContext.request.contextPath }"></c:set>
<header class="main-header">
    <!-- Logo -->
    <a href="#" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>M</b>JXT</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg">马甲管理系统</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          <!-- Tasks: style can be found in dropdown.less -->
<!--           <li class="dropdown tasks-menu"> -->
<!--             <a href="#" class="dropdown-toggle" data-toggle="dropdown"> -->
<!--               <i class="fa fa-flag-o"></i> -->
<!--               <span class="label label-danger">9</span> -->
<!--             </a> -->
<!--             <ul class="dropdown-menu"> -->
<!--               <li class="header">You have 9 tasks</li> -->
<!--               <li class="footer"> -->
<!--                 <a href="#">View all tasks</a> -->
<!--               </li> -->
<!--             </ul> -->
<!--           </li> -->
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
	            <c:choose>
	              <c:when test="${username == null }">
	                <li><a href="${base }/console/login">登录</a></li>
	              </c:when>
	              <c:otherwise>
	              	<img src="${basePath}/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
	                <span class="hidden-xs">欢迎您  ${username }</span>
	                <li><a href="${base }/console/logout">退出</a></li>
	              </c:otherwise>
	            </c:choose>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="${basePath}/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                <p>
                  Java Developer
                  <small>Member since Nov. 2016</small>
                </p>
              </li>
              <!-- Menu Body -->
              <li class="user-body">
                <div class="row">
                  <div class="col-xs-4 text-center">
                    <a href="#">Followers</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Sales</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Friends</a>
                  </div>
                </div>
                <!-- /.row -->
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                  <a href="logout.do" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <li>
            <a data-toggle="control-sidebar"></a>
          </li>
        </ul>
      </div>
    </nav>
  </header>