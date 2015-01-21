<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册!</title>
<script src="./jquery/jquery-2.1.3.js"></script>
<!-- 注意JS加载顺序 -->
<script src="bootstrap/js/bootstrap.js"></script>
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap-theme.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<!-- 如果用户登录包含loginsu.jsp,未登录则包含 toplogin.jsp-->
			<s:if test="#session.userstate">
				<jsp:include page="loginsu.jsp"></jsp:include>
			</s:if>
			<s:else>
				<jsp:include page="topnav.jsp"></jsp:include>
			</s:else>
  
			<jsp:include page="register.jsp"></jsp:include>
			<s:include value="foot.jsp"></s:include>
		</div>
	</div>
</body>
</html>