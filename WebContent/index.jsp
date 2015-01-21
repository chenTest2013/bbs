<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎光临!cjava.cn</title>
<script src="./jquery/jquery-2.1.3.js"></script>
<!-- 注意JS加载顺序 -->
<script src="./bootstrap/js/bootstrap.js"></script>
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap-theme.css" rel="stylesheet">

</head>
<body>
	<div class="container">

		<div class="row">
			<!-- 如果用户登录包含loginsu.jsp,未登录则包含 toplogin.jsp-->
			<s:if test="#session.userstate">
				<jsp:include page="WEB-INF/bbs/loginsu.jsp"></jsp:include>
			</s:if>
			<s:else>
				<jsp:include page="WEB-INF/bbs/toplogin.jsp"></jsp:include>
			</s:else>

		</div>
		<div class="row"><jsp:include page="WEB-INF/bbs/listboard.jsp"></jsp:include></div>
		<div class="row">
			<s:include value="WEB-INF/bbs/foot.jsp"></s:include>
		</div>
	</div>

</body>
</html>