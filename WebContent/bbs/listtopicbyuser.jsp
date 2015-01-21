<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<head>
<!-- 注意JS加载顺序 -->
<script src="../ckeditor/ckeditor.js"></script>


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

						<s:iterator value="#session.ulist" var="topic" status="st">

							<tr
								class="<s:if test="#st.odd">info</s:if><s:else>warning</s:else>">
								<!-- target="_blank"属性必须放在href前面 -->
								<td><a target="_blank"
									href="singletopic?tid=<s:property value="#topic.id"   />">
										<s:property value="#topic.title" />
								</a></td>

								<td width="10%" align="center">
									<div class="row">
										时间<span class="badge"><s:property value="#topic.date" />
										</span>
									</div>

								</td>

							</tr>
						</s:iterator>

					</tbody>
				</table>

				<div class="panel-footer">关注启动</div>
			</div>






		</div>
	</div>

</body>