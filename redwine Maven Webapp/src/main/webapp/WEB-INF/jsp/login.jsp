<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>登录</title>
<!-- Custom Theme files -->
<link href="css/login/style.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<!--Google Fonts-->
<link href='http://fonts.useso.com/css?family=Roboto:500,900italic,900,400italic,100,700italic,300,700,500italic,100italic,300italic,400' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
<!--Google Fonts-->
</head>
<body>
<div class="login">
	<h2>登录表单</h2>
	<div class="login-top">
		<h1><font size="+3">进口红酒管理系统</font></h1>
		<form action="${pageContext.request.contextPath}/admin/adminLogin" method="post">
			<input type="text" value="用户名" onfocus="this.value = '';" name="admin_name" onblur="if (this.value == '') {this.value = '用户名';}">
            	
			<input type="password" value="******" onfocus="this.value = '';" name="admin_password" onblur="if (this.value == '') {this.value = '******';}">
            
            <div class="forgot">
	    		<input type="submit" value="登录" >
	    	</div>
	    </form>
	</div>
	<div class="login-bottom">
		<h3><font size="+2">${message}</font></h3>
	</div>
</div>	
<div class="copyright">

</div>


</body>
</html>
