<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
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
						<span class="pull-left"> ${action}题目</span>
					</h2>
					<div class="container-fluid">
						<!-- 表单开始 -->
						<form class="form-horizontal" id="editform" >
							<input type="hidden" name="qid" value="${question.qid }"/>
							<input type="hidden" name="uid" value="${question.uid }"/>
							<div class="form-group">
								<label for="questionType" class="col-sm-2 control-label">题目类型</label>
								<div class="col-sm-4">
									<select id="questionType" name="qtid" class="form-control">
										<option value="0">选择类别</option>
										<option value="1">jdbc</option>
										<option value="2">html</option>
										<option value="3">算法设计</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="readGrant" class="col-sm-2 control-label">浏览权限</label>
								<div class="col-sm-4">
									<select id="readgrant" name="readGrant" class="form-control">
										<option value="1">私有</option>
										<option value="2">公开</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="judgeType" class="col-sm-2 control-label">批阅方式</label>
								<div class="col-sm-4">
									<select id="judgeType" name="jtid" class="form-control">
										<option value="1">手动批阅</option>
										<option value="2">解释型</option>
										<option value="3">输入输出型</option>
									</select>
								</div>
							</div>
							<c:if test="${question.jtid == 3}">
								<c:forEach items="${answers}" var="item" varStatus="status">
								<div class="form-group">
									<input type="hidden" name="answers[${status.index }].aid" value="${item.aid }">
									<label class="col-sm-2 control-label">用例${status.index+1 }</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" id="title" name="answers[${status.index }].input" placeholder="输入" value="${item.input }">
									</div>
									<div class="col-sm-3">
										<input type="text" class="form-control" id="title" name="answers[${status.index }].output" placeholder="输出" value="${item.output }">
									</div>
									<c:choose>
										<c:when test="${(status.index+1)==fn:length(answers)}">
											<div class="col-sm-1">
												<button type="button" class="btn btn-danger ">
													<span class="glyphicon glyphicon-minus-sign"></span>
												</button>
											</div>
											<div class="col-sm-1">
												<button type="button" class="btn btn-primary ">
													<span class="glyphicon glyphicon-plus-sign"></span>
												</button>
											</div>
										</c:when>
										<c:when test="${(status.index+1)<fn:length(answers)}">
											<div class="col-sm-2">
												<button type="button" class="btn btn-danger ">
													<span class="glyphicon glyphicon-minus-sign"></span>
												</button>
											</div>
										</c:when>
									</c:choose>
								</div>
								</c:forEach>
							</c:if>
							
							<div class="form-group">
								<label for="title" class="col-sm-2 control-label">标题</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="title" name="title" placeholder="输入题目标题" value="${question.title}">
								</div>
							</div>
							<div class="form-group">
								<label for="description" class="col-sm-2 control-label">描述</label>
								<div class="col-sm-10">
									<textarea 
										class="form-control" 
										id="description"
										rows="8" 
										cols="30">
										${question.description}
									</textarea>
								</div>
							</div>
						</form>
						
						
						<div class="col-sm-offset-2 col-sm-10">
									<button id="save" class="btn btn-primary">保存</button>
									<b id="msg"></b>
								</div>
						
						<!-- 表单结束 -->
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
			
			var editor = CKEDITOR.replace('description');
			
			$('#questionType').val(${question.qtid});
			$('#readGrant').val(${question.readGrant});
			$('#judgeType').val(${question.jtid});
			
			
			$('#save').click(function(){
				
				$.ajax({
					url:"<%=request.getContextPath() %>/json/question/save",
					type:"POST",
					async:true,
					data: $("#editform").serialize()+"&description="+CKEDITOR.instances.description.getData(),
					dataType:"json",
					success:function(data){
						window.location.href='<%=request.getContextPath() %>/question/teacher';
						$('#msg').html(data.msg);
					},
					error:function(){
						$('#msg').html("增加失败");
					}
				})
			});
			
			var answerCount = "fn:length(answers)	";
			
		</script>

	</body>

</html>