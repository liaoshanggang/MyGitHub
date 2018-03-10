<?php
@header('Content-type: text/html;charset=UTF-8');
?>
<html>
	<head>
		<title>文本文件的分页读取</title>
	</head>
	<body>
		<center>
			<font size="5" face="华文楷体" color="blue">PHP分页显示</font>
		</center>
		<div style="margin: 0 auto;width: 600px;height: 300px;border: solid 2px #FF0000; background-color: #00FFFF;line-height: 255px;">
			<!--分页显示文本信息-->
			<?php
				$page_curr=$_GET['page']=="" ? 1:$_GET['page'];
				if($page_curr){
					$contents = file_get_contents("data.txt");
					$length = strlen($contents);
					$page_count=ceil($length/800);
					echo substr($contents,($page_curr-1)*800,800);
				}
			?>
		</div>
		<!--显示分页超链接-->
		<div align="center">
			<?php
				echo "<br>";
				echo "<共".$page_count."页><第".$page_curr."页>";
					if($page_count!=1&&$page_curr!=1){
						echo "<a href='SY5_3.php=1'><首页></a>";
						echo "<a href='SY5_3.php?page=".($page_curr-1)."'><上一页></a>";
					}
					if($page_curr<$page_count){
						echo "<a href='SY5_3.php?page=".($page_curr+1)."'><下一页></a>";
						echo "<a href='SY5_3.php?page=".($page_count)."'><尾页></a>";
					}
			?>
		</div>
	</body>
</html>