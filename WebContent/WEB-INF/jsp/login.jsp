<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/sco.message.css" />
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2 class="text-center text-info">程序题智能批改系统</h2>
					<div class="row">
						<div class="col-md-4">
						</div>
						<div class="col-md-4">

							<form class="form-signin" id="login_form" action="login/check" method="post">
								<h2 class="form-signin-heading">登录</h2>
								<label for="account" class="sr-only">学号/工号</label>
								<input type="text" id="account" name="account" class="form-control" placeholder="account">
								<p></p>
								<label for="password" class="sr-only">密码</label>
								<input type="password" id="password" name="password" class="form-control" placeholder="Password">
								<p></p>
								<select class="form-control" name="type" id="type">
									<option value="0">账户类型</option>
									<option value="1">学生</option>
									<option value="2">教师</option>
								</select>
								<p></p>
								<button class="btn btn-lg btn-primary btn-block" type="button" id="login">登录</button>
							</form>
						</div>
						<div class="col-md-4">
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/sco.message.js"></script>
		
		<script type="text/javascript">
			$(function() {
				
			<c:choose>
				<c:when test="${errorCode==1 }">
					$.scojs_message('帐号或密码错误', $.scojs_message.TYPE_ERROR);
				</c:when>
				
				<c:when test="${errorCode==2 }">
					$.scojs_message('请登录', $.scojs_message.TYPE_ERROR);
				</c:when>
				
			</c:choose>
			
			});
			
			$('#login').on('click', function(e) {
				if($('#account').val().length <= 0){
					$('#account').focus();
					$.scojs_message('请输入帐号', $.scojs_message.TYPE_ERROR);
				}else if($('#password').val().length <= 0){
					$('#password').focus();
					$.scojs_message('请输入密码', $.scojs_message.TYPE_ERROR);
				}else if($('#type').val() <= 0){
					$('#type').focus();
					$.scojs_message('请选择类型', $.scojs_message.TYPE_ERROR);
				}else{
					$('#login_form').submit();
				}
			});
		</script>
		
		<div id="page_message" class="page_mess_ok" style="display: none;">This is an info message</div>
	</body>
	
</html>