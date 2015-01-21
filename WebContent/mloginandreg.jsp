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
		<div class="row">
			你需要登录才可以发帖
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#myModal">登陆</button>

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

							<form class="form-signin" role="form" action="login"
								method="post">
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
						<div class="modal-footer">
							<!--   <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>-->
						</div>



					</div>
				</div>
			</div>
			<!-- 登陆模态框 -->
			<button class="btn btn-success" id="reg" data-toggle="modal"
				data-target="#myreg">立即注册</button>

			<div class="modal fade" id="myreg">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title">注册对话框</h4>
						</div>
						<div class="modal-body">


							<div class="row">
								<div class="col-sm-1"></div>
								<div class="col-sm-10 col-sm-offset-1">

									<form class="form-horizontal" role="form" action="userreg"
										method="post">


										<div class="form-group">
											<label for="username" class="col-sm-3 control-label">用户名</label>
											<div class="col-sm-5">
												<input type="text" class="form-control" id="username"
													placeholder="用户名" name="username" autofocus>
											</div>
										</div>

										<div class="form-group">
											<label for="inputEmail" class="col-sm-3 control-label">电子邮件</label>
											<div class="col-sm-5">
												<input type="email" class="form-control" id="inputEmail"
													placeholder="电子邮件" name="email">
											</div>
										</div>

										<div class="form-group">
											<label for="inputPassword" class="col-sm-3 control-label">密码</label>
											<div class="col-sm-5">
												<input type="password" class="form-control"
													id="inputPassword" placeholder="密码" name="pwd">
											</div>
										</div>

										<div class="form-group">
											<label for="inputPassword2" class="col-sm-3 control-label">确认密码</label>
											<div class="col-sm-5">
												<input type="password" class="form-control"
													id="inputPassword2" placeholder="确认密码">
											</div>
										</div>



										<div class="form-group">
											<div class="col-sm-offset-3 col-sm-9">
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
											<label for="authcode" class="col-sm-3 control-label">验证码</label>
											<div class="col-sm-5">
												<input type="text" id="authcode" name="authcode"
													MaxLength="6" tabindex="6" placeholder="验证码或者问题答案" /> <img
													id="JD_Verification1" src="rand.action"
													onclick="changeValidateCode(this)" title="点击图片刷新验证码"
													style="cursor: pointer; height: 30px;" />
											</div>
										</div>

										<div class="form-group">
											<div class="col-sm-offset-2  col-sm-10 btn-group">
												<div class="btn-group col-sm-3">
													<button type="submit"
														class="btn  btn-primary btn-lg btn-block">注册</button>
												</div>

												<div class="btn-group col-sm-3">
													<button type="reset"
														class="btn  btn-success btn-lg btn-block">重填</button>
												</div>

											</div>



										</div>

									</form>
								</div>

							</div>



						</div>
						<div class="modal-footer">
							<!--   <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>-->
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
		</div>
	</div>

</body>
</html>