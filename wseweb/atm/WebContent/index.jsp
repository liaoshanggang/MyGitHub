<%@page import="com.forward.po.trade.BankCard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
BankCard bankCard = (BankCard) session.getAttribute("actCardInfo");
if (bankCard!=null) {
	%>
	<h1>welcome account <%=bankCard.getCardNo()%>
	 to use ATM SITE!</h1>
	<hr>
	<%
}else{
%> 
<a href="atmLogin.jsp">你好，请登录</a>
<a href="atmRegister.jsp">免费注册</a>
<%
}%>
</body>
</html>