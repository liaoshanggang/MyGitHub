<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<HTML>
<HEAD>
<base href="<%=basePath%>">
<TITLE>搜房网租房</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<META http-equiv=Content-Type content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="style/mycss.css" rel="stylesheet" type="text/css" />
<link href="style/text.css" rel="stylesheet" type="text/css" />
<link href="style/btn.css" rel="stylesheet" type="text/css" />
<!-- Bootstrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script type="text/javascript" src="js/jquery-2.2.3.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<script language="javascript">
	$(function() {
		$.get("house/loaddistricts", function(data) {
			var select = $("#district");
			var opt = $("<option></option>").attr("value", "").html("--不限--");
			select.append(opt);
			$.each(data, function(i, item) {
				var option = $("<option></option>").attr("value", item.id)
						.html(item.name);
				select.append(option);
			});
		}, "json");

		//
		$("#district").change(
				function() {
					$("#street").empty();
					var opt = $("<option></option>").attr("value", "").html(
							"--不限--");
					$("#street").append(opt);

					var districtId = $(this).val();
					$.get("house/loadstreets", {
						"districtId" : districtId
					}, function(data) {
						var select = $("#street");
						$.each(data, function(i, item) {
							var option = $("<option></option>").attr("value",
									item.id).html(item.name);
							select.append(option);
						});
					}, "json");
				});

	});
</script>

</HEAD>
<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0
	MARGINHEIGHT=0>

	<table width="780" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td colspan="5"><img src="images/top.jpg" width="780"
				height="213"></td>
		</tr>
		<tr>
			<td colspan="5"><img src="images/middle1.jpg" width="780"
				height="47"></td>
		</tr>
		<tr>
			<td width="38" background="images/middle2.jpg">&nbsp;</td>
			<td width="172" valign="top"><script language="javascript">
				function login() {
					if (document.myForm.uname.value == "") {
						alert("用户名不能为空");
						return false;
					} else if (document.myForm.upass.value == "") {
						alert("密码不能为空");
						return false;
					} else {
						return true;
					}
				}
			</script>
				<table align="center">
					<tr>
						<td width=''><font color='red'>当前用户：${sessionScope.logUser.username}
						</font></td>
					</tr>
					<tr>
						<td width='150'><a
							href="house/selectMe?userId=${logUser.userId }">管理我的租房信息</a></td>
					</tr>
					<tr>
						<td width='100'><a
							href="house/toInsert?userId=${logUser.userId }">发布我的租房信息</a></td>
					</tr>
					<tr>
						<td width='100'><a href="house/list">最新租房信息</a></td>
					</tr>
					<tr>
						<td width='100'><a href="index.jsp">返回首页</a></td>
					</tr>
					<tr>
						<td width='100'><a href="user/logOut">[注销]</a></td>
					</tr>
				</table></td>
			<td width="35" background="images/layout_24.gif">&nbsp;</td>
			<td width="495">

				<form action="house/list" method="post" name="mf">
					<script>
						function fswitch(id) {
							var o = document.getElementById(id);
							if (o) {
								if (o.style.display == "none") {
									o.style.display = "block";
								} else {
									o.style.display = "none";
								}
							}
						}
					</script>
					<div style="text-align: left; width: 88%;">
						<input name="title"> <input type="submit" value="查询"
							class="btn"> <span onclick="fswitch('advSearch');"
							style="cursor: hand; color: blue;">高级搜索</span>
					</div>

					<table width="88%;" id="advSearch"
						style="border: solid 0px #000; display: none;">
						<tr>
							<td>区县：</td>
							<td><select id="district" name="qxid" style="width: 80">
							</select></td>
							<td rowspan="6">&nbsp;</td>
						</tr>
						<tr>
							<td>街道：</td>
							<td><select id="street" name="streetId" style="width: 80">
							</select></td>
						</tr>
						<tr>
							<td>租金：</td>
							<td><input type="text" name="lowPrice" size="5"
								class="unnamed1"> 至 <input type="text" name="hiPrice"
								size="5" class="unnamed1"> 元/月</td>
						</tr>
						<tr>
							<td colspan='3'><hr /></td>
						</tr>

					</table>
				</form>

				<table>
					<tr>
						<td width="3%">&nbsp;</td>
						<td width="97%">

							<table>
								<tr>
									<TD width='250'>标题</TD>
									<TD width='90' align='center'>月租金</TD>
									<TD align='center'>发布日期</TD>
								</tr>
								<tr>
									<td colspan='3'><hr /></td>
								</tr>

								<c:forEach var="house" items="${houseList}">
									<tr>
										<td><a href='house/detail/${house.id }'>${house.title }</a></td>
										<td align='center' style='height: 30px;'>${house.price }元</td>
										<td align='center'><fmt:formatDate
												value="${house.pubdate }" pattern="yyyy-MM-dd" /></td>
									</tr>
								</c:forEach>
								<tr>
									<td colspan='3'><hr /></td>
								</tr>
								<!-- 分页链拉 -->
								<tr>
									<td colspan='3'><c:if test="${not empty housePage}">
											<ul class="pagination">
												<li><a href="house/list.do?pageNo=1">«</a></li>
												<c:if test="${housePage.pageNo gt 3}">
													<li><a href="javascript:void(0)">....</a></li>
												</c:if>
												<c:if test="${housePage.pageNo-2 ge 1}">
													<li><a
														href="house/list.do?pageNo=${housePage.pageNo-2}">${housePage.pageNo-2}</a></li>
												</c:if>
												<c:if test="${housePage.pageNo-1 ge 1}">
													<li><a
														href="house/list.do?pageNo=${housePage.pageNo-1}">${housePage.pageNo-1}</a></li>
												</c:if>
												<li class="active"><a
													href="house/list.do?pageNo=${housePage.pageNo}">${housePage.pageNo}</a></li>
												<c:if test="${housePage.pageNo+1 le housePage.totalPage}">
													<li><a
														href="house/list.do?pageNo=${housePage.pageNo+1}">${housePage.pageNo+1}</a></li>
												</c:if>
												<c:if test="${housePage.pageNo+2 le housePage.totalPage}">
													<li><a
														href="house/list.do?pageNo=${housePage.pageNo+2}">${housePage.pageNo+2}</a></li>
												</c:if>
												<c:if test="${housePage.pageNo+2 lt housePage.totalPage}">
													<li><a href="javascript:void(0)">....</a></li>
												</c:if>
												<li><a
													href="house/list.do?pageNo=${housePage.totalPage}">»</a></li>
											</ul>
										</c:if></td>
								</tr>
							</table>



						</td>
					</tr>
					<tr>
						<td colspan="2"></td>
					</tr>
				</table>
			</td>
			<td width="40" background="images/middle4.jpg">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="5"><img src="images/bottom.jpg" width="780"
				height="82"></td>
		</tr>
	</table>
	<P align="center">2014 搜房网 版权所有</P>
	<br />
</BODY>
</HTML>
