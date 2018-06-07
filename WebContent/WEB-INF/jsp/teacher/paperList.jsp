<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>试卷管理</title>

		<!-- Bootstrap -->
		<link href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/sidebar-menu.css" />
		<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/style.css" />
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
						<span class="pull-left">试卷管理</span>
						<a type="button" class="btn btn-info pull-right" onclick="edit_pop(0)">增加试卷</a>
						
						<div class="my-center-block">
							<form class="form-inline my-select-input-min" action="" id="searchform">
								<input type="text" class="form-control" name="key" placeholder="输入标题搜索" value="${key }">
								<button type="submit" class="btn btn-default">搜索</button>
							</form>
						</div>
						
					</h2>
					<div class="table-responsive">
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th class="my-table-title-width-long">试卷名</th>
									<th>总分</th>
									<th>出卷教师</th>
									<th>权限</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${paperList}" var="item">
								<tr>
									<td>${item.title }</td>
									<td>${item.totalscore }</td>
									<td>${item.paperTeacher.name}</td>
									<td><c:choose>
									<c:when test="${item.readGrant==1 }">
									私有
									</c:when>
									<c:when test="${item.readGrant==2 }">
									公开
									</c:when>
									</c:choose></td>
									<td>
										<a type="button" onclick="edit_pop(${item.pid })" class="btn btn-primary btn-xs">查看</a>
										<c:if test="${item.paperTeacher.uid==user.uid }">
											<a type="button" class="btn btn-primary btn-xs" onclick="del_pop(${item.pid })" >删除</a>
											<a type="button" onclick="edit_pop(${item.pid})" class="btn btn-primary btn-xs">修改</a>
											<a type="button" onclick="select_pop(${item.pid},'${item.title}',${item.totalscore})" class="btn btn-primary btn-xs">选题</a>
											<a type="button" onclick="modReadgrant_pop(${item.pid },${item.readGrant})" class="btn btn-primary btn-xs">更改权限</a>
										</c:if>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
						<nav class="my-center-block" aria-label="Page navigation">
							<ul class="pagination">
								<c:forEach begin="1" end="${totalPage }" var="page">
								<c:set var="active" value=""></c:set>
								<c:if test="${page== currPage}">
									<c:set var="active" value="active"></c:set>
								</c:if>
								<li class="${active }">
									<a onclick="goPage(${page })"> ${page }</a>
								</li>
								</c:forEach>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">提示</h4>
					</div>
					<div class="modal-body">
						是否确认操作？
					</div>
					<div class="modal-footer">
						<b id="msg"></b>
						<button id="refusebtn" type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button id="confirbtn" type="button" class="btn btn-primary">确认</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="modelAddPaper" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel2">增加试卷</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" id="edit_form">
							<input type="hidden" id="edit_pid" name="pid" value="0"/>
							<input type="hidden" id="edit_uid" name="uid" value="0"/>
							<div class="form-group">
								<label for="edit_title" class="col-sm-2 control-label">试卷名</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="edit_title" name="title" placeholder="输入试卷名称">
								</div>
							</div>
							<div class="form-group">
								<label for="edit_totalscore" class="col-sm-2 control-label">总分</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="edit_totalscore" name="totalscore" placeholder="请输入总分">
								</div>
							</div>
							<div class="form-group">
								<label for="edit_readGrant" class="col-sm-2 control-label">浏览权限</label>
								<div class="col-sm-4">
									<select id="edit_readGrant" name="readGrant" class="form-control">
										<option value="">请选择</option>
										<option value="1">私有</option>
										<option value="2">公开</option>
									</select>
								</div>
							</div>
						</form>

					</div>
					<div class="modal-footer">
						<div>
							<span class="pull-left text-danger" id="editmsg"></span>
						</div>
						<button type="button" id="editrefuse" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" id="editconfir" class="btn btn-primary">保存</button>
					</div>
				</div>
			</div>
		</div>
		
		<!-- Modal -->
		<div class="modal fade bs-example-modal-lg" id="modelPaperSelect" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel3">试卷2</h4>
						<p>
							总分：<strong id="s_totalscore">150</strong>&nbsp;
							当前：<strong id="s_nowscore">0</strong>
						</p>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" id="select_form">
						<!--  
							<div class="form-group form-group-sm">
								<div class=" col-sm-6">
									<div class="checkbox">
										<label>
          									<input type="checkbox" checked="true" value="1"> <span>题目1</span>
        								</label>
									</div>
								</div>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="totalscore" name="totalscore" placeholder="请输入分值">
								</div>
							</div>
							<div class="form-group">
								<div class=" col-sm-6">
									<div class="checkbox">
										<label>
          									<input type="checkbox"> <span>题目2</span>
        								</label>
									</div>
									
								</div>
							</div>
							-->
						</form>
					</div>
					<div class="modal-footer">
						<div>
							<span class="pull-left text-danger" id="select_msg"></span>
						</div>
						<button type="button" id="select_refuse" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" id="select_confir" class="btn btn-primary">保存</button>
					</div>
				</div>
			</div>
		</div>
		
		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
		<script src="<%=request.getContextPath() %>/resources/js/jquery-3.2.1.min.js"></script>
		<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
		<script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/sidebar-menu.js"></script>

		<script type="application/javascript">
			$.sidebarMenu($('.sidebar-menu'));
			
			function select_pop(pid,s_title,s_totalscore) {
				$('#myModalLabel3').html(s_title);
				$('#s_totalscore').html(s_totalscore);
				//json/question/all
				$.ajax({
					url:"<%=request.getContextPath() %>/json/question/all",
					type:"POST",
					dataType:"json",
					success:function(data){
						var str="";
						$('#select_form').html(str);
						for(var i=0;i<data.length;i++){
							str+=" <div class='form-group form-group-sm'>";
							str+="<div class='col-sm-6'><div class='checkbox'><label>";
							str+="<input type='checkbox' class='slelct_item' value='"+data[i].qid+"'> <span>"+data[i].title+"</span>";
							str+="</label></div></div></div>";
							
						}
						$('#select_form').html(str);
					},
					error:function(){
						$('#select_msg').html("获取列表失败！请重试");
					}
				})
				$('.slelct_item').click(this,function() {
					if(this.checked){
						
					}
				});
				$('#modelPaperSelect').modal('show');
				$('#select_confir').click(function(){
					select(pid);
				});
			}
			function select(pid) {
				
			}
			function edit_pop(pid) {
				$('#edit_form')[0].reset();
				if(pid > 0){
					$('#myModalLabel2').html('编辑试卷');
					//获取试卷信息
					$.ajax({
						url:"<%=request.getContextPath() %>/json/paper/info",
						type:"POST",
						async:false,
						data: "pid="+pid+"",
						dataType:"json",
						success:function(data){
							$('#edit_title').val(data.title);
							$('#edit_totalscore').val(data.totalscore);
							$('#edit_readGrant').val(data.readGrant);
							$('#edit_pid').val(data.pid);
							$('#edit_uid').val(data.uid);
						},
						error:function(){
							$('#edit_title').attr('disabled', true);
							$('#edit_totalscore').attr('disabled', true);
							$('#edit_readGrant').attr('disabled', true);
							$('#edit_pid').attr('disabled', true);
							$('#edit_uid').attr('disabled', true);
							$('#editconfir').attr('disabled', true);
							$('#editmsg').html("操作失败！请重试");
						}
					})
				}else{
					$('#myModalLabel2').html('增加试卷');
				}
				$('#modelAddPaper').modal('show');
				$('#editconfir').click(function(){
					edit(pid);
				});
			}
			function edit(pid) {
				$.ajax({
					url:"<%=request.getContextPath() %>/json/paper/save",
					type:"POST",
					async:false,
					data: $('#edit_form').serialize(),
					dataType:"json",
					success:function(data){
						$('#editmsg').html(data.msg);
						$('#modelAddPaper').modal('hide');
					},
					error:function(){
						$('#editmsg').html("操作失败！请重试");
					},
					complete:function(){
						window.location.reload();
					}
				})
			}
			
			
			function goPage(page) {
				window.location.href="<%=request.getContextPath() %>/paper/list?"+$('#searchform').serialize()+"&currPage="+page;
			}
			function del_pop(id){
				$('#myModal').modal('show');
				$('#confirbtn').click(function(){
					del(id);
				});
			}
			function del(id){
				$.ajax({
					url:"<%=request.getContextPath() %>/json/paper/delete",
					type:"POST",
					async:false,
					data: "pid="+id+"",
					dataType:"json",
					success:function(data){
						$('#msg').html(data.msg);
						window.location.href="<%=request.getContextPath() %>/paper/list?"+$('#searchform').serialize()+"&currPage=${currPage}" ;
					},
					error:function(){
						$('#msg').html("操作失败！请重试");
					}
				})
			}
			function modReadgrant_pop(pid,readgrant){
				$('#myModal').modal('show');
				$('#confirbtn').click(function(){
					modReadgrant(pid,readgrant);
				});
			}
			function modReadgrant(pid,readgrant){
				$.ajax({
					url:"<%=request.getContextPath() %>/json/paper/readGrant/update",
					type:"POST",
					async:false,
					data: "pid="+pid+"&readGrant="+readgrant,
					dataType:"json",
					success:function(data){
						$('#msg').html(data.msg);
						window.location.href="<%=request.getContextPath() %>/paper/list?"+$('#searchform').serialize()+"&currPage=${currPage}" ;
					},
					error:function(){
						$('#msg').html("操作失败！请重试");
					}
				})
			}
		</script>

	</body>

</html>