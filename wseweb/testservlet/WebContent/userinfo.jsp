<%@page import="com.forward.entity.User"%>
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
User user = (User )session.getAttribute("userinfo");
if (user == null ) {
	response.sendRedirect("login.jsp");
	return ;//解决java.lang.NullPointerException
}
String str = (String) request.getAttribute("result");
%>
<h2><%=user.toString() %></h2>
<h2>这是登录结果：<%=str %></h2>
</body>
</html>