<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script src="./jquery/jquery-1.11.2.js"></script>
<!-- 注意JS加载顺序 -->
<script src="./bootstrap/js/bootstrap.js"></script>
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap-theme.css" rel="stylesheet">

</head>
<body>
	<div class="container">

		<div class="row">
			<table class="table table-bordered">
				<tbody>
					<tr>
						<td width="15%" rowspan="1">查看:12<s:property value="" /> |
							回复:10
						</td>
						<th>标题</th>
					</tr>
					<tr>
						<td rowspan="2">用户名 <img alt=""
							src="./bbs/images/member.gif">
							<div class="row">
								<table class="table">
									<tbody>
										<tr>
											<td><h5>
													<small>主题</small>
												</h5></td>
											<td><h5>
													<small>帖子</small>
												</h5></td>
											<td><h5>
													<small>积分</small>
												</h5></td>
										</tr>
										<tr>
											<td>341</td>
											<td>178</td>
											<td>100067</td>
										</tr>
									</tbody>
								</table>

							</div> 新手上路
						</td>
						<td>53</td>
					</tr>
					<tr>

						<td>帖子内容</td>
					</tr>

					<tr>
						<td>待定(可删除)</td>
						<td>回复</td>
					</tr>
				</tbody>
			</table>


		</div>
	</div>
</body>
</body>
</html>