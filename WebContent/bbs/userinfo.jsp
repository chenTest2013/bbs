<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
<script src="../jquery/jquery-1.11.2.js"></script>
<!-- 注意JS加载顺序 -->
<script src="../bootstrap/js/bootstrap.js"></script>
<link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="../bootstrap/css/bootstrap-theme.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="panel panel-info">
				<div class="panel-heading">
					<ul id="myTab" class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#home"
							id="home-tab" role="tab" data-toggle="tab" aria-controls="home"
							aria-expanded="true">基本资料</a></li>
						<li role="presentation"><a href="#profile" role="tab"
							data-toggle="tab">用户组</a></li>
						<li role="presentation"><a href="#messages" role="tab"
							data-toggle="tab">Messages</a></li>
						<li role="presentation" class="dropdown"><a href="#"
							id="myTabDrop1" class="dropdown-toggle" data-toggle="dropdown">Dropdown
								<span class="caret"></span>
						</a>
							<ul class="dropdown-menu" role="menu"
								aria-labelledby="myTabDrop1" id="myTabDrop1-contents">
								<li class=""><a href="#dropdown1" tabindex="-1" role="tab"
									id="dropdown1-tab" data-toggle="tab" aria-controls="dropdown1"
									aria-expanded="false">@fat</a></li>
								<li class=""><a href="#dropdown2" tabindex="-1" role="tab"
									id="dropdown2-tab" data-toggle="tab" aria-controls="dropdown2"
									aria-expanded="false">@mdo</a></li>
							</ul></li>
					</ul>
				</div>

				<div class="panel-body">
					<div class="text-danger">隐居山水之间是云浮名散,湖畔青石板上一把油纸伞,旅人停步折花淋湿了绸缎.</div>
				</div>

				<div class="tab-content">
					<!-- class="tab-pane fade active in" in不能掉否则刚打开不显示 -->
					<div role="tabpanel" class="tab-pane fade active in" id="home"
						aria-labelledby="home-tab">
						<form action="" class="">
							<table class="table table-bordered table-condensed">
								<tbody>
									<tr>
										<td width="6%">用户名</td>
										<td><s:property value="#session.user.name" /></td>
									</tr>
									<tr>
										<td>性别</td>
										<td><s:property value="#session.user.sex" /></td>
									</tr>
									<tr>
										<td>Email</td>
										<td><s:property value="#session.user.email" /></td>
									</tr>
									<tr>
										<td>昵称</td>
										<td><s:property value="#session.user.info.name" /></td>
									</tr>
									<tr>
										<td>等级</td>
										<td><s:property value="#session.user.grade" /></td>
									</tr>
									<tr>
										<td>分数</td>
										<td><s:property value="#session.user.point" /></td>
										<!-- <td class="" width="5%"><s:property value="#session.user.id" /></td>
							<td><s:property value="#session.user.name" /></td>
							<td width="5%"><span class="badge">67</span></td> -->
									</tr>
									<tr>
										<td>角色</td>
										<td><s:property value="#session.user.role" /></td>
									</tr>
									<tr>
										<td>主题</td>
										<td><s:property value="#session.user.stop.size" /></td>
									</tr>

								</tbody>
							</table>
						</form>
					</div>
					<div role="tabpanel" class="tab-pane fade" id="profile">profile</div>
					<div role="tabpanel" class="tab-pane fade" id="messages">messages</div>

					<div role="tabpanel" class="tab-pane fade" id="dropdown1">dropdown1</div>
					<div role="tabpanel" class="tab-pane fade" id="dropdown2"
						aria-labelledby="dropdown2-tab">dropdown2</div>
				</div>





				<div class="panel-footer">关注启动</div>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
		
			$('#myTab a').click(function(e) {
				//alert(this);
				e.preventDefault();
				$(this).tab('show')
			});
		})
	</script>
</body>
</html>