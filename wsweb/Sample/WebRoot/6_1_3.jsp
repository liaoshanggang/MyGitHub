<%@page import="com.user.bean.User"%>
<%@page import="com.user.buzi.impl.UserBuziImpl"%>
<%@page import="com.user.buzi.UserBuzi"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP '6_1_3.jsp' starting page</title>

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
    User cUser = ub.getUser("lisi");
    request.setAttribute("user", cUser);
    
    User user = new User();
    user.setName("lisi session");
    user.setId("88");
    pageContext.setAttribute("user", user);
    %>
    <p>
    	欢迎您：${user.name },您的ID是：${user["id"] }
    </p>
  </body>
</html>
