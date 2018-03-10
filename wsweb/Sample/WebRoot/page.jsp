<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'page.jsp' starting page</title>
    
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
   	pageContext.setAttribute("name", "jacky");
    %>
    page.jsp里pageContext.getAttribute("name")的值为：<%=pageContext.getAttribute("name") %>
    <br>
   	<%@include file="include.jsp" %>
   	<% pageContext.include("include.jsp"); %>
   	<jsp:include page="include.jsp"></jsp:include>
   	page.jsp里pageContext.getAttribute("name")的值为：<%=pageContext.getAttribute("name") %> --%> 
   	
   	<%
   	request.setAttribute("name", "jacky");
    %>
    page.jsp里request.getAttribute("name")的值为：<%=request.getAttribute("name") %>
    <br>
   	<%pageContext.include("include.jsp"); %>
    </body>
</html>
