<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>会员注册</title>
    
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
    <div align="center">
    	<form name="reg" method="get" action="RegShow.jsp">
    		<table border="1" align="center">
	    		<tr>
	    			<td>用户名：</td>
	    			<td><input type="text" name="name"></td>
	    		</tr>
	    		<tr>
	    			<td>密码：</td>
	    			<td><input type="text" name="pwd"></td>
	    		</tr>
	    		<tr>
	    			<td>确认密码：</td>
	    			<td><input type="text" name="repwd"></td>
	    		</tr>
	    		<tr>
	    			<td>电子邮箱：</td>
	    			<td><input type="text" name="email"></td>
	    		</tr>
	    		<tr>
	    			<td>性别：</td>
	    			<td><input type="radio" name="sex" value="男">男
						<input type="radio" name="sex" value="女">女</td>
	    		</tr>
	    		<tr>
	    			<td>爱好:</td>
	    			<td><input type="checkbox" name="like" value="旅游">旅游
	    				<input type="checkbox" name="like" value="上网">上网
	    				<input type="checkbox" name="like" value="游戏">游戏<br>
	    				<input type="checkbox" name="like" value="购物">购物
	    				<input type="checkbox" name="like" value="看电视">看电视
	    				<input type="checkbox" name="like" value="阅读">阅读	
	    			</td>
	    		</tr>
	    		<tr>
	    			<td colspan="2" align="center">
	    			<input type="submit" name="submit" value="提交">
	    			<input type="reset" name="reset" value="取消">
	    			</td>
	    		</tr>
    		</table>
    	</form>  	
    </div>
  </body>
</html>
