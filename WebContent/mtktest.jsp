<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎光临!</title>
<script src="./jquery/jquery-1.11.2.js"></script>
<!-- 注意JS加载顺序 -->
<script src="./bootstrap/js/bootstrap.js"></script>
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap-theme.css" rel="stylesheet">

</head>
<body>
	<div class="container">
		<div class="row">
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target=".bs-example-modal-lg">Large modal</button>

			<div class="modal fade bs-example-modal-lg" tabindex="-1"
				role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<form class="form-signin" role="form" action="login" method="post">
							<h2 class="form-signin-heading">请登录</h2>



							<input type="text" id="inputname" class="form-control"
								placeholder="用户名" required autofocus name="username" /> <input
								type="password" id="inputpass" class="form-control"
								placeholder="密码" required name="password" />


							<div class="checkbox">
								<label> <input type="checkbox" value="remember-me" />
									记住我
								</label>
							</div>

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
			</div>

			<!-- Small modal -->
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target=".bs-example-modal-sm">Small modal</button>

			<div class="modal fade bs-example-modal-sm" tabindex="-1"
				role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
						<form class="form-signin" role="form" action="login" method="post">
							<h2 class="form-signin-heading">请登录</h2>



							<input type="text" id="inputname" class="form-control"
								placeholder="用户名" required autofocus name="username" /> <input
								type="password" id="inputpass" class="form-control"
								placeholder="密码" required name="password" />


							<div class="checkbox">
								<label> <input type="checkbox" value="remember-me" />
									记住我
								</label>
							</div>

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
			</div>
		</div>
	</div>
</body>
</html>