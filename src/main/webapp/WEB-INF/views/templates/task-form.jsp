<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="modal-body">
	<form name="form" novalidate>
		<div class="form-group" ng-class="{ 'has-error': !form.name.$valid }">
			<label>Task name:</label>
			<input type="text" ng-model="data.name" name="name" class="form-control" required />
			<div class="text-danger" ng-if="form.name.$error.required">
				Required field.
			</div>
		</div>
		<div class="form-group" ng-class="{ 'has-error': !form.description.$valid }">
			<label>Task description:</label>
			<input type="text" ng-model="data.description" name="description" class="form-control" required />
			<div class="text-danger" ng-if="form.description.$error.required">
				Required field.
			</div>
		</div>
		<div class="form-group" ng-class="{ 'has-error': !form.assignedTo.$valid }">
			<label>Assigned to:</label>
			<select ng-model="data.assignedTo" name="assignedTo" class="form-control" required>
			</select>
		</div>
	</form>
</div>
<div class="modal-footer">
	<button class="btn btn-primary" ng-click="submit()" ng-disabled="!form.$valid">Save Changes</button>
	<button class="btn btn-default" ng-click="$dismiss()">Cancel</button>
</div>
