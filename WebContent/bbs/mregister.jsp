<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册!</title>
<script src="./jquery/jquery-1.11.2.js"></script>
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
			<div class="col-sm-1"></div>
			<div class="col-sm-10 col-sm-offset-1">

				<form class="form-horizontal" role="form" action="userreg"
					method="post">


					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="username"
								placeholder="用户名" name="username" autofocus>
						</div>
					</div>

					<div class="form-group">
						<label for="inputEmail" class="col-sm-2 control-label">电子邮件</label>
						<div class="col-sm-5">
							<input type="email" class="form-control" id="inputEmail"
								placeholder="电子邮件" name="email">
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-5">
							<input type="password" class="form-control" id="inputPassword"
								placeholder="密码" name="pwd">
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword2" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-5">
							<input type="password" class="form-control" id="inputPassword2"
								placeholder="确认密码">
						</div>
					</div>



					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<label class="radio-inline"> <input type="radio"
								name="sex" id="inlineRadio1" value="男"> 男
							</label> <label class="radio-inline"> <input type="radio"
								name="sex" id="inlineRadio2" value="女"> 女
							</label> <label class="radio-inline"> <input type="radio"
								name="sex" id="inlineRadio0" value="保密"> 保密
							</label>
						</div>
					</div>



					<div class="form-group">
						<label for="authcode" class="col-sm-2 control-label">验证码</label>
						<div class="col-sm-5">
							<input type="text" id="authcode" name="authcode" MaxLength="6"
								tabindex="6" placeholder="验证码或者问题答案" /> <img
								id="JD_Verification1" src="rand.action"
								onclick="changeValidateCode(this)" title="点击图片刷新验证码"
								style="cursor: pointer; height: 30px;" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2  col-sm-10 btn-group">
							<div class="btn-group col-sm-3">
								<button type="submit" class="btn  btn-primary btn-lg btn-block">注册</button>
							</div>

							<div class="btn-group col-sm-3">
								<button type="reset" class="btn  btn-success btn-lg btn-block">重填</button>
							</div>

						</div>



					</div>

				</form>
			</div>

		</div>




	</div>

</body>
</body>
</html>