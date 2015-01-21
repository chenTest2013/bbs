<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="./jquery/jquery-2.1.3.js"></script>
<!-- 注意JS加载顺序 -->
<script src="./ckeditor/ckeditor.js"></script>
<script src="./bootstrap/js/bootstrap.js"></script>
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap-theme.css" rel="stylesheet">
<link href="data:text/css;charset=utf-8,"
	data-href="./bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"
	id="bs-theme-stylesheet">
<!-- Custom styles for this template -->
<link href="./bootstrap/css/my/signin.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		你需要登录才可以发帖
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#myModal">登陆</button>
		<s:a href="2">
			<button class="btn btn-default" id="reg">立即注册</button>
		</s:a>
		<!-- Modal模态登陆对话框 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">登陆对话框</h4>
					</div>
					<div class="modal-body">

						<form class="form-signin" role="form" action="login">
							<h2 class="form-signin-heading">请登录</h2>



							<input type="text" id="inputname" class="form-control"
								placeholder="user name" required autofocus name="username" /> <input
								type="password" id="inputpass" class="form-control"
								placeholder="Password" required name="password" />


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
					<div class="modal-footer">
						<!--   <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>-->
					</div>
				</div>
			</div>
		</div>


	</div>


</body>
</html>