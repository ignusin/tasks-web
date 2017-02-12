angular.module('app')
	.controller('ToolbarCtrl', [
		'$scope',
		'$uibModal',
		'$window',
		'UserService',
		'RootUrl',
		function ($scope, $uibModal, $window, UserService, RootUrl) {
			var __addProject = function () {
				$uibModal.open({
					controller: 'AddProjectCtrl',
					templateUrl: RootUrl + '/template/add-project'
				});
			};
			
			var __logout = function () {
				UserService.logout()
					.then(function () {
						$window.location.href = RootUrl + '/login';
					});
			};
			
			$scope.addProject = __addProject;
			$scope.logout = __logout;
		}
	]);
