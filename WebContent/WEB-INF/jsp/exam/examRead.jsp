<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>在线答题</title>

		<!-- Bootstrap -->
		<link href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" rel="stylesheet">
		<!-- 引入codemirror-->

		<!-- codemirror核心 -->
		<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/codemirror/lib/codemirror.css" />
		<script type="text/javascript" src="<%=request.getContextPath() %>/resources/codemirror/lib/codemirror.js"></script>
		<!-- 引入java，C，C++代码支持 -->
		<script type="text/javascript" src="<%=request.getContextPath() %>/resources/codemirror/model/clike.js"></script>
		<!-- 引入CSS支持 -->
		<script type="text/javascript" src="<%=request.getContextPath() %>/resources/codemirror/model/css.js"></script>
		<!-- 引入javaScript支持 -->
		<script type="text/javascript" src="<%=request.getContextPath() %>/resources/codemirror/model/javascript.js"></script>
		<!-- 引入HTML支持 -->
		<script type="text/javascript" src="<%=request.getContextPath() %>/resources/codemirror/model/xml.js"></script>

		<!--引入eclipse主题-->
		<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/codemirror/theme/eclipse.css" />

		<!--CodeMirror 引入结束-->

		<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/style.css" />

		<style type="text/css">
			.CodeMirror {
				border: 1px solid black;
				font- size: 15px;
				width: 100%;
				height: 300px
			}
		</style>
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

		<div class="container">
			<div class="page-header">
				<h1>
					<span>2017-2018学年上学期数据结构期末考试A卷</span>
					(<span>18201522-张三</span>)
					<div class="pull-right">
						<button type="button" class="btn btn-primary">返回</button>
					</div>
				</h1>
			</div>
			<div class="my-nav-buttom clearfix">
				<input type="hidden" name="upIndex" id="upIndex" value="-1" />
				<input type="hidden" name="nowIndex" id="nowIndex" value="0" />
				<input type="hidden" name="nextIndex" id="nextIndex" value="1" />
				<button type="button" class="btn btn-default disabled pull-left">上一题</button>
				<button type="button" class="btn btn-default disabled pull-right">下一题</button>
				<div class=" my-center-block">
					<span>1</span>
					/
					<span>20</span>
				</div>
				
			</div>
			<div class="container-fluid clearfix">
				<div class="row">
					<div class="col-lg-12">
						<h4>题目标题</h4>
						<div>题目描述</div>
					</div>
				</div>
				<div class="row my-code-content">
				<div class="col-lg-5">
					<form>
						<div class="form-group">
							<label>学生提交：</label>
							<select disabled="disabled">
								<option value="0">html</option>
								<option value="1">java</option>
								<option value="2">jsp</option>
								<option value="3">javascript</option>
								<option value="0">C</option>
								<option value="0">C++</option>
							</select>
						</div>

						<div class="form-group">
							<textarea id="stuanswer" name="stuanswer"></textarea>
						</div>
						<button type="submit" class="btn btn-success">上一位同学</button>
						<button type="submit" class="btn btn-warning">下一位同学</button>
					</form>
				</div>
				<div class="col-lg-7">
					<form>
						<div class="form-group">
							<label>批阅结果：</label>
						</div>

						<div class="form-group my-disabled">
							<textarea id="result" name="result"></textarea>
						</div>
						<div class="form-group">
							<label for="readGrant" class="col-sm-2 control-label">批阅得分</label>
							<div class="col-sm-2">
								<input 
									type="text" 
									class="form-control" 
									id="totalscore" 
									name="totalscore" 
									value="80"
									disabled="disabled">
							</div>
							<label for="readGrant" class="col-sm-2 control-label">教师评分</label>
							<div class="col-sm-2">
								<input 
									type="text" 
									class="form-control" 
									id="totalscore" 
									name="totalscore" 
									value="80">
							</div>
							<button type="submit" class="btn btn-primary">确认</button>
						</div>
					</form>
				</div>
				</div>
			</div>

		</div>

		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
		<script src="<%=request.getContextPath() %>/resources/js/jquery-3.2.1.min.js"></script>
		<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
		<script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>

		<script type="application/javascript">
			var editor = CodeMirror.fromTextArea(document.getElementById("stuanswer"), {
				
				mode: "text/x-csrc",
				mode: "text/x-c++src",
				mode: "text/css",
				mode: "text/javascript",
				mode: "text/html",
				mode: "text/x-java",
				lineNumbers: true,
				theme: "eclipse"
			});

			var result = CodeMirror.fromTextArea(document.getElementById("result"), {
				mode: "text/html",
				lineNumbers: true,
				theme: "eclipse"
			});
		</script>

	</body>

</html>