<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="./jquery/jquery-1.11.2.js"></script>
<!-- 注意JS加载顺序 -->
<script src="./bootstrap/js/bootstrap.js"></script>
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap-theme.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="./bbs/toplogin.jsp"></jsp:include>
	<!-- 加上这句打开此页自动执行action -->
	<s:action name="taction" namespace="/" executeResult="true"></s:action>
	<s:include value="./bbs/foot.jsp"></s:include>


</body>
</html>