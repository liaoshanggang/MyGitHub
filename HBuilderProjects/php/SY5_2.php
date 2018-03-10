<?php
@header('Content-type: text/html;charset=UTF-8');
?>
<!!DOCTYPE >
<form enctype="multipart/form-data" action="" method="post">
	<input type="file" name="myFile" />
	<input type="submit" name="up" value="文件上传" />
</form>
<?php
	if(isset($_POST['up'])){
		if($_FILES['myFile']['type']=="image/gif"){
			if($_FILES['myFile']['error']>0){
				echo "错误：".$_FILES['myFile']['error'];
			}else{
				$tmp_filename = $_FILES['myFile']['tmp_name'];//临时文件名
				$filename = $_FILES['myFile']['name'];//上传的文件名
				$dir="../good/html";//上传后文件的位置
				if(is_uploaded_file($tmp_filename)){//判断是否通过HTTP POST上传
					//上传并移动文件
					if(move_uploaded_file($tmp_filename,"$dir.$filename")){
						echo "文件上传成功！";
						//输出文件大小
						echo "文件大小为：".($_FILES['myFile']['size']/1024)."KB";
					}
					else
					echo "上传文件失败！";
				}
			}
		}else{
			echo "文件格式非GIF图片！";
		}
	}
?>