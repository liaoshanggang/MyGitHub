<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<HTML>
<HEAD>
<base href="<%=basePath%>" />

<TITLE>搜房网租房</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="style/mycss.css" rel="stylesheet" type="text/css" />
<link href="style/text.css" rel="stylesheet" type="text/css" />
<link href="style/btn.css" rel="stylesheet" type="text/css" />
<!-- Bootstrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script type="text/javascript" src="js/jquery-2.2.3.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
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

	function validateTitle() {
		var pass = false;
		if (document.mf.title.value == "") {
			alert("标题不能为空");
			pass = false;
		} else {
			pass = true;
		}
		if (isNaN(document.mf.rent.value)) {
			alert("租金不是数字");
			pass = false;
		}
		return pass;
	}
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
				//给隐藏的类型名称赋值
				function fnSelectType(oType) {
					var typeOption = oType.options[oType.selectedIndex];
					var typeName = typeOption.text;
					document.mf.typeName.value = typeName;
					//alert(document.mf.typeName.value);
				}

				function fnSelectDistrict(oDistrict) {
					var opt = oDistrict.options[oDistrict.selectedIndex];
					var districtName = opt.text;
					document.mf.districtName.value = districtName;
				}

				function fnSelectStreet(oStreet) {
					var streetOption = oStreet.options[oStreet.selectedIndex];
					var streetName = streetOption.text;
					document.mf.streetName.value = streetName;
				}
			</script>

				<table align="center">
					<tr>
						<td width=''><font color='red'>当前用户：${sessionScope.logUser.username }</font>
						</td>
					</tr>
					<tr>
						<td width='150'><a
							href="house/selectMe?userId=${logUser.userId }">管理我的租房信息</a></td>
					</tr>
					<tr>
						<td width='100'><a
							href="house/toInsert?userId=${logUser.userId }">发布租房信息</a></td>
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

				<form action="house/insert" method="post" name="mf"
					onsubmit="return validateTitle()">
					<input type="hidden" name="userId" value="${logUser.userId }" />

					<table>
						<tr>
							<td colspan="2">发布租房信息：</td>
						</tr>
						<tr>
							<td colspan="2"><hr /></td>
						</tr>
						<tr>
							<td><strong>标题：</strong></td>
							<td><input type="text" name="title" value="${house.title }">
							</td>
						</tr>
						<tr>
							<td><strong>区县：</strong></td>
							<td><select id="district" name="street.district.id" style="width: 80">
							</select></td>
						</tr>
						<tr>
							<td><strong>街道：</strong></td>
							<td><select id="street" name="streetId" style="width: 80">
							</select></td>
						</tr>
						<tr>
							<td><strong>租金：</strong></td>
							<td><input name="price" value="${house.price }">元/月</td>
						</tr>
						<tr>
							<td><strong>房间数：</strong></td>
							<td><select id="street" name="room" style="width: 80">
									<option value="1" ${house.room eq 1 ?'selected':''}>一室</option>
									<option value="2" ${house.room eq 2 ?'selected':''}>二室</option>
									<option value="3" ${house.room eq 3 ?'selected':''}>三室</option>
									<option value="4" ${house.room eq 4 ?'selected':''}>四室</option>
							</select> <select id="street" name="hall" style="width: 80">
									<option value="1" ${house.hall eq 1 ?'selected':''}>一厅</option>
									<option value="2" ${house.hall eq 2 ?'selected':''}>二厅</option>
									<option value="3" ${house.hall eq 3 ?'selected':''}>三厅</option>
							</select></td>
						</tr>
						<tr>
							<td><strong>房屋类型：</strong></td>
							<td><select name="typeId">
									<option value="0" ${house.types.id eq 0 ?'selected':''}>不限</option>
									<option value="1" ${house.types.id eq 1 ?'selected':''}>地下室</option>
									<option value="2" ${house.types.id eq 2 ?'selected':''}>平房</option>
									<option value="3" ${house.types.id eq 3 ?'selected':''}>普通住宅</option>
									<option value="4" ${house.types.id eq 4 ?'selected':''}>公寓</option>
									<option value="5" ${house.types.id eq 5 ?'selected':''}>别墅</option>
							</select></td>
						</tr>
						<tr>
							<td><strong>联系电话：</strong></td>
							<td><input name="telephone" value="${house.telephone }" /></td>
						</tr>
						<tr>
							<td><strong>联系人：</strong></td>
							<td><input name="contact" value="${house.contact }" /></td>
						</tr>

						<tr>
							<td><strong>房屋信息：</strong></td>
							<td><textarea name="description" rows="10" cols="40">${house.description}</textarea></td>
						</tr>
						<tr>
							<td colspan="2">
								<div align="center">
									<input type="submit" value="发布" class="btn">
								</div>
							</td>
						</tr>

						<!-- <tr>
				<td>
					异步
					<div align="center"><span id="msg"></span></div>
				</td>
			</tr> -->
					</table>
				</form>
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