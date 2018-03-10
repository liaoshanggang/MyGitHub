<%@page import="javax.naming.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP '4_1_1JNDI.jsp' starting page</title>

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
    Context	ctx = new InitialContext();
    String name = (String)ctx.lookup("java:comp/env/jndiName");
    //String name = (String)ctx.lookup("java:comp/env/context.xml");
    out.println("JNDI:"+name);
    %>
  </body>
</html>
