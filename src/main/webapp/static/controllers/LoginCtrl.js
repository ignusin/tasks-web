angular.module('app')
	.controller('LoginCtrl', [
		'$scope',
		'$http',
		'$window',
		'UserRemoteService',
		'RootUrl',
		function ($scope, $http, $window, UserRemoteService, RootUrl) {
			$scope.authError = false;
			
			$scope.data = {
				name: '',
				password: ''
			};
		
			var __submit = function () {
				$scope.authError = false;
				
				if (!$scope.form.$valid) {
					return;
				}
				
				UserRemoteService
					.authenticate($scope.data)
					.then(function () {
						$window.location.href = RootUrl + '/';
					})
					.catch(function () {
						$scope.authError = true;
					});
			};
			
			$scope.submit = function () { __submit(); return false; };
		}
	]);
