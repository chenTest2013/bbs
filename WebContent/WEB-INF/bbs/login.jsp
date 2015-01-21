<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
<script> 
function changeValidateCode(obj) { 
	//获取当前的时间作为参数，无具体意义 
	var timenow = new Date().getTime(); 
	//每次请求需要一个不同的参数，否则可能会返回同样的验证码 
	//这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。 
	obj.src="rand?d="+timenow; 
	}
</script>

<!-- Custom styles for this template -->
<link href="./bootstrap/css/my/signin.css" rel="stylesheet">


</head>

	
		<div>
			<form class="form-signin" role="form" action="login" id="loginform" method="post">
				<h2 class="form-signin-heading">请登录</h2>


				<input type="text" id="inputname" class="form-control"
					placeholder="user name" required autofocus name="username"
					title="请输入用户名" required /> <input type="password" id="inputPassword"
					class="form-control" placeholder="Password" required
					name="password" title="请输入密码" required />


				<!-- <div class="checkbox">
					<label> <input type="checkbox" value="remember-me" /> 记住我
					</label>
				</div>
 -->
				<input type="text" id="authcode" name="authcode" MaxLength="4"
					tabindex="6" placeholder="验证码或者问题答案" required title="请输入验证码或问题答案" />
				<img id="JD_Verification1" src="rand.action"
					onclick="changeValidateCode(this)" title="点击图片刷新验证码" height="30px" />
				<div class="row">
					<div class="col-xs-6">
						<button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
					</div>
					<div class="col-xs-6">
						<a href="reg" target="_blank"><button
								class="btn btn-lg btn-success btn-block" type="button">注册</button></a>
					</div>
				</div>

			</form>
		</div>