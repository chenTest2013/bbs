<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
<!-- Bootstrap core CSS -->
<script src="./jquery/jquery-1.11.2.js"></script>
<!-- 注意JS加载顺序 -->
<script src="./bootstrap/js/bootstrap.js"></script>
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap-theme.css" rel="stylesheet">

<link href="data:text/css;charset=utf-8,"
	data-href="./bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"
	id="bs-theme-stylesheet">
<!-- Custom styles for this template -->
<link href="./bootstrap/css/my/signin.css" rel="stylesheet">



</head>
<body>
	<div class="container">
		<div>
			<form class="form-signin" role="form" action="login">
				<h2 class="form-signin-heading">请登录</h2>



				<input type="text" id="inputname" class="form-control"
					placeholder="user name" required autofocus name="username" /> <input
					type="password" id="inputpass" class="form-control"
					placeholder="Password" required name="password" />


				<div class="checkbox">
					<label> <input type="checkbox" value="remember-me" /> 记住我
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

		<button type="button" class="btn btn-default btn-lg">
			<span class="glyphicon glyphicon-star"></span> Star
		</button>

		<div class="alert alert-success text-center" role="alert">
			<a href="#" class="alert-link">这是</a>
			<del>一个成功</del>
			警告框
		</div>

		<div class="alert alert-warning alert-dismissible" role="alert"
			id="myAlert">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
			</button>
			<strong>Warning!</strong> Better check yourself, you're not looking
			too good.
		</div>
		<div>
			<s>This line of text is meant to be treated as no longer
				accurate.</s>
		</div>
		<div>
			This line of text is meant to be treated as an addition to the <abbr
				title="document">doc</abbr>.
		</div>
		<div>
			<u>This line of text will render as underlined</u>
		</div>
		<address>
			<strong>Twitter, Inc.</strong><br> 795 Folsom Ave, Suite 600<br>
			San Francisco, CA 94107<br> <abbr title="Phone">P:</abbr> (123)
			456-7890
		</address>

		<div class="row">
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-4">
				.col-
				<mark>md</mark>
				-4
			</div>
		</div>


		<table class="table table-bordered table-hover table-condensed">
			<tbody>
				<tr class="active">
					<th>144</th>
					<td>2</td>
					<td>3</td>
					<td>4</td>
				</tr>
				<tr class="success">
					<td>111</td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
				</tr>
				<tr class="info">
					<td>134</td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
				</tr>
				<tr class="warning">
					<td>167</td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
				</tr>
			</tbody>
		</table>

	</div>
	<!-- /container -->



	<script>
	$(document).ready(function(){
		$("#myAlert").on('closed.bs.alert', function() {
			$(this).alert('close')
		})
	});
	</script>
</body>
</html>