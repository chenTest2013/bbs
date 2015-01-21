<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>

<!-- 注意JS加载顺序 -->
<script src="../ckeditor/ckeditor.js"></script>



<!-- Custom styles for this template -->
<link href="../bootstrap/css/my/signin.css" rel="stylesheet">

</head>
<body>
	<div class="container">
		<div class="row dropdown">

			<button class="btn btn-success dropdown-toggle" type="button"
				id="dropdownMenu1" data-toggle="dropdown" data-target="11">
				发帖<span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
				<li role="presentation"><a role="menuitem" tabindex="-1"
					href="2">发帖</a></li>
				<li role="presentation"><a role="menuitem" tabindex="-1"
					href="3">发起投票</a></li>
			</ul>
		</div>

		<div class="row">
			<div class="panel panel-info dropdown">
				<!-- Default panel contents -->
				<div class="panel-heading">
					<button class="btn btn-default">待定</button>

					<span class="pull-right">回复/查看</span> <span class="pull-right">&nbsp;&nbsp;&nbsp;&nbsp;作者&nbsp;&nbsp;</span>
					<span class="pull-right"><input type="checkbox" />新窗</span>

				</div>

				<!--  <div class="panel-body">
				<p>it just a test</p>
			</div>-->

				<!-- List group -->
				<ul class="list-group">
					<s:iterator value="#session.blist" var="topic" status="st">
						<li class="list-group-item"><a
							href="singletopic?tid=<s:property value="#topic.id" />"> <span
								class="glyphicon glyphicon-folder-close"></span> <s:property
									value="#topic.title" />
						</a> <span class="pull-right">
								<div>
									&nbsp;&nbsp;
									<s:property value="#topic.c.size" />
								</div>
								<div>
									&nbsp;&nbsp;
									<s:property value="#topic.view" />
								</div>
						</span> <span class="pull-right">
								<div>
									<s:property value="#topic.u.name" />
									&nbsp;&nbsp;
								</div>
								<div>
									<s:property value="#topic.date" />
									&nbsp;&nbsp;
								</div>
						</span>
							<div class="" align="right">.</div></li>
					</s:iterator>

				</ul>
				<button class="btn btn-success dropdown-toggle" type="button"
					id="dropdownMenu2" data-toggle="dropdown" data-target="11">
					发帖<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
					<li role="presentation"><a role="menuitem" tabindex="-1"
						href="2">发帖</a></li>
					<li role="presentation"><a role="menuitem" tabindex="-1"
						href="3">发起投票</a></li>
				</ul>
			</div>

		</div>

		<div class="row">
			<div class="panel panel-default">



				<!-- Default panel contents -->
				<div class="panel-heading">快速发帖</div>
				<div class="panel-body">

					<!-- 登陆模态框 -->
					<%// out.println("用户登录状态=="+session.getAttribute("userstate")); %>
					<s:if test="!#session.userstate">
						<!-- 判断用户是否登陆,注意前面感叹号是非的意思(有问题待定) -->
						<div align="center">

							<jsp:include page="./mloginandreg.jsp"></jsp:include>
							<!-- 登陆模态框 -->

						</div>
					</s:if>

				</div>


				<form action="sample_posteddata.jsp" method="post">
					<input type="text" name="title" /> 还可输入80字符 <label for="editor1">回复:</label>
					<p>
						<textarea cols="80" id="editor1" name="editor1" rows="10"></textarea>
					</p>
					<p>
						<input type="submit" value="发布" class="btn btn-primary" id="sub"
							disabled />
					</p>
				</form>
			</div>


		</div>
	</div>




	<ckeditor:replace replace="editor1" basePath="/ckeditor/" />

	<script type="text/javascript">
$(document).ready(function(){
	 //此处得到的是字符串,注意
	 var state="<%=session.getAttribute("userstate")%>";
	 
	 $('#login').click(function(){//待定
		 alert("sub属性1prop=="+$("#sub").prop("disabled"));
		 $("#sub").prop("disabled",false);
		 alert("sub属性2prop=="+$("#sub").prop("disabled"));
	 });
	 
	   
	if(state=='false'){

		 $('#dropdownMenu1').bind("click",function(){
			 alert("用户登录状态=="+state);
			
		 });
	}else{
		 
		 $('#dropdownMenu2').click(function(){
			 alert("用户登录状态=="+state);
			
		 });
	}
		
	 
	
	
	
})

</script>