<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page errorPage="error.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%@include file="head.jsp" %>
	<%
		String str = "hello";
		out.write(str);
		/* out.print(1/0); */
	%>
	<hr>
	<h3><a href="register.jsp">新会员注册</a></h3>
	<hr>
	<h3><a href="netBookReg.jsp">网上书城注册</a></h3>
	<hr>
	<h3><a href="login.jsp">重定向和请求转发</a></h3>
	<hr>
	<h3><a href="phoneLogin.jsp">手机充值</a></h3>
</body>
</html>