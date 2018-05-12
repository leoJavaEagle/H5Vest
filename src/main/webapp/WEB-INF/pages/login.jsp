<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
<link type="text/css" rel="stylesheet"
	href="${basePath}/bootstrap/css/bootstrap.css">
<link type="text/css" rel="stylesheet"
	href="${basePath}/bootstrap/css/bootstrap-dialog.min.css">
<link type="text/css" rel="stylesheet"
	href="${basePath}/loanCss/login.css">
</head>
<!-- 登录 -->
<body class="login-bg">
	<div class="login-content">
		<div class="login-background-container">
			<div class="login-content-background"></div>
		</div>
		<div class="login-content-2">

			<!--中间内容-->
			<div class="y-row clearfix">
				<div class="login-title">
					<span>品舒后台系统登录</span>
				</div>
				<!--login-->
				<div class="login-module">
					<div class="alibaba-login-iframe">
						<span id="showInfo"></span>
						<form method="post" id="loginForm">
							<input type="hidden" id="codeStatus" value="${codeStatus }">
							<div id="login-content" class="form clearfix">
								<!--用户名-->
								<dl>
									<dt class="fm-label">
										<span class="icon-user"></span>
									</dt>
									<dd class="fm-field">
										<div class="fm-field-wrap">
											<input class="fm-text" id="txUserId" name="username"
												validate="q" autocomplete="off" maxlength="20"
												placeholder="用户名" required>
										</div>
										<div class="nc_voice text-danger"></div>
									</dd>
								</dl>

								<!--密码-->
								<dl>
									<dt class="fm-label">
										<span class="icon-password"></span>
									</dt>
									<dd class="fm-field">
										<div class="fm-field-wrap">
											<input class="fm-text" id="passwordId" name="password"
												validate="q" autocomplete="off" type="password"
												maxlength="20" placeholder="密码" required>
										</div>
										<div class="nc_voice text-danger"></div>
									</dd>
								</dl>

								<dl class="fm-login-checkcode-nc">
									<dd class="about-checkcode fm-field clearfix">
										<div class="tb-login" id="errorHint" style="display: none;">
											<div class="nc_voice text-danger">
												<span class="glyphicon glyphicon-remove-sign margin-right-1"></span>
												<label id="errorMsg"></label>
											</div>
										</div>
									</dd>
								</dl>
							</div>

							<!--登录按钮-->
							<div class="login-submit">
								<input type="button" value="登录" class="fm-button fm-submit" id="loginSubmit" name="submit-btn">
							</div>
						</form>
					</div>
				</div>

			</div>
			<!--中间内容结束-->
		</div>
	</div>
	<div class="login-foot"></div>
	<script type="text/javascript" src="${basePath}/jquery/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
// 		function $(id) {
// 	        return document.getElementById(id);
// 	    }
	
// 	    function getXMLHttpRequest() {
// 	        var xmlhttp = null;
// 	        //如果有XMLHttpRequest，那就是非IE6浏览器
// 	        if (window.XMLHttpRequest) {
// 	            xmlhttp = new XMLHttpRequest();
// 	        } else {
// 	        	//IE6浏览器创建ajax对象
// 	            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
// 	        }
// 	        return xmlhttp;
// 	    }
	
// 	    function userLogins() {
// 	    	debugger;
	        // 获取XMLHttpRequest
// 	        var xmlhttp = getXMLHttpRequest();
// 	        // 设计响应函数
// 	        xmlhttp.onreadystatechange = function() {
// 	            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
// 	                // 获取响应的正文文本
// 	                var text = xmlhttp.responseText;
// 	                // 将响应的正文文本转换为JSON对象
// 	                var jsonObject = JSON.parse(text);
// 	                // 判断JSON对象中的state是否正确
// 	                if (jsonObject.state == "0000") {
// 		            	window.location.href = "/index/showIndexPage";
// 	                }
// 	            }
// 	        };
	        // 发出请求
// 			var username = $("txUserId").value;
// 			var password = $("passwordId").value;
// 	        var url = "/console/checkLogin?userName=" + username;
// 	        var data = $("#loginForm").serialize();
// 			alert(username + ", " + password);
// 			var url = "/console/checkLogin";
// 	        xmlhttp.open("get", url, true);
// 	        xmlhttp.send();
// 	    }
	
		$("#loginSubmit").click(function() {
			$("#showInfo").text("");
			var name = $("#txUserId").val();
			var pwd = $("#passwordId").val();
			var data = $("#loginForm").serialize();
			$.ajax({
			     url: "/console/checkLogin",
			     data: JSON.stringify({"username":name,"password":pwd}),
			     type: "POST",
			     contentType: "application/json;charset=utf-8",
			     success: function(obj){
			    	 if(obj.code == "000000") {
				    	 window.location.href = "/index/showIndexPage";
			    	 }else {
			    		 $("#showInfo").text("用户名或密码有误！").css("color", "red");
			    	 }
			     }
			});
		});
	</script>
</body>
</html>