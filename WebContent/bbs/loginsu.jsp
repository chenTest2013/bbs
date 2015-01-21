<!-- 单独运行这个页面,下拉菜单弹不出的分析 -->

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<body>
	<div class="container">
		<div class="row">
			<nav class="navbar navbar-default navbar-static-top"
				role="navigation">
				<div class="container container-fluid ">
					<div class="navbar-header">
						<a class="navbar-brand" href="index.jsp"> 永不止步! </a>
					</div>


					<div class="col-xs-10">
						<div class="row">
							<ul class="nav nav-pills navbar-right" role="tablist">

								<li role="presentation"><a href="#"><s:property
											value="#session.user.name" /> </a></li>
								<li role="presentation" class="dropdown"><a
									class="dropdown-toggle" data-toggle="dropdown" href=""
									id="myDropdown"> 我的 <span class="caret"></span></a>
									<ul class="dropdown-menu" role="menu"
										aria-labelledby="myDropdown">
										<li><a href="listtopic"><button
													class="btn btn-info btn-block">帖子</button></a></li>
										<li class="divider"></li>
										<li><a href="">收藏</a></li>

									</ul></li>

								<li role="presentation"><a href="profile" target="_blank">设置</a></li>
								<li role="presentation"><a href="loginout">退出</a></li>



							</ul>
						</div>
						<div class="row">
							<ul class="nav nav-pills navbar-right" role="tablist">
								<li role="presentation">积分:<s:property
										value="#session.user.point" />
								</li>
								<li role="presentation">用户组:<s:property
										value="#session.role.name" /></li>
								<!-- 这个地方需要改 -->
							</ul>

						</div>

					</div>
				</div>
			</nav>
		</div>
	</div>