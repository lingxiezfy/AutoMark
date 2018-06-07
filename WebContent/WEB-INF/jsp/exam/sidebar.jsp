<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="sidebar-menu">
		<li class="treeview"><a
			href="<%=request.getContextPath()%>/question/teacher"> <i
				class="fa fa-dashboard"></i> <span>程序题库管理</span>
		</a></li>

		<li class="treeview"><a
			href="<%=request.getContextPath()%>/paper/list"> <i
				class="fa fa-files-o"></i> <span>试卷管理</span>
		</a></li>
		<li class="treeview"><a href="#"> <i class="fa fa-pie-chart"></i>
				<span>平时测验管理</span> <i
				class="glyphicon glyphicon-chevron-left pull-right"></i>
		</a>
			<ul class="treeview-menu">
				<li><a href="<%=request.getContextPath()%>/exam/daliy"><i
						class="fa fa-circle-o"></i> 发布测验</a></li>
			</ul></li>
		<li class="treeview"><a href="#"> <i class="fa fa-laptop"></i>
				<span>评估统考管理</span> <i
				class="glyphicon glyphicon-chevron-left pull-right"></i>
		</a>
			<ul class="treeview-menu">
				<li><a href="<%=request.getContextPath()%>/exam/assess"><i
						class="fa fa-circle-o"></i>发布统考</a></li>
			</ul></li>
		<li class="treeview"><a
			href="<%=request.getContextPath()%>/teacher/grade"> <i
				class="fa fa-edit"></i> <span>成绩统计</span>
		</a></li>
	</ul>

</div>