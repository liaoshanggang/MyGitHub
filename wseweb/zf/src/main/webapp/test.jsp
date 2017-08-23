<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入Spring表单的标签库，并将标签库的前缀设置为：form -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="FirstSpringDemo/requestWithParams?name=zhangsan&age=20">
		requestWithParams... </a>

	<hr>
	<h1>REST风格</h1>
	<form action="FirstSpringDemo/requestWithREST/9527" method="post">
		<input type="hidden" name="_method" value="DELETE" /> <input
			type="submit" value="删除" />
	</form>

	<form action="FirstSpringDemo/requestWithREST/9527" method="post">
		<input type="hidden" name="_method" value="PUT" /> <input
			type="submit" value="修改" />
	</form>

	<form action="FirstSpringDemo/requestWithREST/9527" method="post">
		<input type="submit" value="增加" />
	</form>

	<a href="FirstSpringDemo/requestWithREST/9527">查看</a>
	<hr>
	<a href="FirstSpringDemo/requestParam?name=zhangsan&age=23">
		TestRequestParam </a>
	<hr>
	<form action="FirstSpringDemo/firstSpringMVC" method="POST">
		<input type="submit" value="POST方式提交" />
	</form>
	<hr>
	<a href="FirstSpringDemo/requestHeader"> requestHeader</a>
	<br />
	<hr>
	<a href="FirstSpringDemo/cookieValue">cookieValue</a>
	<br />
	<hr>
	<!-- 在form表单中使用实体类的属性名作为<input>标签的name值（可使用级联属性）： -->
	<form action="FirstSpringDemo/entityProperties">
		姓名:<input type="text" name="stuName" /><br> 年龄:<input
			type="text" name="stuAge" /><br>
		<!-- 使用级联属性 -->
		家庭地址:<input type="text" name="address.homeAddress" /><br> 学校地址:<input
			type="text" name="address.schoolAddress" /><br> <input
			type="submit" value="提交" />
	</form>
	<hr>
	<a href="FirstSpringDemo/testModelAndView">testModelAndView</a>
	<br>
	<a href="FirstSpringDemo/testMap">testMap</a>
	<br>
	<a href="FirstSpringDemo/testModelMap">testModelMap</a>
	<br>
	<a href="FirstSpringDemo/testModel">testModel</a>
	<br>
	<hr>
	<a href="FirstSpringDemo/testSessionAttribute">
		testSessionAttribute </a>
	<hr>
	<form action="FirstSpringDemo/testModelAttribute" method="post">
		<input type="hidden" value="31" name="stuNo" /> <br> 年龄:<input
			type="text" name="stuAge" /><br> <input type="submit"
			value="修改" />
	</form>
	<hr>
	<a href="FirstSpringDemo/testI18n">testI18n</a>
	<br />
	<hr>
	<a href="testViewController">testViewController</a>
	<br />
	<hr>
	<form action="FirstSpringDemo/testConversionServiceConverer">
		学生信息: <input type="text" name="studentInfo" value="1-张三-23" /> <input
			type="submit" value="增加" />
	</form>
	<hr>
	<form action="FirstSpringDemo/testDateTimeFormat">
		姓名:<input type="text" name="stuName" /><br> 年龄:<input
			type="text" name="stuAge" /><br> 生日:<input type="text"
			name="birthday" value="2015-05-16" /><br> <input type="submit"
			value="提交" />
	</form>
	<hr>
	<form action="FirstSpringDemo/testValid">
		用户名:<input type="text" name="stuName" /><br> 生日:<input
			type="text" name="birthday" /><br> 邮箱:<input type="text"
			name="email" /><br> <input type="submit" value="提交" />
	</form>
</body>
</html>