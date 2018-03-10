<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="phoneCtrl.jsp">
		<table>
			<tr>
			<td>手机号码：</td>
			<td><input type="text" name="phoneNum">
			</td>
			</tr>
			<tr>
			<td>充值：</td>
			<td><input type="text" name="money"></td>
			</tr>
			<tr>
			<td><input type="submit" name="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>