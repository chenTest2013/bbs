<!-- 单独运行这个页面,下拉菜单弹不出的分析 -->

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script language="javascript" type="text/javascript"> 
var i = 5; 
var intervalid; 
intervalid = setInterval("fun()", 1000); 
function fun() { 
if (i == 0) { 
window.location.href = "index"; 
//window.location.href = "index"; 
clearInterval(intervalid); 
} 
document.getElementById("mes").innerHTML = i; 
i--; 
} 
</script>
<div class="container">
	<div class="row" align="center">

		<p>登陆成功</p>
		<p>
			将在 <span id="mes">3</span> 秒钟后返回<a href="index">首页！</a><a
				href="index">立即返回</a>
		</p>
	</div>

</div>

