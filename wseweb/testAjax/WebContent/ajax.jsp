<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var xmlHttp;//存储XMLHttpRequest对象
	function checkUserExist() {
		var f = document.userForm;
		var username = f.username.value;
		//调用创建XMLHttpRequest对象的方法，给xmlHttp赋值
		createXMLHttpRequest();
		//调用具体的方法，执行AJAX操作，其中传入的参数表示访问服务器的CheckUser这个Servlet,
		//并把用户填写的注册用户名作为username的参数值传入CheckUser
		doAjax("CheckUser?username=" + username);
		alert("checkUserExist");
	}
	function createXMLHttpRequest()
	{
		if (window.xmlHttpRequest) {
			console.log("xmlHttp1");
			xmlHttp = new xmlHttpRequest();
		} else if (window.ActiveXObject) {
			try {
				console.log("xmlHttp2");
				xmlHttp = new ActiveXObject("Msxml2.xmlHTTP");
			} catch (e) {
				try {
					// IE6, IE5 浏览器执行代码
					console.log("xmlHttp3");
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					console.log("none");
					alert("对不起，您的浏览器不支持xmlHttpRequest对象！");
				}
			}
		}
	}
	function doAjax(url){
		
		if(!xmlHttp){
			return false;
		}

		alert("doAjax");
		//设置状态改变处理程序
		xmlHttp.onreadystatechange = doRequest;
		xmlHttp.open("post",url,true);
		xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlHttp.send(null);
	}
	function doRequest(){
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				if(xmlHttp.responseText=="yes"){
					alert("doRequest");
					document.getElementById("userMsg").innerHTML = "用户名可以使用！";
				}else{
					document.getElementById("userMsg").innerHTML = "用户名已被使用！";
				}
			}else{
				alert("请求处理返回的数据有错误！");
			}
		}
	}
</script>
</head>
<body>
	<form name="userForm" method="post" action="">
		请填写HRS系统注册用户名： <input type="text" id="name" name="username" onblur="checkUserExist()" />
		<div id="userMsg"></div>
	</form>
</body>
</html>