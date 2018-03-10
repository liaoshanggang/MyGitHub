<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.2.1.min.js"></script>
		<script type="text/javascript">
			function query(){
				//$("#submit").click(function() {
					//$(".showEmp").children().html("<tr><td>23</td></tr>");
					var empNo = $("#empNo").val();
					var ename = $("#ename").val();
					var deptno = $("#deptno").val();
					//alert(empNo + "" + ename + "" + deptno);
					$.post("EmpServlet?m=queryAll", //利用ajax发起请求，这里写servlet的路径  
						{
							"empNo": empNo,
							"ename": ename,
							"deptno": deptno
						},
						function(data) {
							var obj = JSON.parse(data);
							//var text = "";
							var showData = "";
							for(i in obj){
								//text += obj[i].empNo;
								showData += "<tr><td>"+obj[i].empNo+"</td><td>"+obj[i].ename
								+"</td><td>"+obj[i].job+"</td><td>"+obj[i].mgr+"</td><td>"+obj[i].hireDate
								+"</td><td>"+obj[i].sal+"</td><td>"+obj[i].comm+"</td><td>"+obj[i].deptno
								+"</td><td><button onclick='removeRow(this)'>删除</button></td></tr>";
							}
							$(".showEmp").children().append(showData);
							
							alert(text);
							//alert(obj);
							//{"emps":{"comm":0,"deptno":0,"empNo":0,"ename":"","hireDate":null,"job":"","mgr":0,"sal":0}}
							/* var empNo = data.emps["empNo"];
							var ename = data.emps["ename"];
							var job = data.emps["job"];
							var mgr = data.emps["mgr"];
							var hireDate = data.emps["hireDate"];
							var sal = data.emps["sal"];
							var comm = data.emps["comm"];
							var deptno = data.emps["deptno"];
							//alert(empNo+":"+ename+":"+job+":"+mgr+":"+hireDate+":"+sal+":"+comm+":"+deptno);
							var text = "<tr><td>"+empNo+"</td><td>"+ename
							+"</td><td>"+job+"</td><td>"+mgr+"</td><td>"+hireDate
							+"</td><td>"+sal+"</td><td>"+comm+"</td><td>"+deptno
							+"</td><td><button onclick='removeRow(this)'>删除</button></td></tr>";
							$(".showEmp").children().append(text); */
						});
				//})
			
			}
			function removeRow(nowTr){
				var empNo = $(nowTr).parent().parent().children().html();
				var empNo = $("#empNo").val();
				var ename = $("#ename").val();
				var deptno = $("#deptno").val();
				$.post("EmpServlet?m=delete", //利用ajax发起请求，这里写servlet的路径  
						{
							"empNo": empNo,
							"ename": ename,
							"deptno": deptno
						},
						function(data) {
						$(nowTr).parent().parent().remove();
							
						});
			}
			
		</script>
		<style>
			.showEmp {
				width: 80%;
			}
		</style>
	</head>

	<body>
		<a href="index.jsp">返回导航页</a>
		<div>
			<span>雇员编号:</span><input type="text" id="empNo" name="empNo" value="8001" />
			<span>雇员名:</span><input type="text" id="ename" name="ename" value="SMITH" />
			<span>部门编号:</span><input type="text" id="deptno" name="deptno" value="30" />
			<input type="submit" value="查询" id="submit" onclick="query()" />
		</div>
		<table border="1" class="showEmp">
			<tr>
				<td>雇员编号</td>
				<td>雇员名</td>
				<td>雇员工作</td>
				<td>管理者编号</td>
				<td>雇佣日期</td>
				<td>薪水</td>
				<td>佣金</td>
				<td>部门编号</td>
				<td>操作</td>
			</tr>
		</table>
	</body>
</html>