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
		用户注册
		<form name="reg" method="post" action="regShow.jsp">
			<table border="0" align="center">
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input type="password" name="pwd2"></td>
				</tr>
				<tr>
					<td>电子邮箱：</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><input name="gen" type="radio" value="男" checked="checked" />男&nbsp;&nbsp;
						<input name="gen" type="radio" value="女" />女</td>
				</tr>
				<tr>
					<td>爱好：</td>
					<td><input type="checkbox" name="like" value="旅游" />旅游 <input
						type="checkbox" name="like" value="上网" />上网 <input
						type="checkbox" name="like" value="游戏" />游戏 <input
						type="checkbox" name="like" value="购物" />购物 <input
						type="checkbox" name="like" value="看电视" />看电视 <input
						type="checkbox" name="like" value="阅读" />阅读</td>
				</tr>
				<tr>
					<td>
					<td colspan="2" align="center"><input type="submit"
						name="Submit" value="提交" /> <input type="reset" name="Reset"
						value="取消" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>