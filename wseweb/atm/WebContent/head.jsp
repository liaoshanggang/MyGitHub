<%@page import="com.forward.po.trade.BankCard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<script src="js/jquery-3.2.1.min.js"></script>
<style>
.global-top-right li{
list-style: none;
float: left;
height: 50px;
padding: 0px 30px 10px 30px;
}
</style>

</head>
<body>
	<%
		BankCard bankCard = (BankCard) session.getAttribute("actCardInfo");
		if (bankCard != null) {
	%>
	<ul class="global-top-right">
		<li>您好，<%=bankCard.getCardNo()%></li>
		<li><a href="privateServer.jsp">进入我的个人服务</a></li>
		<li><a href="atmLogin.jsp">退出</a></li>
	</ul>
	<%
		} else {
	%>
	<a href="atmLogin.jsp">你好，请登录</a>
	<a href="atmRegister.jsp">免费注册</a>
	<%
		}
	%>
</body>
</html>