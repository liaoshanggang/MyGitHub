<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style>
* {
	margin: 0px;
}

.head {
	height: 80px;
	//background: blueviolet;
}

.body {
	height: 500px;
	width: auto;
	//background: #008000;
}

.foot {
	height: auto;
	background: blueviolet;
}
.option{
width:150px;
}

</style>
</head>
<body>
	<div class="head">
	<h1>Welcome register!</h1>
	<h3 align="right"><a href="atmLogin.jsp">has account？Please login in</a></h3>
	<%-- <h6 align="right"><%@ include file="head.jsp" %></h6> --%>
	</div>
	<hr size=1px>
	<div class="body">
		<div>
			
			<form method="post" action="LoginRegisterServlet?m=register">
					<h1>Atm注册</h1>
					<table>
						<tr>
						<td>账号:</td>
						<td><input type="text" name="accountNo"/></td>
					</tr>
					<tr>
						<td>密码:</td>
						<td><input type="text" name="password"/></td>
					</tr>
					<tr>
						<td>卡类型:</td>
						<!-- <td><input type="text" name="cardType"/></td> -->
						<td><select class="option" name="cardType">
						<option>请选择银行类型</option>
						<option>Agricultural Bank of China</option>
						<option>China Constuction Bank</option>
						<option>Bank of China</option>
						<option>Bank of Communications</option>
						</select></td>
					</tr>
					<tr>
						<td>卡金额:</td>
						<td><input type="text" name="balance"/></td>
					</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit" name="submit" value="注册" />
							<input type="reset" name="reset" value="取消"/>
							</td>
						</tr>
					</table>
				</form>
		</div>
	</div>
	<hr size=10px>
	<div class="foot"></div>
</body>
</html>