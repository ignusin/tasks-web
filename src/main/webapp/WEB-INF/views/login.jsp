<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="app">
	<head>
		<title>Log In</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<jsp:include page="/WEB-INF/views/scripts.jsp"></jsp:include>
		<script src="<c:url value="/static/controllers/LoginCtrl.js" />"></script>
		<script src="<c:url value="/static/services/UserService.js" />"></script>
	</head>
	<body>
		<div class="login-container" ng-controller="LoginCtrl">
			<form name="form" ng-submit="submit()" novalidate>
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="text-danger" ng-if="authError">
							Unable to authenticate you, please check username and password.
							<div class="space-10"></div>
						</div>
						<div class="form-group" ng-class="{ 'has-error': form.name.$error.required }">
							<label>User Name:</label>
							<input type="text" class="form-control" name="name" ng-model="data.name" required />
						</div>
						
						<div class="form-group" ng-class="{ 'has-error': form.password.$error.required }">
							<label>Password:</label>
							<input type="password" class="form-control" name="password" ng-model="data.password" required />
						</div>
					</div>
					<div class="panel-footer text-right">
						<button type="submit" class="btn btn-primary width-100">Log In</button>
						<a href="<c:url value="/register" />" class="btn btn-default width-100">Register</a>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>