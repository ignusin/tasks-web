angular.module('app')
	.controller('LeftPanelCtrl', [
		'$rootScope',
		'$scope',
		'DataModel',
		function ($rootScope, $scope, DataModel) {
			var __init = function () {
				$scope.filterData = { 'projectId': '' };
				$scope.projects = DataModel.projects;
			};

			$scope.init = __init;
		}
	]);