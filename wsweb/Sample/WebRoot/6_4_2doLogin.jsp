<%@page import="com.user.bean.User"%>
<%@page import="com.user.buzi.impl.UserBuziImpl"%>
<%@page import="com.user.buzi.UserBuzi"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP '6_4_2doLogin.jsp' starting page</title>

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
  User user = new User();
  request.setAttribute("user", user);
  %>
  
  <c:set target="${requestScope.user }" property="name" >${param.name }</c:set>
  <c:set target="${requestScope.user }" property="password">${param.pwd }</c:set>
  <%
  	UserBuzi ub = new UserBuziImpl();
  	boolean flag = ub.login(ub);
	if(flag){
		session.setAttribute("name", ub.getUser(user.getName()));
		session.setMaxInactiveInterval(10*60);
		//out.print("登录成功,欢迎您！");
		response.sendRedirect("6_4_2user_list.jsp");
	}else{
		response.sendRedirect("6_4_2login.jsp");
	}
  %>
  
  </body>
</html>
