<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div ng-controller="LeftPanelCtrl" ng-init="init()">
	<div>
		<select class="form-control" ng-model="filterData.projectId"
			ng-options="project.id as project.name for project in projects">
			<option value="">All Projects</option>
		</select>
	</div>
	<div>
		<input type="text" class="form-control" placeholder="Filter tasks..." ng-model="filderData.task" />
	</div>
</div>