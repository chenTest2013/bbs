<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 显示单个帖子,和其回复信息的框架 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:property value="#session.t.title" /> --By cjava.cn!</title>
<script src="./jquery/jquery-2.1.3.js"></script>
<!-- 注意JS加载顺序 -->
<script src="./ckeditor/ckeditor.js"></script>
<script src="./bootstrap/js/bootstrap.js"></script>
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap-theme.css" rel="stylesheet">
</head>
<body>
	<!-- 如果用户登录包含loginsu.jsp,未登录则包含 toplogin.jsp-->
	<s:if test="#session.userstate">
		<jsp:include page="loginsu.jsp"></jsp:include>
	</s:if>
	<s:else>
		<jsp:include page="toplogin.jsp"></jsp:include>
	</s:else>

	<jsp:include page="singletopic.jsp"></jsp:include>
	<s:include value="foot.jsp"></s:include>


</body>
</html>