<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
<!-- Bootstrap core CSS -->
<script src="./jquery/jquery-2.1.3.js"></script>
<!-- 注意JS加载顺序 -->
<script src="./bootstrap/js/bootstrap.js"></script>
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap-theme.css" rel="stylesheet">

<link href="data:text/css;charset=utf-8,"
	data-href="./bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"
	id="bs-theme-stylesheet">
<!-- Custom styles for this template -->
<link href="./bootstrap/css/my/signin.css" rel="stylesheet">


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

		<div>
			<div class="">啦啦啦了</div>
			<form class="form-signin" role="form" action="login">
				<h2 class="form-signin-heading">请登录</h2>



				<input type="text" id="inputname" class="form-control"
					placeholder="user name" required autofocus name="username"
					title="请输入用户名" /> <input type="password" id="inputpass"
					class="form-control" placeholder="Password" required
					name="password" />


				<div class="checkbox">
					<label> <input type="checkbox" value="remember-me" required />
						记住我
					</label>
				</div>
				<input type="text" id="authcode" name="authcode" MaxLength="6"
					tabindex="6" placeholder="验证码或者问题答案" required /> <img
					id="JD_Verification1" src="rand.action"
					onclick="changeValidateCode(this)" title="点击图片刷新验证码"
					style="cursor: pointer; height: 30px;" />
				<div class="row">
					<div class="col-xs-6">
						<button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
					</div>
					<div class="col-xs-6">
						<button class="btn btn-lg btn-success btn-block" type="submit">注册</button>
					</div>
				</div>

			</form>
		</div>

	</div>
	<!-- /container -->
</body>
</html>