<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>学生首页</title>

		<!-- Bootstrap -->
		<link href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" rel="stylesheet">
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
		<div class="container my-container-margin">
			<div class="page-header">
				<h1>评估统考  </h1>
			</div>
			<div>
				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
					
					<c:set var="accessSize" value="0"></c:set>
					<c:forEach items="${examInfoList}" var="item">
					<c:if test="${item.examDo.exam.type==2}">
					<c:set var="accessSize" value="${accessSize+1}"></c:set>
					<c:set var="nowDate" value="<%=System.currentTimeMillis()%>"></c:set> 
					
					<c:choose>
						<c:when test="${nowDate < item.examDo.exam.startTime.time}">
							<c:set var="paneStatus" value="panel-success"></c:set>
							<c:set var="accessStatus" value="（未开始）"></c:set>
							<c:set var="disabled" value="my-disabled"></c:set>
							<c:set var="gly" value="glyphicon glyphicon-ban-circle"></c:set>
						</c:when>
						<c:when test="${nowDate >= item.examDo.exam.startTime.time && nowDate <= item.examDo.exam.endTime.time}">
							<c:set var="paneStatus" value="panel-danger"></c:set>
							<c:set var="accessStatus" value="（正在考试）"></c:set>
							<c:set var="disabled" value=""></c:set>
							<c:set var="gly" value="glyphicon glyphicon-ok-circle"></c:set>
						</c:when>
						<c:when test="${nowDate >= item.examDo.exam.endTime.time}">
							<c:set var="paneStatus" value="panel-success"></c:set>
							<c:set var="accessStatus" value="（已结束）"></c:set>
							<c:set var="disabled" value="my-disabled"></c:set>
							<c:set var="gly" value="glyphicon glyphicon-remove-circle"></c:set>
						</c:when>
					</c:choose>
					<!-- 统考列表 -->
					<div class="panel ${paneStatus}">
						<div class="panel-heading" role="tab">
							<h3 class="panel-title">
						        <a class="center-block ${disabled}" 
						        	role="button" 
						        	href="<%=request.getContextPath() %>/exam/do?edid=${item.examDo.edid}&nowstatus=${item.examDo.nowstatus}">
						        	<span class="glyphicon glyphicon-education "></span>
						        	<span class="my-title-length ">${item.examDo.exam.title}</span>  
						        	<span class="my-date-length"><fmt:formatDate value="${item.examDo.exam.startTime }" type="date"/></span>
						        	<span class="my-time-length"><fmt:formatDate value="${item.examDo.exam.startTime }" type="time"/></span>
						        	<span class="my-line-length">-</span>
						        	<span class="my-time-length"><fmt:formatDate value="${item.examDo.exam.endTime }" type="time"/></span>
						        	<span class="${gly } pull-right"></span>
						        	<span>${accessStatus} </span>
						        </a>
     						</h3>
						</div>
					</div>
					</c:if>
					</c:forEach>
				</div>
				<c:if test="${accessSize == 0}">
				<div class="alert alert-info" role="alert">
					<span class="alert-link">暂无</span>
				</div>
				</c:if>
			</div>
		</div>

		<div class="container ">
			<div class="page-header my-page-header">
				<h1>平时测验 </h1>
			</div>
			<div>
				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
					<!--
                    	老师-课程列表
                    	单个课程开始
                    -->
					
					<c:set var="tids" value="0"></c:set>
					<c:forEach items="${examInfoList}" var="item">
					<c:if test="${item.teach != null}">
					<c:set var="arrs" value="${fn:split(tids, ',')}"></c:set>
					<c:set var="temp" value="0"></c:set>
					<c:forEach items="${arrs}" var="arr">
						<c:if test="${arr==item.teach.tid}">
							<c:set var="temp" value="1"></c:set>
						</c:if>
					</c:forEach>
					<c:if test="${temp==0 }">
						<c:set var="nowTid" value="${item.teach.tid}"></c:set>
						<c:set var="tids" value="${tids},${nowTid}"></c:set>
						<div class="panel panel-success">
							<div class="panel-heading" role="tab" id="heading${nowTid}">
								<h3 class="panel-title">
							        <a class="center-block" 
							        	role="button" 
							        	data-toggle="collapse" 
							        	aria-expanded="true" 
							        	data-parent="#accordion" 
							        	href="#collapse${nowTid}" 
							        	aria-controls="collapse${nowTid}">
							        	<span class="glyphicon glyphicon-th-large"></span>
							        	  ${item.examDo.exam.examTeacher.name} - ${item.teach.course}
							        	
							        	<c:set var="tempCount" value="0"></c:set>
							        	<c:forEach items="${examInfoList}" var="item">
	                                    <c:if test="${item.teach != null && item.teach.tid==nowTid}">
	                                    	<c:set var="tempCount" value="${tempCount+1 }"></c:set>
	                                    </c:if>
	                                    </c:forEach>
							        	<span class="label label-primary pull-right">${tempCount}</span>
							        </a>
	     						</h3>
							</div>
							<div id="collapse${nowTid}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading${nowTid}">
								<div class="panel-body my-panel-list">
									<div class="container">
										<!--
	                                    	平时测试的列表
	                                    -->
	                                    <c:forEach items="${examInfoList}" var="item">
	                                    <c:if test="${item.teach != null && item.teach.tid==nowTid}">
	                                    <c:choose>
	                                    	<c:when test="${nowDate < item.examDo.exam.startTime.time}">
	                                    		<c:set var="testStatus" value="未开始"></c:set>
	                                    		<c:set var="grade" value="未开始"></c:set>
	                                    		<c:set var="disabled" value="disabled"></c:set>
	                                    	</c:when>
	                                    	<c:when test="${nowDate >= item.examDo.exam.startTime.time && nowDate <= item.examDo.exam.endTime.time}">
		                                    	<c:choose>
			                                    	<c:when test="${item.examDo.nowstatus==0}">
			                                    		<c:set var="testStatus" value="未提交"></c:set>
			                                    	</c:when>
			                                    	<c:when test="${item.examDo.nowstatus>0}">
			                                    		<c:set var="testStatus" value="未完成"></c:set>
			                                    	</c:when>
			                                    	<c:when test="${item.examDo.nowstatus<0}">
			                                    		<c:set var="testStatus" value="可修改"></c:set>
			                                    	</c:when>
		                                    	</c:choose>
		                                    	<c:set var="grade" value="继续测试"></c:set>
		                                    	<c:set var="disabled" value=""></c:set>
	                                    	</c:when>
	                                    	<c:when test="${nowDate >= item.examDo.exam.endTime.time}">
	                                    		<c:set var="disabled" value="disabled"></c:set>
	                                    		<c:set var="testStatus" value="待批阅"></c:set>
		                                    	<c:set var="grade" value="等待批阅"></c:set>
		                                    	<c:if test="${item.examDo.nowstatus==-2}">
		                                    		<c:set var="testStatus" value="完成"></c:set>
		                                    		<c:set var="grade" value="${item.examDo.totalgrade}"></c:set>
		                                    	</c:if>
	                                    	</c:when>
	                                    </c:choose>
	                                    
	                                    <div class="panel panel-info">
											<div class="panel-body">
												<h4><strong>${item.examDo.exam.title}</strong></h4>
												<h5>开始时间：&nbsp;<span><fmt:formatDate value="${item.examDo.exam.startTime }" type="both"/></span></h5>
												<h5>截止时间：&nbsp;<span><fmt:formatDate value="${item.examDo.exam.endTime }" type="both"/></span></h5>
												<h5>测试状态：&nbsp;<span> ${testStatus} </span></h5>
											</div>
											<div class="panel-footer my-panel-footer">
												<span class="btn-block pull-right">
													<span class="pull-left my-grade"><strong> ${grade} </strong></span>
													<a href="<%=request.getContextPath() %>/exam/do?edid=${item.examDo.edid}&nowstatus=${item.examDo.nowstatus}" class="btn btn-success pull-right ${disabled}" role="button">查看</a>
												</span>
											</div>
										</div>
	                                    </c:if>
	                                    </c:forEach>
	                                    <!--平时测试列表结束-->
									</div>
								</div>
							</div>
						</div>
					</c:if>
					</c:if>
					</c:forEach>
					<!-- 单个课程结束 -->
					
				</div>
			</div>
		</div>

		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
		<script src="<%=request.getContextPath() %>/resources/js/jquery-3.2.1.min.js"></script>
		<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
		<script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>

		<script type="application/javascript">
		</script>

	</body>

</html>