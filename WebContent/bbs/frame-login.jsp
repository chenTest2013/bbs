<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登陆!</title>
<script src="./jquery/jquery-2.1.3.js"></script>
<!-- 注意JS加载顺序 -->
<script src="./bootstrap/js/bootstrap.js"></script>
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap-theme.css" rel="stylesheet">
<script type="text/javascript"> 
function changeValidateCode(obj) { 
//获取当前的时间作为参数，无具体意义 
var timenow = new Date().getTime(); 
//每次请求需要一个不同的参数，否则可能会返回同样的验证码 
//这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。 
obj.src="rand.action?d="+timenow; 
} 
</script>

</head>
<body>
	<div class="container">
		<div class="row">
			<!-- 如果用户登录包含loginsu.jsp,未登录则包含 toplogin.jsp-->

			<jsp:include page="./topnav.jsp"></jsp:include>


			<jsp:include page="./login.jsp"></jsp:include>
			<s:include value="./foot.jsp"></s:include>
		</div>
	</div>
</body>
</html>