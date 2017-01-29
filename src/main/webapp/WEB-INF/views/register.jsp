<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="app">
	<head>
		<title>Register new user</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<jsp:include page="/WEB-INF/views/scripts.jsp"></jsp:include>
		<script src="<c:url value="/static/controllers/RegisterCtrl.js" />"></script>
	</head>
	<body>
		<div class="register-container" ng-controller="RegisterCtrl">
			<form name="form" ng-submit="submit()" novalidate>
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="text-danger" ng-if="errorMessage">
							Unable to register you: {{errorMessage}}
							<div class="space-10"></div>
						</div>
						<div class="form-group" ng-class="{ 'has-error': !form.name.$valid }">
							<label>User Name:</label>
							<input type="text" class="form-control" name="name" ng-model="data.name" required />
						</div>
						
						<div class="form-group" ng-class="{ 'has-error': !form.password.$valid }">
							<label>Password:</label>
							<input type="password" class="form-control" name="password" ng-model="data.password" required />
						</div>
						
						<div class="form-group" ng-class="{ 'has-error': !form.email.$valid }">
							<label>Email:</label>
							<input type="email" class="form-control" name="email" ng-model="data.email" required />
						</div>
					</div>
					<div class="panel-footer text-right">
						<button type="submit" class="btn btn-primary width-100">Register</button>
						<a href="<c:url value="/login" />" class="btn btn-default width-100">Cancel</a>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>