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
			网上书城注册
		<form method="post" action="regCtrl.jsp">
			<table border="0" align="center">
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="username"/></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="pwd"/></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input type="password" name="repwd"/></td>
				</tr>
				<tr>
					<td>电子邮箱：</td>
					<td><input type="text" name="email"/></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><input type="radio" name="sex" value="男" checked="checked">男
					<input type="radio" name="sex" value="女">女</td>
				</tr>
				<tr>
					<td>爱好：</td>
					<td><input type="checkbox" name="like" value="旅游" />旅游
						<input type="checkbox" name="like" value="上网" />上网
						<input type="checkbox" name="like" value="聊天" />聊天<br>
						<input type="checkbox" name="like" value="看电影" />看电影
						<input type="checkbox" name="like" value="玩游戏" />玩游戏
						<input type="checkbox" name="like" value="逛街" />逛街
					</td>
 				</tr>
 				<tr align="center">
 					<td colspan="2"><input type="submit" value="提交"/><input type="reset" value="取消"/></td>
 				</tr>
			</table>
		</form>
		</div>
</body>
</html>