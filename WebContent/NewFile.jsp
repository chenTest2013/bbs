<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>验证码测试登录页面</title>

<script type="text/javascript">
	function changeimg()

	{

		var myimg = document.getElementById("code");
		now = new Date();
		myimg.src = "makeCertPic.jsp?code=" + now.getTime();
	}
</script>
</head>
<body>
	<center>
		<form action="loginCheck.jsp" method="post">
			用户名：<input type="text" name="username" /><br> 密&nbsp;&nbsp;码：<input
				type="password" name="password" /><br> &nbsp;验证码：<input
				type="text" name="certCode" /> <img id="code"
				src="./util/makeCertPic.jsp"><a href="javascript:changeimg()">看不清，换一张
			</a><br> <input type="submit" value="登录" />
		</form>
	</center>
</body>
</html>