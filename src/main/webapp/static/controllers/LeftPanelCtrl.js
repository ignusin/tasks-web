angular.module('app')
	.controller('LeftPanelCtrl', [
		'$rootScope',
		'$scope',
		'ProjectService',
		function ($rootScope, $scope, ProjectService) {
			var __init = function () {
				$scope.filterData = { 'projectId': '' };
				__reloadProjects();
			};
			
			var __reloadProjects = function () {
				ProjectService
					.list()
					.then(function (projects) {
						var result = [];
						result.push({ 'id': '', 'name': 'All projects' });
						
						projects.forEach(function (it) {
							result.push({ 'id': it.id, 'name': it.name });
						});
						
						$scope.projects = result;
					});
			};
			
			$rootScope.$on('projects.modified', __reloadProjects);
			
			$scope.init = __init;
		}
	]);