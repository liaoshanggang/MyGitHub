<%@page import="com.user.bean.User"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.user.buzi.impl.UserBuziImpl"%>
<%@page import="com.user.buzi.UserBuzi"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP '6_1_2.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    
    UserBuzi ub = new UserBuziImpl();
    out.print("hello");
    User cUser = ub.getUser("lisi");
    out.print(cUser);
    //User cUser = ub.getUser("lisi");
    //request.setAttribute("user", cUser);
    %>
    <p>
    	欢迎您：${requestScope.user.userName },您的ID是：${requestScope.user["id"] }
    </p>
  </body>
</html>
