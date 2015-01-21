<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:property value="#session.t.title" /> --By cjava.cn</title>
<script src="../jquery/jquery-1.11.2.js"></script>
<!-- 注意JS加载顺序 -->
<script src="../ckeditor/ckeditor.js"></script>
<script src="../bootstrap/js/bootstrap.js"></script>
<link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="../bootstrap/css/bootstrap-theme.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row ">

			<button class="btn btn-success" type="button">回复</button>
		</div>

		<div class="row">
			<div class="panel panel-info dropdown">
				<!-- Default panel contents -->
				<div class="panel-heading">
					<button class="btn btn-default">待定</button>
					<span class="pull-right">回复/查看</span> <span class="pull-right">&nbsp;&nbsp;&nbsp;&nbsp;作者&nbsp;&nbsp;</span>
					<span class="pull-right"><input type="checkbox" />新窗</span>
				</div>

				<div class="panel-body">

					<table class="table">
						<tbody>
							<tr>
								<td width="15%" rowspan="1"><div class="row">
										查看:
										<s:property value="#session.t.c.size" />
										| 回复:
										<s:property value="#session.t.view" />
									</div></td>
								<th><s:property value="#session.t.title" /></th>
							</tr>
							<tr>
								<td rowspan="2"><div class="row">
										<s:property value="#session.t.u.name" />
									</div>
									<div class="row">
										<img alt="" src="./bbs/images/member.gif">
									</div>
									<div class="row">
										<table class="table">
											<tbody>
												<tr>
													<td>主题</td>
													<td>帖子</td>
													<td>积分</td>
												</tr>
												<tr>
													<td><s:property value="#session.t.c.size" /></td>
													<td><s:property value="#session.t.u.stop.size" /></td>
													<td><s:property value="#session.t.u.point" /></td>
												</tr>
											</tbody>
										</table>
									</div>
									<div class="row">新手上路</div></td>
								<td>发表于<s:property value="#session.t.date" /></td>
							</tr>
							<tr>

								<td><code>
										<s:property value="#session.t.content" />
									</code></td>
							</tr>

							<tr>
								<td class=""><div class="row">待定(可删除)</div></td>
								<td><button class="btn btn-default">
										<span class="glyphicon glyphicon-share">回复</span>
									</button></td>
							</tr>
						</tbody>
					</table>

					<!-- 迭代循环输出该帖子的所有评论 -->
					<s:iterator value="#session.t.c" var="comment" status="st">

						<table class="table">
							<tbody>
								<tr>
									<td width="15%" rowspan="1">
										<div class="row">

											<s:property value="#comment.user.name" />
										</div>
									</td>
									<td rowspan="1">发表于<s:property value="#comment.date" />
									</td>
								</tr>

								<tr>
									<td rowspan="1"><div class="row">
											<img alt="" src="./bbs/images/member.gif">
										</div>
										<div class="row">
											<table class="table">
												<tbody>
													<tr>
														<td>主题</td>
														<td>帖子</td>
														<td>积分</td>
													</tr>
													<tr>
														<td><s:property value="#comment.user.scomm.size" /></td>
														<td><s:property value="#comment.user.stop.size" /></td>
														<td><s:property value="#comment.user.point" /></td>
													</tr>
												</tbody>
											</table>

										</div>
										<div class="row">新手上路</div></td>
									<td><s:property value="#comment.content" /></td>
								</tr>

								<tr>
									<td><div class="row">待定(可删除)</div></td>
									<td><button class="btn btn-default">
											<span class="glyphicon glyphicon-share">回复</span>
										</button></td>
								</tr>
							</tbody>
						</table>
					</s:iterator>

				</div>
			</div>
		</div>

		<div class="row">
			<div class="panel panel-default">
				<!-- Default panel contents -->
				<div class="panel-heading">快速回复</div>

				<div class="panel-body">


					<!-- 登陆模态框 -->
					<%
						// out.println("用户登录状态=="+session.getAttribute("userstate"));
					%>
					<s:if test="!#session.userstate">
						<!-- 判断用户是否登陆,注意前面感叹号是非的意思(有问题待定) -->
						<div align="center">

							<jsp:include page="./mloginandreg.jsp"></jsp:include>
							<!-- 登陆模态框 -->

						</div>
					</s:if>


					<form action="sample_posteddata.jsp" method="post">
						<center>
							<!--<s:div class="h4">你需要登录才可以发帖<s:a href="1"> 登陆</s:a>|<s:a href="2">立即注册</s:a></s:div>-->
						</center>
						<p>
							<label for="editor1">回复:</label>
							<textarea cols="80" id="editor1" name="editor1" rows="10">
				</textarea>

						</p>
						<p>
							<input type="submit" value="回复帖子" class="btn btn-primary"
								disabled />
						</p>
					</form>
				</div>


			</div>
		</div>



	</div>
	<ckeditor:replace replace="editor1" basePath="/ckeditor/" />
</body>
</html>