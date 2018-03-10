<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>普通用户页面</title>
    
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
  <%-- <%
  	String name = (String)session.getAttribute("adsesstionname");
  if(name==null){
	  response.sendRedirect("login.jsp");
  }
  
  %> --%>
  <%@ include file="normalLogin.jsp" %>
  <%="已登录人数："+(Integer)application.getAttribute("LoginCount")%>
  您好，这是普通用户内容页：您是:<%=name %>欢迎进入本页面！
  <ul>
  	<li><a href="#">图书信息</a></li>
  	<li><a href="#">购物车</a></li>
  	<li><a href="#">订单管理</a></li>
  	<li><a href="#">退出</a></li>
  </ul>
  </body>
</html>
