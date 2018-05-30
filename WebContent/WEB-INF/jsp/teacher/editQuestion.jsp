<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>添加题目</title>

		<!-- Bootstrap -->
		<link href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/sidebar-menu.css" />
		<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/style.css" />

		<!-- 引入ckeditor -->
		<script type="text/javascript" src="<%=request.getContextPath() %>/resources/ckeditor/ckeditor.js"></script>

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
						<span class="pull-left">添加题目</span>
					</h2>
					<div class="container-fluid">
						<form class="form-horizontal">
							<div class="form-group">
								<label for="questionType" class="col-sm-2 control-label">题目类型</label>
								<div class="col-sm-4">
									<select id="questionType" class="form-control">
										<option value="0">请选择</option>
										<option value="1">类别1</option>
										<option value="2">类别2</option>
										<option value="3">类别3</option>
									</select>
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
							<div class="form-group">
								<label for="judgeType" class="col-sm-2 control-label">批阅方式</label>
								<div class="col-sm-4">
									<select id="judgeType" class="form-control">
										<option value="1">手动批阅</option>
										<option value="2">解释型</option>
										<option value="3">算法</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">用例1</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="title" name="title" placeholder="输入">
								</div>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="title" name="title" placeholder="输出">
								</div>
								<div class="col-sm-2">
									<button type="submit" class="btn btn-primary">
										<span class="glyphicon glyphicon-plus-sign"></span>
									</button>
								</div>
							</div>
							<div class="form-group">
								<label for="title" class="col-sm-2 control-label">标题</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="title" name="title" placeholder="输入题目标题">
								</div>
							</div>
							<div class="form-group">
								<label for="description" class="col-sm-2 control-label">描述</label>
								<div class="col-sm-10">
									<textarea 
										class="form-control" 
										id="description" 
										name="description" 
										rows="8" 
										cols="30">
									</textarea>
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-primary">保存</button>
								</div>
							</div>
						</form>
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
						<h4 class="modal-title" id="myModalLabel">删除提示</h4>
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

		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
		<script src="<%=request.getContextPath() %>/resources/js/jquery-3.2.1.min.js"></script>
		<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
		<script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/sidebar-menu.js"></script>

		<script type="application/javascript">
			$.sidebarMenu($('.sidebar-menu'));
			
			CKEDITOR.replace('description');
		</script>

	</body>

</html>