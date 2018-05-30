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

		<c:import url="header.jsp"></c:import>

		<div class="container">
		<c:out value="${edid}"></c:out>
		<c:forEach items="${examInfoList}" var="item">
		<c:if test="${item.examDo.edid==edid }">
			<c:set var="nowExam" scope="session" value="${item.examDo.exam}"></c:set>
		</c:if>
		</c:forEach>
			
			<div class="page-header">
				<h1>
					<span>${nowExam.title}&nbsp;</span> 
					<div class="pull-right">
						<span class="glyphicon glyphicon-time"></span>
						<c:set var="nowDate" value="<%=System.currentTimeMillis()%>"></c:set> 
						<span id="restTime"></span>
						<button type="button" class="btn btn-primary">交卷</button>
					</div>
				</h1>
			</div>
			<div class="my-nav-buttom clearfix">
				<input type="hidden" name="upIndex" id="upIndex" value="-1" />
				<input type="hidden" name="nowIndex" id="nowIndex" value="0" />
				<input type="hidden" name="nextIndex" id="nextIndex" value="1" />
				<c:if test="${ nowstatus ==1}">
					<c:set var="upDisable" value="disabled"></c:set>
				</c:if>
				<c:if test="${ nowstatus == fn:length(edtidList)}">
					<c:set var="downDisable" value="disabled"></c:set>
				</c:if>
				<a type="button" href="<%=request.getContextPath() %>/exam/do?edid=${edid}&nowstatus=${nowstatus-1}" class="btn btn-default ${upDisable} pull-left">上一题</a>
				<a type="button" href="<%=request.getContextPath() %>/exam/do?edid=${edid}&nowstatus=${nowstatus+1}" class="btn btn-default ${downDisable} pull-right">下一题</a>
				<div class=" my-center-block">
					<span>${nowstatus }</span>
					/
					<span>${fn:length(edtidList)}</span>
				</div>
				
			</div>
			<div class="container-fluid clearfix">
				<div class="row">
					<div class="col-lg-12">
						<h4> ${examDetail.question.title}</h4>
						<div> ${examDetail.question.description}</div>
					</div>
				</div>
				<div class="row my-code-content">
				<div class="col-lg-8">
					<form>
						<input type="hidden" name="qid" value="${examDetail.question.qid}"/>
						<input type="hidden" name="qtid" value="${examDetail.question.qtid}"/>
						<input type="hidden" name="jtid" value="${examDetail.question.jtid}"/>
						<input type="hidden" name="score" value="${examDetail.score}"/>
						<div class="form-group">
							<label>选择代码：</label>
							<select name="answerType">
								<option value="1">html</option>
								<option value="2">java</option>
								<option value="3">jsp</option>
								<option value="4">javascript</option>
								<option value="5">C</option>
								<option value="6">C++</option>
							</select>
						</div>

						<div class="form-group">
							<textarea id="stuanswer" name="stuAnswer">${examDetail.examDoDetail.stuAnswer}</textarea>
						</div>
						<button id="test_btn" class="btn btn-success">测试</button>
						<button id="save_btn" class="btn btn-warning">保存</button>
					</form>
				</div>
				<div class="col-lg-4">
					<form>
						<div class="form-group">
							<label>结果查看：</label>
						</div>

						<div class="form-group my-disabled">
							<textarea id="result" >${examDetail.examDoDetail.autoResult}</textarea>
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
			
			$(function() {
				var timeMills = ${nowExam.endTime.time-nowDate};
				setInterval(function () {
					var hour = parseInt(timeMills / 1000 / 3600);
				    var minute = parseInt(timeMills / 1000 %3600/ 60);
				    var seconds = parseInt(timeMills / 1000 %3600 % 60);
				    $('#restTime').html(hour+ ":"+minute+":"+seconds);
				    timeMills = timeMills-1000;
				}, 1000);
			});
		</script>

	</body>

</html>