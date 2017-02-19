angular.module('app')
	.controller('ToolbarCtrl', [
		'$scope',
		'$uibModal',
		'$window',
		'UserRemoteService',
		'RootUrl',
		function ($scope, $uibModal, $window, UserRemoteService, RootUrl) {
			var __addProject = function () {
				$uibModal.open({
					controller: 'ProjectFormCtrl',
					templateUrl: RootUrl + '/template/project-form'
				});
			};
			
			var __addTask = function () {
				$uibModal.open({
					controller: 'TaskFormCtrl',
					templateUrl: RootUrl + '/template/task-form'
				});
			};
			
			var __logout = function () {
				UserRemoteService
					.logout()
					.then(function () {
						$window.location.href = RootUrl + '/login';
					});
			};
			
			$scope.addProject = __addProject;
			$scope.addTask = __addTask;
			$scope.logout = __logout;
		}
	]);
