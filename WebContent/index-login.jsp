<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/js/npm.js"></script>
<script src="jquery/jquery-1.11.2.js"></script>
<link href="data:text/css;charset=utf-8,"
	data-href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"
	id="bs-theme-stylesheet">
<!-- Custom styles for this template -->
<link href="bootstrap/css/my/signin.css" rel="stylesheet">




</head>
<body>
	<div class="container">
		<form class="form-inline" role="form">
			<div class="form-group">
				<label class="sr-only" for="exampleInputEmail2">Email
					address</label> <input type="email" class="form-control"
					id="exampleInputEmail2" placeholder="Enter email">
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">@</div>
					<input class="form-control" type="email" placeholder="Enter email">
				</div>
			</div>
			<div class="form-group">
				<label class="sr-only" for="exampleInputPassword2">Password</label>
				<input type="password" class="form-control"
					id="exampleInputPassword2" placeholder="Password">
			</div>
			<div class="checkbox">
				<label> <input type="checkbox"> Remember me
				</label>
			</div>
			<button type="submit" class="btn btn-default">Sign in</button>
		</form>

		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<p class="form-control-static">email@example.com</p>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="inputPassword"
						placeholder="Password">
				</div>
			</div>
		</form>


		<form class="form-horizontal" role="form">
			<div class="form-group has-success has-feedback">
				<label class="control-label col-sm-3" for="inputSuccess3">Input
					with success</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="inputSuccess3">
					<span class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div>
			</div>
		</form>



		<form class="form-inline" role="form">
			<div class="form-group has-success has-feedback">
				<label class="control-label" for="inputSuccess4">Input with
					success</label> <input type="text" class="form-control" id="inputSuccess4">
				<span class="glyphicon glyphicon-ok form-control-feedback"></span>
			</div>
		</form>


		<form class="form-horizontal" role="form">
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label" for="formGroupInputLarge">Large
					label</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="formGroupInputLarge"
						placeholder="Large input">
				</div>
			</div>
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="formGroupInputSmall">Small
					label</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="formGroupInputSmall"
						placeholder="Small input">
				</div>
			</div>
		</form>


		<div class="row">
			<div class="col-xs-2">
				<input type="text" class="form-control" placeholder=".col-xs-2">
			</div>
			<div class="col-xs-3">
				<input type="text" class="form-control" placeholder=".col-xs-3">
			</div>
			<div class="col-xs-4">
				<input type="text" class="form-control" placeholder=".col-xs-4">
			</div>
		</div>

		<!-- Standard button -->
		<button type="button" class="btn btn-default">Default</button>

		<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
		<button type="button" class="btn btn-primary">Primary</button>

		<!-- Indicates a successful or positive action -->
		<button type="button" class="btn btn-success">Success</button>

		<!-- Contextual button for informational alert messages -->
		<button type="button" class="btn btn-info btn-lg">Info</button>

		<!-- Indicates caution should be taken with this action -->
		<button type="button" class="btn btn-warning active">
			<abbr title="此按钮已激活">Warning</abbr>
		</button>

		<!-- Indicates a dangerous or potentially negative action -->
		<button type="button" class="btn btn-danger">Danger</button>

		<!-- Deemphasize a button by making it look like a link while maintaining button behavior -->
		<button type="button" class="btn btn-link">Link</button>

		<p class="text-muted">text-muted</p>
		<p class="text-primary">text-primary</p>
		<p class="text-success">text-success</p>
		<p class="text-info">text-info</p>
		<p class="text-warning">text-warning</p>
		<p class="text-danger">text-danger</p>

		<p class="bg-primary">bg-primary</p>
		<p class="bg-success">bg-success</p>
		<p class="bg-info">bg-info</p>
		<p class="bg-warning">bg-warning</p>
		<p class="bg-danger">bg-danger</p>


		<div class="btn-group">
			<button type="button" class="btn btn-default">Left</button>
			<button type="button" class="btn btn-default">Middle</button>
			<button type="button" class="btn btn-default">Right</button>
		</div>

		<div class="btn-toolbar" role="toolbar">

			<div class="btn-group btn-group-lg">
				<button type="button" class="btn btn-default btn-primary">1</button>

				<button type="button" class="btn btn-default">2</button>
			</div>
			<div class="btn-group">
				<button type="button" class="btn btn-default">Left</button>
				<button type="button" class="btn btn-default btn-lg btn-success">Middle</button>
				<button type="button" class="btn btn-default">Right</button>
			</div>
			<div class="btn-group">
				<button type="button" class="btn btn-defaul btn-primary">3</button>
				<button type="button" class="btn btn-default">4</button>
				<button type="button" class="btn btn-default btn-lg">5</button>
			</div>
		</div>


		<div class="btn-group">
			<button type="button" class="btn btn-default">1</button>
			<button type="button" class="btn btn-default">2</button>

			<div class="btn-group">
				<button type="button" class="btn btn-default dropdown-toggle"
					data-toggle="dropdown">
					Dropdown <span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li><a href="#">Dropdown link</a></li>
					<li><a href="#">Dropdown link</a></li>
				</ul>
			</div>
		</div>




	</div>
</body>
</html>