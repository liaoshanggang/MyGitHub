<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'getSession.jsp' starting page</title>
    
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
    <%="session ID:"+session.getId() %>
    <br>
    <%
    Cookie[] cks = request.getCookies();
    if(cks!=null){
    	for(int i = 0; i<cks.length; i++){
    		out.print("cookies名："+cks[i].getName()+"<br>");
    		out.print("cookies值："+cks[i].getValue()+"<br>");
    	}
    }	
    //获取session属性
    Date d = (Date)session.getAttribute("date");
    out.print("获取session中的date值："+d+"<br>");
    %>
  </body>
</html>
