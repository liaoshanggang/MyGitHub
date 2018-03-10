<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP '6_1_3_regShow.jsp' starting page</title>

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
    <div align="center">您输入的注册信息
    	<table border="0" align="center">
    		<tr>
    			<td width="100" height="20">用户名：</td>
    			<td>${param.name }</td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td>${param.pwd }</td>
    		</tr>
    		<tr>
    			<td>电子邮箱：</td>
    			<td>${param.email }</td>
    		</tr>
    		<tr>
    			<td>性别：</td>
    			<td>${param.gen }</td>
    		</tr>
    		<tr>
    			<td>爱好：</td>
    			<td>
    			${paramValues.like[0] }
    			${paramValues.like[1] }
    			${paramValues.like[2] }
    			${paramValues.like[3] }
    			${paramValues.like[4] }
    			${paramValues.like[5] }
    			</td>
    		</tr>
    	</table>
    </div>
  </body>
</html>
