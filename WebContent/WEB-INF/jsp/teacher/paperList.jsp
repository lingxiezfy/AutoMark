<%@ page language="java" pageEncoding="utf-8"%>
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

		<header id="header">
			<nav class="navbar navbar-inverse navbar-fixed-top my-nav-buttom">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-li" aria-expanded="false" aria-controls="navbar">
			            	<span class="sr-only">Toggle navigation</span>
			            	<span class="icon-bar"></span>
			            	<span class="icon-bar"></span>
			            	<span class="icon-bar"></span>
		          		</button>
					<a class="navbar-brand" href="#">程序题智能批改</a>
					<p class="navbar-text">教师批阅系统</p>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="navbar-li">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown my-nav-dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">姓名 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">注销</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</nav>
		</header>

		<div class="container-fluid my-container-margin">
			<div class="row">
				<!--
                	侧边栏导航
                -->
				<div class="col-sm-3 col-md-2 sidebar">
					<ul class="sidebar-menu">
						<li class="treeview">
							<a href="teacher.html">
								<i class="fa fa-dashboard"></i>
								<span>程序题库管理</span>
							</a>
						</li>

						<li class="treeview">
							<a href="paperList.html">
								<i class="fa fa-files-o"></i>
								<span>试卷管理</span>
							</a>
						</li>
						<li class="treeview">
							<a href="#">
								<i class="fa fa-pie-chart"></i>
								<span>平时测验管理</span>
								<i class="glyphicon glyphicon-chevron-left pull-right"></i>
							</a>
							<ul class="treeview-menu">
								<li>
									<a href="#"><i class="fa fa-circle-o"></i> 发布测验</a>
								</li>
							</ul>
						</li>
						<li class="treeview">
							<a href="#">
								<i class="fa fa-laptop"></i>
								<span>评估统考管理</span>
								<i class="glyphicon glyphicon-chevron-left pull-right"></i>
							</a>
							<ul class="treeview-menu">
								<li>
									<a href="#"><i class="fa fa-circle-o"></i>发布统考</a>
								</li>
							</ul>
						</li>
						<li class="treeview">
							<a href="#">
								<i class="fa fa-edit"></i> <span>成绩统计</span>
							</a>
						</li>
					</ul>

				</div>

				<!--
					主体内容
				-->
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<h2 class="sub-header clearfix">
						<span class="pull-left">试卷管理</span>
						<button 
							type="button" 
							class="btn btn-info pull-right"
							data-target= "#modelAddPaper"
							data-toggle="modal"
							>增加试卷</button>
						
						<div class="my-center-block">
							<form class="form-inline my-select-input-min">
								<input type="text" class="form-control" placeholder="输入标题搜索">
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
								<tr>
									<td>试卷1</td>
									<td>100</td>
									<td>王老师</td>
									<td>公开</td>
									<td>
										<button type="button" class="btn btn-primary btn-xs">查看</button>
									</td>
								</tr>
								<tr>
									<td>试卷2</td>
									<td>150</td>
									<td>李老师</td>
									<td>私有</td>
									<td>
										<button type="button" class="btn btn-primary btn-xs">查看</button>
										<button type="button" class="btn btn-primary btn-xs" data-target="#myModal" data-toggle="modal">删除</button>
										<button type="button" class="btn btn-primary btn-xs" data-target="#modelPaperSelect" data-toggle="modal">选题</button>
										<button type="button" class="btn btn-primary btn-xs">更改权限</button>
									</td>
								</tr>
							</tbody>
						</table>
						<nav class="my-center-block" aria-label="Page navigation">
							<ul class="pagination">
								<li>
									<a href="#" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
									</a>
								</li>
								<li>
									<a href="#">...</a>
								</li>
								<li class="active">
									<a href="#">3</a>
								</li>

								<li>
									<a href="#">4</a>
								</li>
								<li>
									<a href="#">5</a>
								</li>
								<li>
									<a href="#">...</a>
								</li>
								<li>
									<a href="#" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel1">删除提示</h4>
					</div>
					<div class="modal-body">
						是否确认删除？
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary">确认</button>
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
						<form class="form-horizontal">

							<div class="form-group">
								<label for="title" class="col-sm-2 control-label">试卷名</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="title" name="title" placeholder="输入试卷名称">
								</div>
							</div>
							<div class="form-group">
								<label for="readGrant" class="col-sm-2 control-label">总分</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="totalscore" name="totalscore" placeholder="请输入总分">
								</div>
							</div>
							<div class="form-group">
								<label for="readGrant" class="col-sm-2 control-label">浏览权限</label>
								<div class="col-sm-4">
									<select id="readGrant" class="form-control">
										<option value="1">私有</option>
										<option value="2">公开</option>
									</select>
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

		<!-- Modal -->
		<div class="modal fade bs-example-modal-lg" id="modelPaperSelect" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel3">试卷2</h4>
						<p>
							总分：<strong>150</strong>&nbsp;
							当前：<strong>0</strong>
						</p>
					</div>
					<div class="modal-body">
						<form class="form-horizontal">
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
		<script src="<%=request.getContextPath() %>/resources/js/jquery-3.2.1.min.js"></script>
		<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
		<script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/sidebar-menu.js"></script>

		<script type="application/javascript">
			$.sidebarMenu($('.sidebar-menu'))
		</script>

	</body>

</html>