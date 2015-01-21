<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language="javascript" type="text/javascript"> 
var i = 5; 
var intervalid; 
intervalid = setInterval("fun()", 1000); 
function fun() { 
if (i == 0) { 
window.location.href = "index.jsp"; 
//window.location.href = "index"; 
clearInterval(intervalid); 
} 
document.getElementById("mes").innerHTML = i; 
i--; 
} 
</script>

</head>
<body>
	<div class="container" align="center">

		<p>
			<s:property value="message" /><!--action中的属性message-->
			<s:actionerror/><!-- 显示错误信息 -->
			<s:actionmessage/><!-- 显示message -->
		</p>
		<p>
			将在 <span id="mes">5</span> 秒钟后返回<a href="index.jsp">首页！</a><a
				href="index.jsp">立即返回</a>
		</p>
	</div>
</body>
</html>