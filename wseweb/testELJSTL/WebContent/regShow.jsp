<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		您输入的注册信息
		<table border="0" align="center">
			<tr>
				<td width="100" height="20">用户名：</td>
				<td>${param.name}</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td>${param.pwd}</td>
			</tr>
			<tr>
				<td>电子邮箱：</td>
				<td>${param.email}</td>
			</tr>
			<tr>
				<td>性别：</td>
				<td>${param.gen}</td>
			</tr>
			<tr>
				<td>爱好：</td>
				<td>${paramValues.like[0]} ${paramValues.like[1]}
					${paramValues.like[2]} ${paramValues.like[3]}
					${paramValues.like[4]} ${paramValues.like[5]}</td>
			</tr>
		</table>
	</div>
</body>
</html>