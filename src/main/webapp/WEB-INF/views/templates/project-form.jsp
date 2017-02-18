<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="modal-body">
	<div class="text-danger" ng-if="errorMessage">{{errorMessage}}</div>
	<form name="form" novalidate>
		<div class="form-group" ng-class="{ 'has-error': !form.name.$valid }">
			<label>Project name:</label>
			<input type="text" ng-model="data.name" name="name" class="form-control" required />
			<div class="text-danger" ng-if="form.name.$error.required">
				Required field.
			</div>
		</div>
	</form>
</div>
<div class="modal-footer">
	<button class="btn btn-primary" ng-click="submit()" ng-disabled="!form.$valid">Save Changes</button>
	<button class="btn btn-default" ng-click="$dismiss()">Cancel</button>
</div>
