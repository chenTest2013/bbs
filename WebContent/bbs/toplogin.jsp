<!-- 单独运行这个页面,下拉菜单弹不出的分析 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript"> 
function changeValidateCode(obj) { 
//获取当前的时间作为参数，无具体意义 
var timenow = new Date().getTime(); 
//每次请求需要一个不同的参数，否则可能会返回同样的验证码 
//这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。 
obj.src="rand.action?d="+timenow; 
} 

</script>
<body>
	<div class="container">
		<div class="row">
			<nav class="navbar navbar-default navbar-static-top"
				role="navigation">
				<div class="container container-fluid ">
					<div class="navbar-header">
						<a class="navbar-brand" href="index.jsp"> 启动--- 永不止步! </a>
					</div>

					<div class="row ">
						<div class="col-xs-3"></div>

						<div class="col-xs-9 navbar-right">
							<div class="row ">
								<form class="form-inline col-xs-offset-5" role="form"
									action="login" method="post" onsubmit="return test(this);">

									<div class="form-group ">
										<label for="inputname" class="control-label sr-only">用户名</label>
										<div class="">
											<input type="text" id="inputname"
												class="form-control alert-danger input-sm "
												placeholder="用户名" required autofocus name="username"
												title="请输入用户名" />
										</div>
									</div>

									<div class="form-group ">
										<label for="inputpass" class="control-label sr-only">密码</label>
										<div class="">
											<input type="password" id="inputpass"
												class="form-control alert-danger input-sm" placeholder="密码"
												required name="password" title="请输入密码" />
										</div>
									</div>

									<div class="form-group ">
										<div class="checkbox">
											<label> <input type="checkbox" value="remember-me"
												name="remember" /> 记住我
											</label>
										</div>
									</div>

									<div class="form-group ">
										<input type="text" id="authcode" name="authcode" MaxLength="6"
											tabindex="6" placeholder="验证码或者答案" required
											title="请输入验证码或者验证码问题的答案"
											class="form-control alert-danger input-sm" /> <img
											id="JD_Verification1" src="rand.action"
											onclick="changeValidateCode(this)" title="点击图片刷新验证码"
											height="30px" />
										<!-- style="cursor: pointer; height: 30px;" -->
										<!-- 这个加超链接只是为在新窗口打开中显示登陆窗口 -->
										<a href="login"><button class="btn  btn-primary btn-sm "
												type="submit" id="login">登陆</button></a> 
												<a href="reg"><button id="reg"
												class="btn  btn-success btn-sm " type="button" onclick="location.href='reg'">注册</button></a>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</nav>
		</div>
	</div>