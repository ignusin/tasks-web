angular.module('app')
	.controller('RegisterCtrl', [
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
					.register($scope.data)
					.then(function () {
						$window.location.href = RootUrl + '/login';
					})
					.catch(function (message) {
						$scope.errorMessage = message;
					});
			};
			
			$scope.submit = function () { __submit(); return false; };
		}
	]);
