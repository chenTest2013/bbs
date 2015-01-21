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
	
	<s:debug></s:debug>
	<p>错误信息显示
			<s:property value="message" /><!--action中的属性message-->
			<s:actionerror/><!-- 显示错误信息 -->
			<s:actionmessage/><!-- 显示message -->
			<!-- ${bolist} -->
			 ${request.bolist}
			  ${request.random}
			<s:iterator value="bolist" var="board" status="st">
			<table>
			<tbody>
			<tr>
			<td><s:property value="#board.id" />
			</td><td><s:property value="name" /></td>
			<td><s:property value="#board.stopic.size" /> </td>
			</tr>
			</tbody>
			</table>
			
			</s:iterator>
			<!--  ${requestScope}-->
		</p>
</body>
</html>
