<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<base href="${basePath}">
		<%@include file="../../css-common.jsp"%>
		<%@include file="../../js-common.jsp"%>
		<title>蓝桥在线考试系统</title>
		<script type="text/javascript">
			$(function() {

				$.get("admin/loadCourses", function(data) {
					var select = $("#courses");

					var opt = $("<option></option>").attr("value", "").html("--不限--");
					select.append(opt);
					$.each(data, function(i, item) {
						var option = $("<option></option>").attr("value", item.id)
							.html(item.courseName);
						select.append(option);
					});
				}, "json");

				//
				$("#courses").change(
					function() {
						$("#catagory").empty();
						var opt = $("<option></option>").attr("value", "").html(
							"--不限--");
						$("#catagory").append(opt);

						var courseId = $(this).val();
						$.get("admin/loadTechCategorys", {
							"courseId": courseId
						}, function(data) {
							var select = $("#catagory");
							$.each(data, function(i, item) {
								var option = $("<option></option>").attr("value",
									item.id).html(item.techCtgr);
								select.append(option);
							});
						}, "json");
					});

				//全选、反选
				$("#checkAll").click(function() {
					$(".chooseall").each(function() {
						this.checked = !this.checked;
					})
				});
				//展开
				$("#toggle").click(function() {
					$("p").toggle();
				});
			});

			function addSelectSim(id) {
				if(id == undefined) {
					var len = 0;
					var cks = $("input[name='checkBox']");
					for(var i = 0; i < cks.length; i++) {
						if(cks[i].checked) {
							++len;
						}
					}
					if(len == 0) {
						alert("请选择要加入试卷的多选题！");
						return;
					}
					var ids = [];
					for(var i = 0; i < cks.length; i++) {
						if(cks[i].checked) {
							var id = $(cks[i]).val();
							ids.push(id);
						}
					}
					var multipleId = ids.join(",");
					var examNo = $("#examNo").val();
					alert(multipleId + "" + examNo);
					$.ajax({
						url: "admin/addExamination?questionType=2&examNo=" + examNo,
						type: "post",
						data: "multipleId=" + multipleId,
						success: function(result) {
							// if (status == "success") {
							alert("多选题加入试卷成功");
							//alert("单选题加入试卷成功");
							//}
							location = location;

						},
						error: function() {

						}
					});
				}
			}
		</script>
	</head>

	<body>
		<div id="wrapper">
			<nav class="navbar-default navbar-static-side" role="navigation">
				<div class="sidebar-collapse">
					<ul class="nav metismenu" id="side-menu">
						<li class="nav-header">
							<div class="dropdown profile-element" style="text-align: center">
								<span> <img alt="image" class="img-circle"
							src="images/common/a4.jpg" />
						</span>
								<a data-toggle="dropdown" class="dropdown-toggle" href="#"> <span class="clear"> <span class="text-muted text-xs block"
								style="margin-top: 15px"> 老师二 <b class="caret"></b>
							</span>
									</span>
								</a>
								<ul class="dropdown-menu animated fadeInRight m-t-xs">
									<li>
										<a href="#">简介</a>
									</li>
									<li>
										<a href="#">联系</a>
									</li>
									<li>
										<a href="#">邮箱</a>
									</li>
									<li class="#"></li>
									<li>
										<a href="user/logoff">退出</a>
									</li>
								</ul>
							</div>
							<div class="logo-element">第六组</div>
						</li>
						<li>
							<a href="index.html"><i class="fa fa-th-large"></i> <span class="nav-label">考试管理</span> <span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li class="active">
									<a href="showExamRadio">考试</a>
								</li>
								<li class="active">
									<a href="#examination">主观题阅卷</a>
								</li>
								<li class="active">
									<a href="#examination">查看成绩</a>
								</li>
								<li class="active">
									<a href="#examination">考卷维护</a>
								</li>
							</ul>
						</li>

						<li>
							<a href="index.html"><i class="fa fa-th-large"></i> <span class="nav-label">试题新增</span> <span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li class="active">
									<a href="views/question/radio_input.jsp?questionType=1">新增单选题</a>
								</li>
								<li class="active">
									<a href="views/question/mulchoi_input.jsp?questionType=2">新增多选题</a>
								</li>
								<li class="active">
									<a href="views/question/judge_input.jsp?questionType=3">新增判断题</a>
								</li>
								<li class="active">
									<a href="#question">新增简答题</a>
								</li>
								<li class="active">
									<a href="#question">新增编程题</a>
								</li>
							</ul>
						</li>

						<li>
							<a href="index.html"><i class="fa fa-th-large"></i> <span class="nav-label">试题查询</span> <span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li class="active">
									<a href="views/question/radio_list.jsp">单选题查询</a>
								</li>
								<li class="active">
									<a href="views/question/mulchoi_list.jsp">多选题查询</a>
								</li>
								<li class="active">
									<a href="views/question/judge_list.jsp">判断题查询</a>
								</li>
								<li class="active">
									<a href="#question">简答题查询</a>
								</li>
								<li class="active">
									<a href="#question">编程题查询</a>
								</li>
							</ul>
						</li>

						<li>
							<a href="index.html"><i class="fa fa-th-large"></i> <span class="nav-label">分类管理</span> <span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li class="active">
									<a href="courses/testSelectAllCourse">课程名</a>
								</li>
								<li class="active">
									<a href="views/catagory/questCatagory_input.jsp">知识点</a>
								</li>
							</ul>
						</li>

						<li>
							<a href="index.html"><i class="fa fa-th-large"></i> <span class="nav-label">用户管理</span> <span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li class="active">
									<a href="views/user/importUserInfo.jsp">批量导入用户</a>
								</li>
								<li class="active">
									<a href="user/listForUser">批量操作用户</a>
								</li>
								<li class="active">
									<a href="views/user/changeUserInfo.jsp">修改用户信息</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</nav>

			<div id="page-wrapper" class="gray-bg dashbard-1">
				<div class="row border-bottom">
					<nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
						<div class="navbar-header">
							<a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
						</div>
						<ul class="nav navbar-top-links navbar-right">
							<li>
								<a href="user/logoff"> <i class="fa fa-sign-out"></i> 退出
								</a>
							</li>

							<li>
								<a class="right-sidebar-toggle"> <i class="fa fa-tasks"></i>
								</a>
							</li>
						</ul>
					</nav>

				</div>
				<div class="row  border-bottom white-bg dashboard-header"></div>

				<!--主要内容开始主要内容开始主要内容开始主要内容开始主要内容开始   -->
				<div class="ibox-content">
					<form action="admin/selMulchoi" method="post" class="form-horizontal">
						<div class="form-group">
							<div class="form-group">
								<label class="col-sm-2 control-label">题干</label>
								<div class="col-sm-7">
									<input name="question" type="text" class="form-control" placeholder="请输入关键字">
								</div>
								<input type="hidden" name="questionType" value="1" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">试题类别</label>
							<div class="col-sm-9">
								<div class="col-lg-5 m-l-n">
									<strong>课程：</strong>
									<select class="form-control m-b" id="courses" name="tCategory.courses.id" style="width: 80">
									</select>
								</div>
								<div class="col-lg-5 m-l-n">
									<strong>知识点：</strong>
									<select class="form-control m-b" id="catagory" name="techCateId" style="width: 80">
									</select>

								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-6 col-sm-offset-5">
								<button class="btn btn-white" type="submit">查询</button>
								<button class="btn btn-primary" type="submit">重置</button>
							</div>
						</div>

					</form>
					<div class="hr-line-dashed"></div>
					<!-- 显示题目  -->
					<div class="ibox float-e-margins">
						<div class="ibox-content">
							<c:forEach var="smd" items="${smdqList}" varStatus="status">
								<div class="checkbox">
									<h2>

									<label class="checkbox-inline i-checks"> <input
										type="checkbox" class="chooseall" name="checkBox" class="qx"
										value="${smd.id}"></label>
									<!-- 
									<label class="checkbox" for="closeButton"> <input
										id="checkBox" type="checkbox" value="checked"
										class="input-mini" /> -->
									${status.count }.${smd.question }${smd.id }
									&nbsp;&nbsp;&nbsp;${smd.pubdate} </label>
								</h2>
								</div>
								<ol type="A">
									<li>${smd.options.optionA }</li>
									<li>${smd.options.optionB }</li>
									<li>${smd.options.optionC }</li>
									<li>${smd.options.optionD }</li>
									<li>${smd.options.optionE }</li>
								</ol>

								<div class="text-left">
									答案：${smd.correct }
									<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#${smd.id }">更新</button>
									<a href="admin/delMulchoi?id=${smd.id }"><button type="button" id="delete" class="btn btn-primary">删除</button></a>
								</div>

								<!-- 修改多选题信息模态框 -->
								<div class="modal inmodal fade" id="${smd.id }" tabindex="-1" role="dialog" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">
												<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
											</button>
												<h4 class="modal-title">更新多选题信息</h4>
											</div>

											<script type="text/javascript">
												$
													.get(
														"admin/loadCourses",
														function(data) {
															var select = $("#courses1${smd.id }");

															var opt = $(
																	"<option></option>")
																.attr(
																	"value",
																	"")
																.html(
																	"--不限--");
															select
																.append(opt);
															$
																.each(
																	data,
																	function(
																		i,
																		item) {
																		var option = $(
																				"<option></option>")
																			.attr(
																				"value",
																				item.id)
																			.html(
																				item.courseName);
																		select
																			.append(option);
																	});
														}, "json");

												//
												$("#courses1${smd.id }")
													.change(
														function() {
															$("#catagory1${smd.id }")
																.empty();
															var opt = $(
																	"<option></option>")
																.attr(
																	"value",
																	"")
																.html(
																	"--不限--");
															$("#catagory1${smd.id }")
																.append(
																	opt);

															var courseId = $(
																	this)
																.val();
															$
																.get(
																	"admin/loadTechCategorys", {
																		"courseId": courseId
																	},
																	function(
																		data) {
																		var select = $("#catagory1${smd.id }");
																		$
																			.each(
																				data,
																				function(
																					i,
																					item) {
																					var option = $(
																							"<option></option>")
																						.attr(
																							"value",
																							item.id)
																						.html(
																							item.techCtgr);
																					select
																						.append(option);
																				});
																	},
																	"json");
														});
											</script>

											<form action="admin/uptMulchoi?id=${smd.id }" method="post">
												<div class="modal-body">
													<div class="input-group">
														<span class="input-group-addon" id="sizing-addon1">课程：<br><br>知识点：</span>
														<input name="id" value="${smd.id }" style="display: none">
														<!-- <select id="catagory" class="form-control m-b"
														name="tCategory.courses.id">
														tCategory.courses.id
														<option>1</option>
														<option>2</option>
														<option>3</option>
													</select> <select class="form-control m-b" name="techCateId">
														tCategory.id
														不能传1,没有父关键字
														<option>2</option>
														<option>3</option>
													</select> -->

														<strong></strong>
														<select class="form-control m-b" id="courses1${smd.id }" name="tCategory.courses.id" style="width: 80">
														</select> <strong></strong>
														<select class="form-control m-b" id="catagory1${smd.id }" name="techCateId" style="width: 80">
														</select>
													</div>
													<div class="input-group" style="margin-top: 15px">
														<span class="input-group-addon" id="sizing-addon1">多选题题干</span>
														<input type="text" name="question" value="${smd.question }" class="form-control" name="againPwd" aria-describedby="sizing-addon1">
													</div>
													<div class="input-group" style="margin-top: 15px">
														<span class="input-group-addon" id="sizing-addon1">A</span>
														<textarea name="options.optionA" placeholder="请输入选项 A" cols="65" rows="" id="optionA" class="form-control">${smd.options.optionA }</textarea>
														<span class="input-group-addon"><input
														type="checkbox" value="A" name="correct"> </span>
													</div>
													<div class="input-group" style="margin-top: 15px">
														<span class="input-group-addon" id="sizing-addon1">B</span>
														<textarea name="options.optionB" placeholder="请输入选项 B" cols="65" rows="" id="optionB" class="form-control">${smd.options.optionB }</textarea>
														<span class="input-group-addon"><input
														type="checkbox" value="B" name="correct"> </span>
													</div>

													<div class="input-group" style="margin-top: 15px">
														<span class="input-group-addon" id="sizing-addon1">A</span>
														<textarea name="options.optionC" placeholder="请输入选项 C" cols="65" rows="" id="optionC" class="form-control">${smd.options.optionC }</textarea>
														<span class="input-group-addon"><input
														type="checkbox" value="C" name="correct"> </span>
													</div>
													<div class="input-group" style="margin-top: 15px">
														<span class="input-group-addon" id="sizing-addon1">B</span>
														<textarea name="options.optionD" placeholder="请输入选项 D" cols="65" rows="" id="optionD" class="form-control">${smd.options.optionD }</textarea>
														<span class="input-group-addon"><input
														type="checkbox" value="D" name="correct"> </span>
													</div>
													<div class="input-group" style="margin-top: 15px">
														<span class="input-group-addon" id="sizing-addon1">B</span>
														<textarea name="options.optionE" placeholder="请输入选项 E" cols="65" rows="" id="optionE" class="form-control">${smd.options.optionE }</textarea>
														<span class="input-group-addon"><input
														type="checkbox" value="E" name="correct"> </span>
													</div>

												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
													<input type="submit" class="btn btn-primary" value="确认修改">
												</div>

											</form>
										</div>
									</div>
								</div>
								<script type="text/javascript">
								</script>

							</c:forEach>

							<!-- 多选题加入到试卷 -->
							<div style="width: 20%; text-align: center;">
								<form action="admin/showQuestion" method="post">
									<div class="input-group">
										<input type="text" name="examNo" id="examNo" value="" class="form-control" placeholder="请输入试卷编号"> <span class="input-group-btn"> <input type="button"
										class="btn btn-primary" name="selExnoBtn" id="selExnoBtn"
										value="选择" onclick="selectValidExamNo()">
									</span>
									</div>
									<div id="showExnoDiv">
										<ul id="showExnoUl" style="list-style-type: none; padding-left: 0; margin-top: 15px; margin-bottom: 0"></ul>
									</div>
								</form>
							</div>
							<!-- <input type="button" id="toggle" value="展开"> -->
							全选：
							</h3>
							<label class="i-checks"> <input type="checkbox"
							id="checkAll" value="option2"></label>
							<button class="btn btn-danger" style="margin-left: 30px" onclick="addSelectSim();">批量多选题加入到试卷</button>
							<!-- <input type="checkbox" name="Submit" id="checkAll" value="全选"> -->

						</div>

					</div>
				</div>
			</div>
			<!-- 分页链拉 -->
			<div>
				<div>
					<c:if test="${not empty smdqPage1}">
						<ul class="pagination">
							<li>
								<a href="admin/selMulchoi?pageNo=1">«</a>
							</li>
							<c:if test="${smdqPage1.pageNo gt 3}">
								<li>
									<a href="javascript:void(0)">....</a>
								</li>
							</c:if>
							<c:if test="${smdqPage1.pageNo-2 ge 1}">
								<li>
									<a href="admin/selMulchoi?pageNo=${smdqPage1.pageNo-2}">${smdqPage1.pageNo-2}</a>
								</li>
							</c:if>
							<c:if test="${smdqPage1.pageNo-1 ge 1}">
								<li>
									<a href="admin/selMulchoi?pageNo=${smdqPage1.pageNo-1}">${smdqPage1.pageNo-1}</a>
								</li>
							</c:if>
							<li class="active">
								<a href="admin/selMulchoi?pageNo=${smdqPage1.pageNo}">${smdqPage1.pageNo}</a>
							</li>
							<c:if test="${smdqPage1.pageNo+1 le smdqPage1.totalPage}">
								<li>
									<a href="admin/selMulchoi?pageNo=${smdqPage1.pageNo+1}">${smdqPage1.pageNo+1}</a>
								</li>
							</c:if>
							<c:if test="${smdqPage1.pageNo+2 le smdqPage1.totalPage}">
								<li>
									<a href="admin/selMulchoi?pageNo=${smdqPage1.pageNo+2}">${smdqPage1.pageNo+2}</a>
								</li>
							</c:if>
							<c:if test="${smdqPage1.pageNo+2 lt smdqPage1.totalPage}">
								<li>
									<a href="javascript:void(0)">....</a>
								</li>
							</c:if>
							<li>
								<a href="admin/selMulchoi?pageNo=${smdqPage1.totalPage}">»</a>
							</li>
						</ul>
					</c:if>
				</div>
			</div>

			</form>
		</div>
		<!-- 主要内容结束主要内容结束主要内容结束主要内容结束主要内容结束主要内容结束 -->

		<div id="right-sidebar">
			<div class="sidebar-container">
				<ul class="nav nav-tabs navs-3">
					<li class="active">
						<a data-toggle="tab" href="#tab-1">Notes
						</a>
					</li>
					<li>
						<a data-toggle="tab" href="#tab-2"> Projects </a>
					</li>
					<li>
						<a data-toggle="tab" href="#tab-3"> Projects </a>
					</li>
				</ul>
			</div>
		</div>
		</div>
	</body>

</html>