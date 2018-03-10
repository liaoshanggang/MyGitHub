<%@page import="com.forward.po.trade.BankCard"%>
<%@page import="com.forward.service.ATMServer"%>
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
String cardNo = request.getParameter("cardNo");
int pwd = Integer.parseInt(request.getParameter("pwd"));
ATMServer server = new ATMServer();
BankCard actCardInfo = server.login(cardNo, pwd);
BankCard excCardInfo = new BankCard(cardNo, pwd);
out.print("数据库里面的："+actCardInfo+"<br>");
out.print("用户输入的："+excCardInfo+"<br>");
%>
<%
if(excCardInfo.equals(actCardInfo)){
%><%="恭喜您登录成功！正在跳转到..." %>
<%
session.setAttribute("actCardInfo",actCardInfo);
request.getRequestDispatcher("index.jsp").forward(request, response);
}else{%>
<%="登录失败！" %>
<%
}%>
</body>
</html>