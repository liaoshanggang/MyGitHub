<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
})
</script>
<style>
			table{
				width: 1000px;
			}
		</style>
</head>
<body>
<h3>显示所有用户信息</h3>
<table border="1">
<tr><td>cardNo</td>
<td>accountNo</td>
<td>password</td>
<td>cardType</td>
<td>balance</td>
</tr>
<c:forEach var="user" items="${users }">

	<tr>
		<td>${user.cardNo }</td>
		<td>${user.accountNo }</td>
		<td>${user.password }</td>
		<td>${user.cardType }</td>
		<td>${user.balance }</td>
		<td><a href="UserServlet?m=delete">删除</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>