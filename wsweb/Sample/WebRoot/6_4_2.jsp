<%@page import="com.user.buzi.UserBuzi"%>
<%@page import="com.user.buzi.impl.UserBuziImpl"%>
<%@page import="com.user.bean.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP '6_4_2.jsp' starting page</title>

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
  <c:set target="${requestScope.user }" property="name">${param.name }</c:set>
  <c:set target="${requestScope.user }" property="password">${param.password }</c:set>
  <%
  UserBuzi ub = new UserBuziImpl();
  ub.
  %>
  	<%-- <c:set var="num"scope="session">${5+1 }</c:set>
  	<c:set target="${requestScope.user }" property="userName" value="${param.name }"></c:set>
     --%>
  </body>
</html>
