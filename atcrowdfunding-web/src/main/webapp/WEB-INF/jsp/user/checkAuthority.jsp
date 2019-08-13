<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

	<link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
	<link rel="stylesheet" href="${APP_PATH}/css/main.css">
	<link rel="stylesheet" href="${APP_PATH}/css/doc.min.css">
	<style>
	.tree li {
        list-style-type: none;
		cursor:pointer;
	}
	</style>
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
            <div><a class="navbar-brand" style="font-size:32px;" href="user.html">智能身份授权系统 - 用户维护</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li style="padding-top:8px;">
				<div class="btn-group">
				  <button type="button" class="btn btn-default btn-success dropdown-toggle" data-toggle="dropdown">
					<i class="glyphicon glyphicon-user"></i> ${loginUser.username} <span class="caret"></span>
				  </button>
					  <ul class="dropdown-menu" role="menu">
						<li><a href="#"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
						<li class="divider"></li>
						<li><a href="${APP_PATH }/login"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
					  </ul>
			    </div>
			</li>
            <li style="margin-left:10px;padding-top:8px;">
				<button type="button" class="btn btn-default btn-danger">
				  <span class="glyphicon glyphicon-question-sign"></span> 帮助
				</button>
			</li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
			<div class="tree">
				<%@include file="/WEB-INF/jsp/common/menu.jsp"%>
			</div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<ol class="breadcrumb">
				  <li><a href="#">首页</a></li>
				  <li><a href="#">数据列表</a></li>
				  <li class="active">审核详情</li>
				</ol>
			<div class="panel panel-default">
              <div class="panel-heading">审核记录详情<div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-question-sign"></i></div></div>
			  <div class="panel-body">
				<form id="tacForm" role="form">
				  <div class="form-group">
					<label for="exampleInputPassword1">来访者名称:</label>
					<input type="text" readonly="true" class="form-control" value="${tac.username}" >
				  </div>
				  <div class="form-group">
					<label for="exampleInputPassword1">来访者电话:</label>
					<input type="text" readonly="true" class="form-control"  value="${tac.telephone}">
				  </div>
				   <div class="form-group">
					<label for="exampleInputPassword1">接待人:</label>
					<c:if test="${not empty tac.receptname }">
					<input type="text" readonly="true" class="form-control"  value="${tac.receptname}">
					</c:if>
					<c:if test="${empty tac.receptname }">
					<input type="text" readonly="true" class="form-control"  value="${loginUser.username}">
					</c:if>
				  </div>
				  <div class="form-group">
					<label for="exampleInputPassword1">接待人电话:</label>
					<c:if test="${not empty tac.receptphone }">
					<input type="text" readonly="true" class="form-control"  value="${tac.receptphone}">
					</c:if>
					<c:if test="${empty tac.receptphone }">
					<input type="text" readonly="true" class="form-control"  value="${loginUser.telephone}">
					</c:if>
				  </div>
				   <div class="form-group">
					<label for="exampleInputPassword1">访问门禁:</label>
					<input type="text" readonly="true" class="form-control"  value="${tac.lockname}">
				  </div>
				   <div class="form-group">
					<label for="exampleInputPassword1">访问缘由:</label>
					<input type="text" readonly="true" class="form-control"  value="${tac.visitecause}">
				  </div>
				   <div class="form-group">
					<label for="exampleInputPassword1">到访时间:</label>
					<input type="text" readonly="true" class="form-control"  value="${tac.applytime}">
				  </div>
				  <button id="okBtn" type="button" class="btn btn-success"><i class="glyphicon glyphicon-ok"></i> 通过</button>
				  <button id="errorBtn" type="button" class="btn btn-danger"><i class="glyphicon glyphicon-error"></i> 不通过</button>
				</form>
			  </div>
			</div>
        </div>
      </div>
    </div>
    <script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APP_PATH}/script/docs.min.js"></script>
	<script src="${APP_PATH}/layer/layer.js"></script>
        <script type="text/javascript">
            $(function () {
			    $(".list-group-item").click(function(){
				    if ( $(this).find("ul") ) {
						$(this).toggleClass("tree-closed");
						if ( $(this).hasClass("tree-closed") ) {
							$("ul", this).hide("fast");
						} else {
							$("ul", this).show("fast");
						}
					}
				});
            });
            $("#okBtn").click(function(){
		    	var loadingIndex = null;
		    	$.ajax({
		    		type : "POST",
		    		url  : "${APP_PATH}/user/ok",
		    		data : {
		    			"id"     : "${tac.id}"
		    		},
		    		beforeSend : function() {
		    			loadingIndex = layer.msg('处理中', {icon: 16});
		    		},
		    		success : function(result) {
		    			layer.close(loadingIndex);
		    			if ( result.success ) {
	                        layer.msg("用户审核成功", {time:1000, icon:6}, function(){
	                        	window.location.href = "${APP_PATH}/user/authorityCheck";
	                        });
		    			} else {
	                        layer.msg("用户审核失败", {time:2000, icon:5, shift:6}, function(){
	                        	
	                        });
		    			}
		    		}
		    	});
		    });
            
            $("#errorBtn").click(function(){
		    	var loadingIndex = null;
		    	$.ajax({
		    		type : "POST",
		    		url  : "${APP_PATH}/user/error",
		    		data : {
		    			"id"  : "${tac.id}"
		    			
		    		},
		    		beforeSend : function() {
		    			loadingIndex = layer.msg('处理中', {icon: 16});
		    		},
		    		success : function(result) {
		    			layer.close(loadingIndex);
		    			if ( result.success ) {
	                        layer.msg("用户审核成功", {time:1000, icon:6}, function(){
	                        	window.location.href = "${APP_PATH}/user/authorityCheck";
	                        });
		    			} else {
	                        layer.msg("用户审核失败", {time:2000, icon:5, shift:6}, function(){
	                        	
	                        });
		    			}
		    		}
		    	});
		    });
        </script>
  </body>
</html>
