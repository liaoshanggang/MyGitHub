<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>这是Index页面</h2>
<!-- 1============= -->
<form action="UserServlet" method="post">
	email:<input type="text" value="" name="email" /><br>
	password:<input type="text" value="" name="password" /> 
	<input type="submit" value="登录" />  
</form>
</body>
</html>