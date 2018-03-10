<%@page import="com.user.bean.User"%>
<%@page import="com.user.buzi.UserBuzi"%>
<%@page import="com.user.buzi.impl.UserBuziImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP '5_4_2user_list.jsp' starting page</title>

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
  	<table border="1">
  		<tr>
  			<th>id</th>
  			<th>name</th>
  			<th>pwd</th>
  		</tr>
  		
  			<%
  			UserBuzi ud = new UserBuziImpl();
  			List<User> list = ud.getAllUSers();
  			for(Object o:list){
  				User u = (User)o;
  				%>
  				<tr>
  				<td><%=u.getId() %></td>
  				<td><%=u.getName() %></td>
  				<td><%=u.getPassword() %></td>
  				</tr>
  			<%
  			}
  			%>

  	</table>
  </body>
</html>
