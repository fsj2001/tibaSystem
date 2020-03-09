<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>登录页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords" content="">
<link href="${pageContext.request.contextPath}/css/style2.css" rel='stylesheet' type='text/css' />
<script src=
       "${pageContext.request.contextPath}/js/jquery-1.11.3.min.js">
</script>
</head>
<body>
<h1>题霸系统</h1>
<div class="w3ls-login box">
	<img src="${pageContext.request.contextPath}/images/logo.png" alt="logo_img" />
	<!-- form starts here -->
	<form action="${pageContext.request.contextPath}/login.action" method="post" id="form1">
		<span id="message1">${msg}</span>
		<div class="agile-field-txt">
			<input type="email" name="email" placeholder="邮箱" required="" />
		</div>
		<div class="agile-field-txt">
			<input type="password" name="password" placeholder="密码" required="" />
		</div>
		<div class="w3ls-bot">
			<input type="submit" id="login" value="登录">
		</div>
		<div class="w3ls-bot">
			<input type="button" id="register" value="注册">
		</div>
	</form>

	<form action="${pageContext.request.contextPath}/register.action" method="post" id="form2">
		<span id="message2">${msg}</span>
		<div class="agile-field-txt">
			<input type="email" name="userId" placeholder="邮箱"  required="" />
		</div>
		<div class="agile-field-txt">
			<input type="password" name="password1" placeholder="密码" required=""/>
		</div>
		<div class="agile-field-txt">
			<input type="password" name="password2" placeholder="确认密码" required=""/>
		</div>
		<div class="w3ls-bot">
			<input type="submit" id="assert" value="确认">
		</div>
	</form>

</div>
<script>
	$('#form2').hide();
	$('#register').click(function () {
		$('#form1').hide();
		$('#form2').show();
		$('#message2').text('');
	})
</script>
</body>
</html>
