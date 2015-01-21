<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>为什么不行</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<script src="jquery/jquery-2.1.3.js"></script>
<!-- 注意jquery.js要在 bootstrap.js的前面-->
<script src="bootstrap/js/bootstrap.js"></script>

</head>
<body>
	<div class="container">

		<div class="alert alert-warning alert-dismissible" role="alert"
			id="myAlert">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
			</button>
			<strong>Warning!</strong> Better check yourself, you're not looking
			too good.
		</div>


		<div class="alert alert-warning alert-dismissible" role="alert"
			id="myAlert">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
			</button>
			<strong>Warning!</strong> Better check yourself, you're not looking
			too good.
		</div>

	</div>
	<script>
	$(document).ready(function(){
		$('#myAlert').on('closed.bs.alert', function() {
			$(this).alert('close')
		})
	});
	</script>
</body>
</html>