<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="./jquery/jquery-2.1.3.js"></script>
<!-- 注意JS加载顺序 -->
<script src="./ckeditor/ckeditor.js"></script>
<script src="./bootstrap/js/bootstrap.js"></script>
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap-theme.css" rel="stylesheet">
<script type="text/javascript">
	$(document).ready(function() {
		$("#hide").click(function() {
			alert("hsclass");
			alert("state");
	    	 
			$(this).hide();
		});
	});
</script>

<script type="text/javascript">
$(function(){
	//次js用于控制回复区域的状态
	$(document).ready(function() {
		  $('#login').click(function(){
			  var state="<%=session.getAttribute("userstate")%>";
	    	  var hsclass=$("#editor1").hasClass("disabled");
	    	  alert("hsclass=="+hsclass);
			  alert("state=="+state);
		    
			  alert("editor1属性1prop=="+$("#editor1").prop("disabled"));
			   $("#editor1").prop("disabled",true);
			   $("textarea:enabled")
			   alert("editor1属性2prop=="+$("#editor1").prop("disabled"));
	    	//if(state && hsclass){
	    		//alert("hsclass");
				//alert("state");
	    		//$("#editor1").removeClass('disabled');
	    	//}
	    	})
	})
})
</script>
<script type="text/javascript">
$(document).ready(function(){
	 $('#login').click(function(){
		 var h= $(this).hasClass("btn");
		 alert("btn  "+h);
	 });
	
	 $('#login').click(function(){
		 //var h= $(this).hasClass("btn");
		 alert("sub属性1prop=="+$("#sub").prop("disabled"));
		 $("#sub").prop("disabled",false);
		 alert("sub属性2prop=="+$("#sub").prop("disabled"));
	 });
	
})

</script>
</head>

<body>
	<div class="container">
		<button type="button" id="hide">Click me</button>
		<s:div class="h4">你需要登录才可以发帖<button class="btn btn-default"
				id="login">登陆</button> |
 <s:a href="2">立即注册</s:a>
		</s:div>

		<div class="row">
			<div class="panel panel-default">
				<!-- Default panel contents -->
				<div class="panel-heading">快速回复</div>

				<div class="panel-body">


					<form action="sample_posteddata.jsp" method="post">

						<p>
							<label for="editor1">回复:</label>
							<textarea cols="80" id="editor1" name="editor1" rows="10"
								disabled>
				</textarea>

						</p>
						<p>
							<input type="submit" value="回复帖子" class="btn btn-primary"
								id="sub" disabled />
						</p>
					</form>
				</div>


			</div>
		</div>
	</div>
	<ckeditor:replace replace="editor1" basePath="/ckeditor/" />
</body>
</html>
