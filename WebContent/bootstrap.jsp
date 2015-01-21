<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="./jquery/jquery-2.1.3.js"></script>
<!-- 注意JS加载顺序 -->
<script src="./bootstrap/js/bootstrap.js"></script>
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap-theme.css" rel="stylesheet">
</head>
<body>
	<div class="container">

		<div class="row ">
			<div class="col-md-8 col-xs-8">8</div>
			<div class="col-md-4 col-xs-4">4</div>
			<div class="row">
				<div class="col-md-8 col-xs-8">
					<button class="btn btn-primary col-md-offset-3     ">打开1</button>
				</div>
				<div class="col-md-4 col-xs-4">
					<button class="btn btn-primary col-md-offset-2  ">关闭1</button>
				</div>
			</div>
			<div class="row">
				<div class="col-md-8 col-xs-8">

					<div class="col-md-6 col-xs-6 ">
						<div class="col-md-6 ">
							<button class="btn btn-primary btn-block">嵌套3-1</button>
						</div>
						<div class="col-md-6 ">
							<button class="btn btn-primary btn-block">嵌套3-2</button>
						</div>
					</div>

					<div class="col-md-6 col-xs-2">
						<button class="btn btn-primary btn-block">嵌套4</button>
					</div>


				</div>
				<div class="col-md-4 col-xs-4">
					<button class="btn btn-primary  btn-block">关闭2</button>
				</div>
			</div>
		</div>


	</div>
</body>
</html>