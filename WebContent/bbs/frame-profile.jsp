<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="./jquery/jquery-2.1.3.js"></script>
<!-- 注意JS加载顺序 -->
<script src="./ckeditor/ckeditor.js"></script>
<script src="./bootstrap/js/bootstrap.js"></script>
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap-theme.css" rel="stylesheet">
<title>个人空间</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<!-- 如果用户登录包含loginsu.jsp,未登录则包含 toplogin.jsp-->
			<s:if test="#session.userstate">
				<jsp:include page="loginsu.jsp"></jsp:include>
			</s:if>
			<s:else>
				<jsp:include page="toplogin.jsp"></jsp:include>
			</s:else>

		</div>
		<div class="row">
			<jsp:include page="userinfo.jsp"></jsp:include>
		</div>
		<div class="row"><jsp:include page="foot.jsp"></jsp:include>
		</div>
	</div>

</body>
</html>