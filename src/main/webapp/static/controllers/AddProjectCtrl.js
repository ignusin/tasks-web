angular.module('app')
	.controller('AddProjectCtrl', [
		'$rootScope',
		'$scope',
		'ProjectService',
		function ($rootScope, $scope, ProjectService) {
			$scope.errorMessage = null;
			
			var __submit = function () {
				if (!$scope.form.$valid) {
					return;
				}
				
				ProjectService
					.addOrUpdate($scope.data)
					.then(function (project) {
						$rootScope.$broadcast('projects.modified');
						$scope.$close(project);
					})
					.catch(function (message) {
						$scope.errorMessage = message;
					});
			};
			
			$scope.submit = __submit;
		}
	]);