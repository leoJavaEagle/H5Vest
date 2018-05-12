<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script type="text/javascript" src="https://webapi.amap.com/maps?v=1.3&key=${javascriptMapKey}"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-1.9.1.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/framework/jquery.spine.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/framework/jquery.spine.framework.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/ajaxfileupload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/formValidate.js"></script>
<!-- 后台富文本编辑器的css和js文件begin -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/components/kindeditor-4.1.10/themes/default/default.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/components/kindeditor-4.1.10/plugins/code/prettify.css" />
<script charset="utf-8" src="${pageContext.request.contextPath}/js/components/kindeditor-4.1.10/kindeditor.js"></script>
<script charset="utf-8" src="${pageContext.request.contextPath}/js/components/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script charset="utf-8" src="${pageContext.request.contextPath}/js/components/kindeditor-4.1.10/plugins/code/prettify.js"></script>
<script charset="utf-8" src="${pageContext.request.contextPath}/js/components/kindeditor-4.1.10/textFileEditor.js"></script>
<!-- 后台富文本编辑器的css和js文件end -->

<!-- 样式 -->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/loanCss/bootstrap.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/loanCss/bootstrap-datetimepicker.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/loanCss/bootstrap-dialog.min.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/loanCss/console.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/loanCss/user.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/DM.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/DM.Util.js"></script>


<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/ajaxfileupload.js"></script>

<!--[if lt IE 9]>
    <script src="js/common/browser-not-supported.js"></script>
    <![endif]-->

<script data-main="${pageContext.request.contextPath}/js/common/loanMain" src="${pageContext.request.contextPath}/js/common/require.min.js"></script>
  
<script>
var basePath="${pageContext.request.contextPath}/"; 
var fileFormat='${fileFormat.fileFormat}';
var fileSize='${fileFormat.fileSize}';

var loginUrl='${LOGIN_URL}';
var loginLogoutUrl='${LOGIN_LOGOUT_URL}';
var homeUrl='${HOME_URL}';
</script>