<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						<a type="button" onclick="method1('grades')" id = "loadGrades" class="btn btn-info pull-right">下载</a>
					</h2>
					<div class="container-fluid">
					<!--  
						<div class="alert alert-info" role="alert">
							<span class="alert-link">暂无</span>
						</div>
					-->
					</div>
					<div class="table-responsive">
						<table class="table table-striped" id="grades">
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
			$.sidebarMenu($('.sidebar-menu'));
			
			var idTmr;
	        function  getExplorer() {
	            var explorer = window.navigator.userAgent ;
	            //ie
	            if (explorer.indexOf("MSIE") >= 0) {
	                return 'ie';
	            }
	            //firefox
	            else if (explorer.indexOf("Firefox") >= 0) {
	                return 'Firefox';
	            }
	            //Chrome
	            else if(explorer.indexOf("Chrome") >= 0){
	                return 'Chrome';
	            }
	            //Opera
	            else if(explorer.indexOf("Opera") >= 0){
	                return 'Opera';
	            }
	            //Safari
	            else if(explorer.indexOf("Safari") >= 0){
	                return 'Safari';
	            }
	        }
	        function method1(tableid) {//整个表格拷贝到EXCEL中
	            if(getExplorer()=='ie')
	            {
	                var curTbl = document.getElementById(tableid);
	                var oXL = new ActiveXObject("Excel.Application");
	                 
	                //创建AX对象excel
	                var oWB = oXL.Workbooks.Add();
	                //获取workbook对象
	                var xlsheet = oWB.Worksheets(1);
	                //激活当前sheet
	                var sel = document.body.createTextRange();
	                sel.moveToElementText(curTbl);
	                //把表格中的内容移到TextRange中
	                sel.select();
	                //全选TextRange中内容
	                sel.execCommand("Copy");
	                //复制TextRange中内容 
	                xlsheet.Paste();
	                //粘贴到活动的EXCEL中      
	                oXL.Visible = true;
	                //设置excel可见属性
	 
	                try {
	                    var fname = oXL.Application.GetSaveAsFilename("Excel.xls", "Excel Spreadsheets (*.xls), *.xls");
	                } catch (e) {
	                    print("Nested catch caught " + e);
	                } finally {
	                    oWB.SaveAs(fname);
	 
	                    oWB.Close(savechanges = false);
	                    //xls.visible = false;
	                    oXL.Quit();
	                    oXL = null;
	                    //结束excel进程，退出完成
	                    //window.setInterval("Cleanup();",1);
	                    idTmr = window.setInterval("Cleanup();", 1);
	 
	                }
	            }
	            else
	            {
	                tableToExcel(tableid)
	            }
	        }
	        function Cleanup() {
	            window.clearInterval(idTmr);
	            CollectGarbage();
	        }
	        var tableToExcel = (function() {
	              var uri = 'data:application/vnd.ms-excel;base64,',
	              template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><meta http-equiv="Content-Type" charset=utf-8"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
	                base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) },
	                format = function(s, c) {
	                    return s.replace(/{(\w+)}/g,
	                    function(m, p) { return c[p]; }) }
	                return function(table, name) {
	                if (!table.nodeType) table = document.getElementById(table)
	                var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML}
	                window.location.href = uri + base64(format(template, ctx))
	              }
	            })()
		</script>

	</body>

</html>