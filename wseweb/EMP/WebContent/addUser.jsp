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
	<h2>添加雇员信息</h2>
	<form action="EmpServlet?m=add" method="post">
		<table>
			<!-- <tr><td>雇员编号:</td><td><input type="text" id="empNo" name="empNo" value="7369" /></td></tr> -->
			<tr>
				<td>雇员名:</td>
				<td><input type="text" id="ename" name="ename" value="SMITH" /></td>
			</tr>
			<tr>
				<td>雇员工作:</td>
				<td><input type="text" id="job" name="job" value="SALESMAN" /></td>
			</tr>
			<tr>
				<td>管理者编号:</td>
				<td><input type="text" id="mgr" name="mgr" value="7902" /></td>
			</tr>
			<tr>
				<td>雇佣日期:</td>
				<td><input type="text" id="hireDate" name="hireDate"
					value="null" /></td>
			</tr>
			<tr>
				<td>薪水:</td>
				<td><input type="text" id="sal" name="sal" value="5250" /></td>
			</tr>
			<tr>
				<td>佣金:</td>
				<td><input type="text" id="comm" name="comm" value="300" /></td>
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