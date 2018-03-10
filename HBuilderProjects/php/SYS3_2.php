<html>
	<head>
		<title>HTML中嵌入PHP</title>
		<meta charset="utf-8"/>
	</head>
	<body>
		<!--在文本框中输出PHP内容-->
		<?php
			$XH="081101";	
		?>
		学号：<input type="text" name="tx" size="20" value="<?php echo $XH; ?>"><br/>
		<!--显示一个表单，在表单的控件中使用PHP代码输出控件的选项-->
		<form>
		<?php
		
		?>
		</form>
	</body>
	
</html>