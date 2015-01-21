<!-- 单独运行这个页面,下拉菜单弹不出的分析 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>顶部</title>
<script src="./jquery/jquery-1.11.2.js"></script>
<!-- 注意JS加载顺序 -->
<script src="./bootstrap/js/bootstrap.js"></script>
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap-theme.css" rel="stylesheet">

</head>
<body>
	<div class="container">
		<div class="row">
			<nav class="navbar navbar-default navbar-static-top"
				role="navigation">
			<div class="container container-fluid ">
				<div class="navbar-header">
					<a class="navbar-brand" href="@"> 永不止步! </a>
				</div>

				<div class="row ">
					<div class="col-xs-3"></div>

					<div class="col-xs-9 navbar-right">
						<div class="row ">
							<form class="form-inline col-xs-offset-3" role="form"
								action="login" method="post">

								<div class="form-group ">
									<label for="inputname" class="control-label sr-only">用户名</label>
									<div class="">
										<input type="text" id="inputname"
											class="form-control alert-info input-sm " placeholder="用户名"
											required autofocus name="username" />
									</div>
								</div>

								<div class="form-group ">
									<label for="inputpass" class="control-label sr-only">密码</label>
									<div class="">
										<input type="password" id="inputpass"
											class="form-control alert-info input-sm" placeholder="密码"
											required name="password" />
									</div>
								</div>

								<div class="form-group ">
									<div class="checkbox">
										<label> <input type="checkbox" value="remember-me" />
											记住我
										</label>
									</div>


									<button class="btn btn-lg btn-primary btn-sm " type="submit">登陆</button>
									<a href="reg"><button
											class="btn btn-lg btn-success btn-sm " type="button">注册</button></a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			</nav>
		</div>
	</div>
</body>
</html>