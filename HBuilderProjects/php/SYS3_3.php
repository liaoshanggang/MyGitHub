<html>
	<head>
		<title></title>
		<meta charset="utf-8"/>
	</head>
	<body>
		<form action="" method="post">
			<table border="1" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td colspan="2" align="center" bgcolor="#999999">
						用户登录表单
					</td>
				</tr>
				<tr>
					<td>
						用户名：
					</td>
					<td>
						<input name="username" type="text" />
					</td>
				</tr>
				<tr>
					<td>
						密码：
					</td>
					<td>
						<input name="password" type="password" size="21" />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" name="submit1" value="登录" />
						<input type="reset" name="submit2" value="重置" />
					</td>
				</tr>
			</table>
		</form>
		<!--②由用户在一个表单的文本框中输入内容，单击提交按钮在另一个表单的文本框中显示盖内容-->
		<form name="form1" method="post">
			表单一文本框：<input type="text" name="text1" />
			<input type="submit" name="submit11" value="表单一提交" />
		</form>
		<form name="form2">
			表单二文本框：<input type="text" id="text2" name="text2" value=""/>
		</form>
		<?php
		if(isset($_POST['submit11'])){
			/*echo "<script>alert('hello');</script>";*/
			$text1 = $_POST['text1'];
			echo "<script>document.getElementById('text2').value='$text1';</script>";
		}
		?>
	</body>
</html>


<?php
if(isset($_POST['submit1'])){
	$username = $_POST['username'];
	$password = $_POST['password'];
	if($username=="admin"&&$password=="123456"){
		echo "<script>alert('登录成功');</script>";
	}else{
		echo "<script>alert('登录失败');</script>";
	}
}
?>