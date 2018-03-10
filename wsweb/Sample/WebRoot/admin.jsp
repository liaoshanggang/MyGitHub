<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员后台页面</title>
    
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
    Cookie[] cks = request.getCookies();
    String name = "";
    	for(int i=0; i<cks.length; i++){
    		if(cks[i].getName().equals("ckname")){
    			name = cks[i].getValue();
    		}
    	}
    %>
           您好，你是管理员:<%=name %>欢迎进入本页面！ --%> 
    <%-- <%
    String name = (String)session.getAttribute("adsesstionname");
    if(name==null||!name.equals("admin")){
    	response.sendRedirect("login.jsp");
    }
    %> --%>
    <%@ include file = "adminLogin.jsp"%>
    <%="已登录人数："+(Integer)application.getAttribute("LoginCount")
    %>
            您好，你是管理员:<%=name %>欢迎进入本页面！
   <ul>
   	<li><a href="#"></a>添加图书</li>
   	<li><a href="#"></a>修改图书</li>
   	<li><a href="#"></a>图书上架</li>
   	<li><a href="#"></a>图书下架</li>
   	<li><a href="#"></a>退出</li>
   </ul>
  </body>
</html>
