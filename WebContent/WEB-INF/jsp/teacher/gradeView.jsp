<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>成绩统计</title>

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

					<h2 class="sub-header">
						成绩统计
						<button type="button" class="btn btn-primary pull-right">预览</button>
					</h2>
					<div class="container-fluid">
						<form class="form-horizontal">
							<div class="form-group">
								<label for="readGrant" class="col-sm-2 control-label">总分</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="title" name="title">
								</div>
							</div>
							<div class="form-group">
								<label for="readGrant" class="col-sm-2 control-label">班级</label>
								<div class="col-sm-4">
									<select id="readGrant" class="form-control">
										<option value="0">请选择班级</option>
										<option value="1">152012</option>
										<option value="2">152011</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="readGrant" class="col-sm-2 control-label">选择参与统计的测试</label>
								<div id="" class="col-sm-10">
									<div class="col-sm-5">
										<div class="checkbox">
											<label>
          									<input type="checkbox" checked="true" value="1"> 
          									<span>平时测试1</span>  
										</label>
										</div>
									</div>
									<div class="col-sm-3">
										<input type="text" class="form-control" id="title" name="title" placeholder="输入所占比值">
									</div>
									<div class="col-sm-8">
										<div class="checkbox">
											<label>
          									<input type="checkbox" checked="false" value="1"> 
          									<span>平时测试1</span>  
										</label>
										</div>
									</div>
									<div class="col-sm-5">
										<div class="checkbox">
											<label>
          									<input type="checkbox" checked="true" value="1"> 
          									<span>统考1</span>  
										</label>
										</div>
									</div>
									<div class="col-sm-3">
										<input type="text" class="form-control" id="title" name="title" placeholder="输入所占比值">
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">自定义项</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="title" name="title" placeholder="名称">
								</div>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="title" name="title" placeholder="比值">
								</div>
								<div class="col-sm-2">
									<button type="submit" class="btn btn-primary">
										<span class="glyphicon glyphicon-plus-sign"></span>
									</button>
								</div>
							</div>
						</form>
					</div>

					<h2 class="sub-header">
						成绩单预览
						<button type="button" class="btn btn-info pull-right">下载</button>
					</h2>
					<div class="container-fluid">
						<div class="alert alert-info" role="alert">
							<span class="alert-link">暂无</span>
						</div>
					</div>
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>学号</th>
									<th>姓名</th>
									<th>班级</th>
									<th>统考1</th>
									<th>统考2</th>
									<th>平时测试1</th>
									<th>平时测试3</th>
									<th>自定义1</th>
									<th>自定义2</th>
									<th>总分</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>15201229</td>
									<td>张凤育</td>
									<td>152012</td>
									<td>100</td>
									<td>100</td>
									<td>100</td>
									<td>100</td>
									<td>100</td>
									<td>100</td>
									<td>100</td>
								</tr>
							</tbody>
						</table>
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