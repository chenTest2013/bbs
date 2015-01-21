<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="./jquery/jquery-1.11.2.js"></script>
<!-- 注意JS加载顺序 -->
<script src="./bootstrap/js/bootstrap.js"></script>
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap-theme.css" rel="stylesheet">

</head>
<body>
	<div class="container">
		<div class="row ">
			<div class="col-xs-4">
				<img alt="启动论坛" src="./my/images/mylogos.png">
			</div>

			<div class="col-xs-8">
				<div class="row">
					<form class="form-inline col-xs-offset-3" role="form"
						action="login">

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
							<button class="btn btn-lg btn-success btn-sm " type="submit">注册</button>
						</div>
					</form>
				</div>
			</div>
		</div>

		<div class="row"></div>



	</div>
</body>
</html>