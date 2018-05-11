<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>login</title>
<link type="text/css" rel="stylesheet"
	href="${basePath}/loanCss/bootstrap.css">
<link type="text/css" rel="stylesheet"
	href="${basePath}/loanCss/bootstrap-dialog.min.css">
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
						<form method="post" id="loginForm" action="/console/checkLogin.do">
							<input type="hidden" id="codeStatus" value="${codeStatus }">
							<div id="login-content" class="form clearfix">
								<!--用户名-->
								<dl>
									<dt class="fm-label">
										<span class="icon-user"></span>
									</dt>
									<dd class="fm-field">
										<div class="fm-field-wrap">
											<input class="fm-text" id="txUserId" name="userName"
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
								<input type="submit" value="登录" class="fm-button fm-submit" id="loginSubmit" name="submit-btn">
							</div>
						</form>
					</div>
				</div>

			</div>
			<!--中间内容结束-->
		</div>
	</div>
	<div class="login-foot"></div>
	<script type="text/javascript" src="${basePath}/js/common/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$("#loginSubmit").click(function() {
			$("#showInfo").text("");
			var url = "console/checkLogin.do";
			var data = $("#loginForm").serialize();
			$.post(url,data,function(obj) {
				alert("456");
				if(obj.getCode == "0000") {
					window.location.href = "index/showIndexPage.do";
				}else {
					$("#showInfo").text("用户名或密码有误！").css("color", "red");
				}
			});
		});
	</script>
</body>
</html>