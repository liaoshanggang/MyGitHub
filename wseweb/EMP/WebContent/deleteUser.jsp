<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="index.jsp">返回导航页</a>
	<h2>根据雇员编号或雇员名删除雇员信息</h2>
	<form action="EmpServlet?m=delete" method="post">
		<table>
			<tr>
				<td>雇员名:</td>
				<td><input type="text" id="empNo" name="empNo" value="7369" /></td>
			</tr>
			<tr>
				<td>部门编号:</td>
				<td><input type="text" id="deptno" name="deptno" value="30" /></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>