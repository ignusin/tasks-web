angular.module('app')
	.controller('AddProjectCtrl', [
		'$scope',
		'ProjectService',
		function ($scope, ProjectService) {
			$scope.errorMessage = null;
			
			var __submit = function () {
				if (!$scope.form.$valid) {
					return;
				}
				
				ProjectService
					.addOrUpdate($scope.data)
					.then(function (project) {
						$scope.$close(project);
					})
					.catch(function (message) {
						$scope.errorMessage = message;
					});
			};
			
			$scope.submit = __submit;
		}
	]);