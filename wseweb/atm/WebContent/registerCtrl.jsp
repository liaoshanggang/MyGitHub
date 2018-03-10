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
String accountNo = request.getParameter("accountNo");// 账号//18位
int password = Integer.parseInt(request.getParameter("password"));// 密码//6位
//String cardType = request.getParameter("cardType");// 卡类型
String cardType = request.getParameter("cardType");
double balance = Double.parseDouble(request.getParameter("balance")) ;// 卡金额
ATMServer server = new ATMServer();
BankCard realCardInfo = server.register(accountNo, password, cardType, balance);
BankCard excCardInfo = new BankCard(accountNo, password, cardType, balance);
out.println("数据库里面的："+realCardInfo+"<br>");
out.print("用户输入的："+cardType+""+excCardInfo);
%>
<%
if(excCardInfo.equals(realCardInfo)){
%>恭喜您注册成功！<% 

}else{%>
注册失败！<%}%>

</body>
</html>