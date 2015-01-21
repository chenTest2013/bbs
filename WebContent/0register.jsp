<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册!</title>
<link href="./my/css/formstyle.css" type="text/css" rel="stylesheet" />
<link href="./my/css/regrister.css" type="text/css" rel="stylesheet" />
<script src="./jquery/jquery-2.1.3.js"></script>
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
		<p align="center">用户注册</p>
		<div id="formbox">
			<form id="formpersonal" method="post" onsubmit="return false;"
				action="register">

				<div class="form">
					<h3>帐户信息</h3>
					<div class="item">
						<span class="label"><span class="red">*</span>用户名：</span>
						<div class="fl">
							<input type="text" id="username" name="username" class="text"
								tabindex="1" /> <label id="username_succeed" class="blank"></label>
							<span class="clear"></span>
							<div id="username_error"></div>
						</div>
					</div>
					<!--item end-->

					<div id="o-password">
						<div class="item">
							<span class="label"><span class="red">*</span>设置密码：</span>
							<div class="fl">
								<input type="password" id="pwd" name="pwd" class="text"
									tabindex="2" /> <label id="pwd_succeed" class="blank"></label>
								<input type="checkbox" class="checkbox" id="viewpwd" /> <label
									class="ftx23" for="viewpwd">显示密码字符</label> <span class="clear"></span>
								<label class="hide" id="pwdstrength"><span class="fl">安全程度：</span><b></b></label>
								<label id="pwd_error"></label>
							</div>
						</div>
						<!--item end-->

						<div class="item">
							<span class="label"><span class="red">*</span>确认密码：</span>
							<div class="fl">
								<input type="password" id="pwd2" name="pwd2" class="text"
									tabindex="3" /> <label id="pwd2_succeed" class="blank"></label>
								<span class="clear"></span> <label id="pwd2_error"></label>
							</div>
						</div>
						<!--item end-->

					</div>
					<!--o-password end-->




					<div class="item">
						<span class="label"><span class="red">*</span>性别:</span>
						<div class="radio">
							<label class="radio-inline"> <input type="radio"
								name="sex" id="inlineRadio1" value="option1"> 男
							</label> <label class="radio-inline"> <input type="radio"
								name="sex" id="inlineRadio2" value="option2"> 女
							</label>
						</div>
					</div>




					<div class="item">
						<span class="label"><span class="red">*</span>邮箱：</span>
						<div class="fl">
							<input type="text" id="email" name="email" class="text"
								tabindex="4" /> <label id="mail_succeed" class="blank"></label>
							<span class="clear"></span>
							<div id="mail_error"></div>
						</div>
					</div>
					<!--item end-->

					<div class="item">
						<span class="label"><span class="red">*</span>验证码：</span>
						<div class="fl">


							<input type="text" id="authcode" name="authcode"
								class="text text-1" autocomplete="off" MaxLength="6"
								tabindex="6" /> <label class="img"> <img
								id="JD_Verification1" src="rand.action"
								onclick="changeValidateCode(this)" title="点击图片刷新验证码" alt=""
								style="cursor: pointer; width: 100px; height: 26px;" />
							</label> <label>看不清？点击验证码图片更换</label>
						</div>
					</div>
					<!--item end-->

					<div class="item">
						<span class="label">&nbsp;</span>
						<div class="fl">
							<input type="checkbox" name="protocol" id="protocol" tabindex="7" /><label
								for="protocol">网站用户注册协议</label>
						</div>
					</div>
					<!--item end-->

					<div class="item">
						<span class="label">&nbsp;</span> <input type="button"
							class="yellow_button disabled" id="registsubmit" value="提交注册信息"
							tabindex="8" disabled="disabled" />
					</div>
					<!--item end-->

				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="./my/js/Validate.js"></script>
	<script type="text/javascript" src="./my/js/Validate.form.js"></script>
</body>
</body>
</html>