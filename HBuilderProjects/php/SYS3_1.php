<?php
@header('Content-type: text/html;charset=UTF-8');
?>
<?php
/*实验3.1使用PHP代码输出一个表格*/
$XH="081101";
echo "<table width=200 border=1 align=center>";
echo "<tr><td>学号</td><td>姓名</td><td>性别</td></tr>";
echo "<tr><td>$XH</td><td>王林</td><td>男</td></tr>";
echo "<tr><td>081102</td><td>程明</td><td>男</td></tr>";
echo "</table>";
/*①使用PHP输出字体为黑体、颜色为红色的汉字；输出字体为"幼圆"的超链接*/
echo "<font face=黑体 color=red >①使用PHP输出字体为黑体、颜色为红色的汉字</font><br>";
echo "<a href='' face=幼圆 >输出字体为'幼圆'的超链接</a>";
/*②使用PHP输出一个JavaScript弹出框*/
echo "<script>alert('hello');</script>";
?>