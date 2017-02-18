<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="app">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Tasks</title>
	
	<jsp:include page="/WEB-INF/views/scripts.jsp"></jsp:include>
	
	<!-- Init -->
	<script src="<c:url value="/static/init/AppInit.js" />"></script>
	
	<!-- Controllers -->
	<script src="<c:url value="/static/controllers/LeftPanelCtrl.js" />"></script>
	<script src="<c:url value="/static/controllers/ProjectFormCtrl.js" />"></script>
	<script src="<c:url value="/static/controllers/TaskFormCtrl.js" />"></script>
	<script src="<c:url value="/static/controllers/ToolbarCtrl.js" />"></script>
	
	<!-- Services -->
	<script src="<c:url value="/static/services/ProjectService.js" />"></script>
	<script src="<c:url value="/static/services/UserService.js" />"></script>
</head>
<body>
	<div class="app-container">
		<div class="toolbar" ng-controller="ToolbarCtrl">
			<a href ng-click="addTask()"><i class="fa fa-plus-circle" aria-hidden="true"></i> Add Task</a>
			<a href ng-click="addProject()"><i class="fa fa-puzzle-piece" aria-hidden="true"></i> Add Project</a>
			<a href ng-click="logout()"><i class="fa fa-sign-out" aria-hidden="true"></i> Log Out</a>
		</div>
		
		<div class="left-panel">
			<ng-include src="'<c:url value="/template/left-panel" />'" />
		</div>
		
		<div class="center-panel">
		</div>
		
		<div class="right-panel">
		</div>
	</div>
</body>
</html>
