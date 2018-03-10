<?php
@header('Content-type: text/html;charset=UTF-8');
//定义排序函数my_sort()
function my_sort($array){
	echo "hello";
	for($i=0;$i<count($array);$i++){
		for($j=$i+1;$j<count($array);$j++){
			if($array[$i]>$array[$j]){
				$tmp = $array[$j];
				$array[$j] = $array[$i];
				$array[$i] = $tmp;
			}
		}
	}
	return $array;//返回排序后的数组
}	
echo "请输入需要排序的数据：<br/>";
echo "<form method=post>";
for($i=1;$i<6;$i++){//循环生成文本框
	//文本框的名字是数组名
	echo "<input type='text' name='stu[]' size='5'>";
		if($i<5){
			echo "-";
		}
}
echo "<input type='submit' name='bt' value='提交'>";
echo "</form>";
if(isset($_POST['bt'])){//检查提交按钮是否被按下
	$stu = $_POST['stu'];
	$arr_stu = my_sort($stu);
	echo "排序后的数据如下所示：<br/>";
	while(list($key,$value)=each($arr_stu)){
		echo $value."<br/>"; //输出排序后的值
	}
}

?>

<?php
	/*②定义一个函数，用于比较两个数的大小*/
	function compare($a,$b){
		if($a>$b){
			echo "$a>$b";
		}
		if($a<$b){
			echo "$a<$b";
		}
		if($a==$b){
			echo "$a=$b";
		}
	}
	echo "请输入要比较的两个数：";
	echo "<form method=post>";
	for($i=1;$i<3;$i++){//循环生成文本框
	//文本框的名字是数组名
	echo "<input type='text' name='num[]' size='5'>";
		if($i<3){
			echo "-";
		}
	}
	echo "<input type='submit' name='bt1' value='比较'>";
	echo "</form>";
	if(isset($_POST['bt1'])){
		$num = $_POST['num'];
		echo "两个数的大小为：";
		compare($num[0],$num[1]);
	}

?>