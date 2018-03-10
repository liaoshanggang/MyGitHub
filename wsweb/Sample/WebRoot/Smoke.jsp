<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Smoke.jsp' starting page</title>
    
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
  	<!-- 小脚本 -->
    <%-- <%
    	int age = 21;
    	if(age<18){
    		out.println("你不是未成年人，不可以抽香烟！");
    	}else{
    		out.println("你已经成年人了，可以抽香烟！");
    	}
    %> --%>
    
    <%
    	int age = 21;
    	String str = "";
    	if(age<18){
    		str = "你不是未成年人，不可以抽香烟！";
    	}else{
    		str = "你已经成年人了，可以抽香烟！";
    	}
    %>
   	 您的年龄为：<% =age %>,<% ="提醒："+str %>
   	 
   	 <%-- <%!
    	int age1 = 21;
   	 	int age2 = 17;
   	 	String msg = "提醒：";
    %>
    <%!
    public String printStr(int age){
    	if(age<18){
    		return "你不是未成年人，不可以抽香烟！";
    	}else{
    		return "你已经成年人了，可以抽香烟！";
    	}
    }
    %>
   	 您的年龄为：<%=age1 %>,<%=msg%>,<%=printStr(age1) %><br>
   	 您的年龄为：<%=age2 %>,<%=msg%>,<%=printStr(age2) %> --%>
  </body>
</html>
