<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="panel panel-info">
				<div class="panel-heading">
					<a href="#" class="">论坛 <span
						class="glyphicon glyphicon-minus-sign "></span>
					</a>
				</div>

				<div class="panel-body">
					<div class="text-danger">宁愿跑起来被绊倒无数次，不要规规矩矩走一辈子。</div>
				</div>

				<table class="table table-bordered table-condensed">

					<tbody>
                         
						<s:iterator value="bolist" var="board" status="st">

							<tr
								class="<s:if test="#st.odd">info</s:if><s:else>warning</s:else>">
								<!-- target="_blank"属性必须放在href前面 -->
								<td><a target="_blank"
									href="tpartaction?bid=<s:property value="#board.id"   />"><s:property
											value="name" /></a></td>
								<!-- 统计每个版区有多少个帖子 -->
								<td width="10%" align="center">
									<div class="row">
										帖子总数<span class="badge"><s:property
												value="stopic.size" /> </span>
									</div>

								</td>
								<!-- 特别注意此处不能直接写userid,数据库表中的userid
				是Hibernate生成的外键应该看Topic类中的属性
				 -->
							</tr>
						</s:iterator>

					</tbody>
				</table>

				<div class="panel-footer">关注启动</div>
			</div>






		</div>
	</div>

</body>
</html>