angular.module('app')
	.controller('ProjectFormCtrl', [
		'$scope',
		'DataModelManager',
		'ProjectRemoteService',
		function ($scope, DataModelManager, ProjectRemoteService) {
			$scope.errorMessage = null;
			
			var __submit = function () {
				if (!$scope.form.$valid) {
					return;
				}
				
				ProjectRemoteService
					.addOrUpdate($scope.data)
					.then(function (project) {
						DataModelManager.addProject(project);
						$scope.$close(project);
					})
					.catch(function (message) {
						$scope.errorMessage = message;
					});
			};
			
			$scope.submit = __submit;
		}
	]);