<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��Աע����Ϣ</title>
    
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
    			<td>�û�����</td>
    			<td><%=name %></td>
    		</tr>
    		<tr>
    			<td>���룺</td>
    			<td><%=pwd %></td>
    		</tr>
    		<tr>
    			<td>ȷ�����룺</td>
    			<td><%=repwd %></td>
    		</tr>
    		<tr>
    			<td>�������䣺</td>
    			<td><%=email %></td>
    		</tr>
    		<tr>
    			<td>�Ա�</td>
    			<td><%=sex %></td>
    		</tr>
    		<tr>
    			<td>����:</td>
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
