<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%-- <%
Cookie[] cookies = request.getCookies();
if(cookies!=null){
	for(int i=0; i<cookies.length; i++){
		if(cookies[i].getName().equals("ckname")){
			if(!cookies[i].getValue().equals("admin")){
				response.sendRedirect("normal.jsp");
			}
		}		
	}
}	
%> --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册页面</title>
    
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
    <form method="post" action="ctrl.jsp">
    	用户名：<input type="text" name="name"><br>
    	密&nbsp;&nbsp;码：<input type="password" name="pwd"><br>
    	<input type="submit" name="submit" value="提交">
    </form>
  </body>
</html>
