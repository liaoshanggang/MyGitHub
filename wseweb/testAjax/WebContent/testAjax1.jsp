<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js">
</script>
<script type="text/javascript">
 $(document).ready(function(){
	 $("button").click(function(){
		 $("#div1").load("hello.txt",function(responseTxt,statusTxt,xhr){
			 if(statusTxt=="success"){
				 alert("外部内容加载成功!");
			 }
			 if(statusTxt=="error"){
				 alert("Error: "+xhr.status+": "+xhr.statusText);
			 }
		 });
	 })
	 $("#btn1").click(function(){
		 $.get("hello.txt",function(data,status){
			 alert("数据: " + data + "\n状态: " + status);
		 });
	 })
	 $("#btn2").click(function(){
		 $.post("hello.txt",{
			 name:"哈哈哈",
		 url:"http://www.baidu.com"
		 },
		 function(data,status){
			 alert("数据: \n" + data + "\n状态: " + status);
		 });
	 })
 });
</script>
</head>
<body>
<div id="div1"><h2>使用 jQuery AJAX 修改文本内容</h2></div>
<button>获取外部内容</button><br>
<input type="button" value="$.get()" id="btn1"><br>
<input type="button" value="$.post()" id="btn2">
</body>
</html>