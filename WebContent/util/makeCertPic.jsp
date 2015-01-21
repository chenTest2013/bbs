<%@page contentType="image/jpeg"%><%@page language="java"
	pageEncoding="utf-8"%>
<jsp:useBean id="image" scope="page" class="chen.util.MakeCertPic" />
<%
	String str = image.getCertPic(0, 0, response.getOutputStream());
	//将验证码存入session中
	session.setAttribute("certCode", str);
%>