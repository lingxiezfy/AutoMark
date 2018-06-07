<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>教师首页</title>

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
						<span class="pull-left">程序题库</span>
						<a type="button" href="<%=request.getContextPath() %>/question/edit" class="btn btn-info pull-right">添加题目</a>
						
						<div class="my-center-block">
							<form class="form-inline my-select-input-min" action="" id="searchform">
								<select id="questionType" name="qtid" class="form-control">
									<option value="0">题目类别</option>
									<option value="1">jdbc</option>
									<option value="2">html</option>
									<option value="3">算法设计</option>
								</select>
								
								<select id="readgrant" name="readgrant" class="form-control">
									<option value="0">选择权限</option>
									<option value="1">私有</option>
									<option value="2">公开</option>
								</select>
								
								<input type="text" class="form-control" name="key" placeholder="输入标题搜索" value="${key}">
								<button type="submit" class="btn btn-default">搜索</button>
							</form>
						</div>
						
					</h2>
					<div class="table-responsive">
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th class="my-table-title-width-long">标题</th>
									<th>类型</th>
									<th>出题教师</th>
									<th>权限</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${questionList}" var="item">
								<tr>
									<td>${item.title }</td>
									<td>${item.qType.qtName }</td>
									<td>${item.user.name }</td>
									<td>
									<c:choose>
									<c:when test="${item.readGrant==1 }">
									私有
									</c:when>
									<c:when test="${item.readGrant==2 }">
									公开
									</c:when>
									</c:choose>
									</td>
									<td>
										<a type="button" href="<%=request.getContextPath() %>/question/edit?qid=${item.qid }" class="btn btn-primary btn-xs">查看</a>
									<c:if test="${item.user.uid==user.uid }">
										<a  
											type="button" 
											class="btn btn-primary btn-xs" 
											onclick="del_pop(${item.qid })"
											>删除</a>
										<a type="button" href="<%=request.getContextPath() %>/question/edit?qid=${item.qid }" class="btn btn-primary btn-xs">修改</a>
										<a type="button" onclick="modReadgrant_pop(${item.qid },${item.readGrant })" class="btn btn-primary btn-xs">更改权限</a>
									</c:if>
									</td>
								</tr>
								</c:forEach>
								<!-- 
								data-target= "#myModal"
											data-toggle="modal"
								 -->
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

		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
		<script src="<%=request.getContextPath() %>/resources/js/jquery-3.2.1.min.js"></script>
		<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
		<script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/sidebar-menu.js"></script>

		<script type="text/javascript">
			$.sidebarMenu($('.sidebar-menu'));
			
			function goPage(page) {
				window.location.href="<%=request.getContextPath() %>/question/teacher?"+$('#searchform').serialize()+"&currPage="+page;
			}
			$('#questionType').val( ${qtid});
			$('#readgrant').val( ${readgrant});
			
			$('#refusebtn').click(function() {
				$('#myModal').modal('fide');
			});
			function del_pop(id){
				$('#myModal').modal('show');
				$('#confirbtn').click(function(){
					del(id);
				});
			}
			function del(id){
				$.ajax({
					url:"<%=request.getContextPath() %>/json/question/delete",
					type:"POST",
					async:false,
					data: "qid="+id+"",
					dataType:"json",
					success:function(data){
						$('#msg').html(data.msg);
						window.location.href="<%=request.getContextPath() %>/question/teacher?"+$('#searchform').serialize()+"&currPage=${currPage}" ;
					},
					error:function(){
						$('#msg').html("操作失败！请重试");
					}
				})
			}
			function modReadgrant_pop(qid,readgrant){
				$('#myModal').modal('show');
				$('#confirbtn').click(function(){
					modReadgrant(qid,readgrant);
				});
			}
			function modReadgrant(qid,readgrant){
				$.ajax({
					url:"<%=request.getContextPath() %>/json/question/readGrant/update",
					type:"POST",
					async:false,
					data: "qid="+qid+"&readGrant="+readgrant,
					dataType:"json",
					success:function(data){
						$('#msg').html(data.msg);
						window.location.href="<%=request.getContextPath() %>/question/teacher?"+$('#searchform').serialize()+"&currPage=${currPage}" ;
					},
					error:function(){
						$('#msg').html("操作失败！请重试");
					}
				})
			}
		</script>
	</body>

</html>