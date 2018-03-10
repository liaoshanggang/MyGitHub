<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登录</h1>
	<%
	Cookie[] cks = request.getCookies();
	String email = "";
	if (cks!=null) {
		for (Cookie c : cks) {
			if (c.getName().equals("email")) {
				email = c.getValue();
			}
		}
	}
	%>
	<form action="ctrl.jsp" method="post">
		<table>
			<tr><td>邮箱：</td><td><input type="text" value="<%=email %>" name="email"></td></tr>
			<tr><td>密码：</td><td><input type="text" value="" name="pwd"></td></tr>
			<tr><td colspan="2"><input type="submit" value="提交" name=""submit""></td></tr>
		</table>
	</form>
</body>
</html>