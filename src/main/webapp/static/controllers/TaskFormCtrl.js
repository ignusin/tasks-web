angular.module('app')
	.controller('TaskFormCtrl', [
		'$scope',
		'DataModel',
		function ($scope, DataModel) {
			var __init = function () {
				$scope.projects = DataModel.projects;
				$scope.users = DataModel.users;
			};
			
			$scope.init = __init;
		}
	]);
