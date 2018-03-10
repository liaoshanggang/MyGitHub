<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>会员注册信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->;
	<%
	request.setCharacterEncoding("GBK");
	String name = request.getParameter("name");
	String pwd = request.getParameter("pwd");
	String repwd = request.getParameter("repwd");
	String email = request.getParameter("email");
	String sex = request.getParameter("sex");
	String[] likes = request.getParameterValues("like");
	%>
  </head>
  
  <body>
    <div align="center">
   		<table border="1" align="center">
    		<tr>
    			<td>用户名：</td>
    			<td><%=name %></td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td><%=pwd %></td>
    		</tr>
    		<tr>
    			<td>确认密码：</td>
    			<td><%=repwd %></td>
    		</tr>
    		<tr>
    			<td>电子邮箱：</td>
    			<td><%=email %></td>
    		</tr>
    		<tr>
    			<td>性别：</td>
    			<td><%=sex %></td>
    		</tr>
    		<tr>
    			<td>爱好:</td>
    			<td>
    			<%
	    			if(likes!=null){
	    				for(int i=0;i<likes.length;i++){
	        				out.print(likes[i]+"&nbsp;");
	        			}
	    			}
    			 %>
    			</td>
    		</tr>
   		</table> 	
    </div>
  </body>
</html>
