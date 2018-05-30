<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<header id="header">
			<nav class="navbar navbar-inverse navbar-fixed-top my-nav-buttom">
				<div class="container ">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-li" aria-expanded="false" aria-controls="navbar">
			            	<span class="sr-only">Toggle navigation</span>
			            	<span class="icon-bar"></span>
			            	<span class="icon-bar"></span>
			            	<span class="icon-bar"></span>
		          		</button>
						<a class="navbar-brand" href="<%=request.getContextPath() %>/exam/student">程序题智能批改</a>
						<p class="navbar-text">学生答题系统</p>
					</div>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="navbar-collapse collapse" id="navbar-li">
						<ul class="nav navbar-nav navbar-right my-nav">
							<li class="active">
								<a href="<%=request.getContextPath() %>/exam/student">我的考试 </a>
							</li>
							<li class="dropdown my-nav-dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${user.name} <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li>
										<a href="<%=request.getContextPath() %>/logout">注销</a>
									</li>
								</ul>
							</li>
						</ul>
					</div>

				</div>
			</nav>
		</header>