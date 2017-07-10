<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.forward.entity.User"%>
<%@page import="com.forward.service.UserServer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//request.setCharacterEncoding("utf-8");
String username = request.getParameter("uname1");
String pwd = request.getParameter("pwd1");%>
你注册的信息为：<br>
用户名:<%=username %>
密码:<%=pwd %>
<hr>
<%
String uname =request.getParameter("username");
String pwd1 = request.getParameter("pwd");
String pwd2 = request.getParameter("repwd");
String email = request.getParameter("email");
String sex = request.getParameter("sex");
%>
你网上书城输入的注册信息为：
用户名：<%=uname %><br>
密码：<%=pwd1 %><br>
确认密码：<%=pwd2 %><br>
邮箱：<%=email %><br>
性别：<%=sex %><br>
爱好：<%
	String[] likes = request.getParameterValues("like");
	if(likes!=null){
		for(int i=0; i<likes.length; i++){
			out.print(likes[i]);
		}
	}
%>
<%
UserServer us = new UserServer();
User u = new User();
u.setUsername(uname);
u.setPwd(pwd1);
u.setEmail(email);
us.userRegister(u);
%>
<hr>
</body>
</html>