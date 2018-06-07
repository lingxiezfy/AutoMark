<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>平时测试</title>

<!-- Bootstrap -->
<link
	href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/resources/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/resources/css/sidebar-menu.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/resources/css/style.css" />
<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<c:import url="header.jsp"></c:import>

	<div class="container-fluid my-container-margin">
		<div class="row">
			<!--
                	侧边栏导航
                -->
			<c:import url="sidebar.jsp"></c:import>

			<!--
					主体内容
				-->
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h2 class="sub-header clearfix">
					<span class="pull-left">平时测试</span> <a type="button"
						class="btn btn-info pull-right" onclick="edit_pop(0)">发布统考</a>
				</h2>
				<div class="table-responsive">
					<div class="panel-group" id="accordion" role="tablist"
						aria-multiselectable="true">

						<!-- 班级-课程 列表-->
						<div class="panel panel-success">
							<div class="panel-heading" role="tab" id="headingOne">
								<h3 class="panel-title">

									<a class="center-block" role="button" data-toggle="collapse"
										aria-expanded="true" data-parent="#accordion"
										href="#collapseOne" aria-controls="collapseOne"> <span
										class="glyphicon glyphicon-th-large"></span> 152012班-web高级编程
									</a>

								</h3>
							</div>
							<div id="collapseOne" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingOne">
								<div class="panel-body my-panel-list">
									<div class="container">
										<!--
                                    		平时测试的列表
                                   			 -->
										<div class="panel panel-info">
											<div class="panel-body">
												<h4>
													<strong>第一次作业</strong>
												</h4>
												<h5>
													开始时间：&nbsp;<span>2017-12-13 15:03</span>
												</h5>
												<h5>
													截止时间：&nbsp;<span>2017-12-13 15:03</span>
												</h5>
												<h5>
													使用试卷：&nbsp;<span>试卷1试卷1试卷1试卷...</span>
												</h5>
											</div>
											<div class="panel-footer my-panel-footer">
												<span class="btn-block pull-right"> <span
													class="pull-left my-grade"><strong>4/33</strong></span> <a
													href="#" class="btn btn-danger pull-right" role="button"
													data-target="#delModel" data-toggle="modal">删除</a>
													<a href="#" class="btn btn-success pull-right"
													role="button" data-target="#modelExamMod"
													data-toggle="modal">修改</a> <a href="#"
													class="btn btn-primary pull-right" role="button">批阅</a>
												</span>
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>

					</div>

				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">提示</h4>
				</div>
				<div class="modal-body">是否确认操作？</div>
				<div class="modal-footer">
					<b id="msg"></b>
					<button id="refusebtn" type="button" class="btn btn-default"
						data-dismiss="modal">取消</button>
					<button id="confirbtn" type="button" class="btn btn-primary">确认</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="edit_exam" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel2">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel2">发布测试</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="edit_form">
						<input type="hidden" name="eid" value="0" />
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label">测试名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="title" name="title"
									placeholder="输入测试名称">
							</div>
						</div>
						<div class="form-group">
							<label for="examtype" class="col-sm-2 control-label">测试类型</label>
							<div class="col-sm-4">
								<select id="examtype" class="form-control" disabled="disabled"
									name="type">
									<option value="1">平时测试</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="paperList" class="col-sm-2 control-label">选择试卷</label>
							<div class="col-sm-4">
								<select id="paperList" class="form-control" name="pid">
									<option value="0">请选择</option>
									<option value="1">试卷1</option>
									<option value="2">试卷2</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="classes" class="col-sm-2 control-label">选择班级</label>
							<div class="col-sm-5">
								<div class="checkbox" id="classes">
								<c:forEach items="teaches" var="item">
									<label><input type="checkbox" name="tids" value="${item.classes.cid }"><span>${item.classes.name }</span></label>
								</c:forEach>
								</div>
							</div>
							<div class="col-sm-4">
								<button type="button" id="classes_find" class="btn btn-success">获取全部班级</button>
							</div>
						</div>
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label">开始时间</label>
							<div class="col-sm-4">
								<input type="datetime" class="form-control" id="startTime"
									name="startTime">
							</div>
						</div>
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label">截止时间</label>
							<div class="col-sm-4">
								<input type="datetime" class="form-control" id="endTime"
									name="endTime">
							</div>
						</div>

					</form>

				</div>
				<div class="modal-footer">
					<div>
						<span class="pull-left text-danger" id="edit_msg"></span>
					</div>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" id="edit_save" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="modelExamMod" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel2">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel2">修改测试信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">

						<div class="form-group">
							<label for="title" class="col-sm-2 control-label">测试名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="title" name="title"
									placeholder="输入测试名称">
							</div>
						</div>
						<div class="form-group">
							<label for="readGrant" class="col-sm-2 control-label">测试类型</label>
							<div class="col-sm-4">
								<select id="readGrant" class="form-control" disabled="disabled">
									<option value="1">平时测试</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="readGrant" class="col-sm-2 control-label">选择试卷</label>
							<div class="col-sm-4">
								<select id="readGrant" class="form-control">
									<option value="0">请选择</option>
									<option value="1">试卷1</option>
									<option value="2">试卷2</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label">开始时间</label>
							<div class="col-sm-4">
								<input type="datetime" class="form-control" id="starttime"
									name="starttime">
							</div>
						</div>
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label">截止时间</label>
							<div class="col-sm-4">
								<input type="datetime" class="form-control" id="endtime"
									name="endtime">
							</div>
						</div>

					</form>

				</div>
				<div class="modal-footer">
					<div>
						<span class="pull-left text-danger">错误信息</span>
					</div>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>




	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script
		src="<%=request.getContextPath() %>/resources/js/jquery-3.2.1.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script
		src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath() %>/resources/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/resources/js/bootstrap-datetimepicker.zh-CN.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/resources/js/sidebar-menu.js"></script>

	<script type="application/javascript">
			$.sidebarMenu($('.sidebar-menu'));
			$.fn.datetimepicker.defaults = {
				//默认语言
				language: 'zh-CN',
				//默认选择格式
				format: "yyyy-mm-dd hh:ii:ss",
				autoclose: true,
				todayBtn: true,
				//选择板所在输入框位置
				pickerPosition: "bottom-left"
			};
			
			$('#paperList').focus(function() {
				$.ajax({
					url:"<%=request.getContextPath() %>/json/paper/find",
					type:"POST",
					dataType:"json",
					success:function(data){
						$('#paperList option').remove();
						$('#paperList').append("<option value='0'>请选择</option>");
						for(var i=0;i<data.length;i++){
							$('#paperList').append("<option value='"+data[i].pid+"'>"+data[i].title+"</option>");
						}
					},
					error:function(){
						$('#edit_msg').html("操作失败！请重试");
					}
				})
			});
			
			$('#classes_find').click(function() {
				$.ajax({
					url:"<%=request.getContextPath() %>/json/classes",
					type:"POST",
					dataType:"json",
					success:function(data){
						var str = "";
						$('#classes').html(str);
						for(var i=0;i<data.length;i++){
							str+="<label><input type='checkbox' name='cids' value='"+data[i].cid+"'> <span>"+data[i].name+"</span></label>";
						}
						$('#classes').html(str);
					},
					error:function(){
						$('#edit_msg').html("操作失败！请重试");
					}
				})
				return false;
			});
			
			$('#edit_save').click(function() {
				$.ajax({
					url:"<%=request.getContextPath() %>/json/exam/save",
					type:"get",
					async:false,
					data: $('#edit_form').serialize(),
					dataType:"json",
					success:function(data){
						$('#edit_msg').html("操作成功！");
						window.location.reload();
					},
					error:function(){
						$('#edit_msg').html("操作失败！请重试");
					}
				})
			});
			
			function edit_pop(eid) {
				$('#edit_exam').modal('show');
			}
			
			function del_pop(id){
				$('#myModal').modal('show');
				$('#confirbtn').click(function(){
					del(id);
				});
			}
			function del(id){
				$.ajax({
					url:"<%=request.getContextPath() %>/json/exam/access/delete",
					type:"POST",
					async:false,
					data: "eid="+id+"",
					dataType:"json",
					success:function(data){
						$('#msg').html(data.msg);
						window.location.href="<%=request.getContextPath() %>
		/exam/assess" ;
					},
					error:function(){
						$('#msg').html("操作失败！请重试");
					}
				})
			}
			
			$(function() {

				var picker1 = $('#startTime').datetimepicker();
				var picker2 = $("#endTime").datetimepicker();

				//动态设置最小值(选择前面一个日期后：后面一个日期不能小于前面一个)
				picker1.on('changeDate', function(e) {
					picker2.datetimepicker('setStartDate', e.date);
				});
				//动态设置最大值(选择后面一个日期后：前面一个日期不能大于前面一个）
				picker2.on('changeDate', function(e) {
					picker1.datetimepicker('setEndDate', e.date);
				});

			});
		
	</script>

</body>

</html>