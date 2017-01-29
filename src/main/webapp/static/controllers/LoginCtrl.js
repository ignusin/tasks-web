angular.module('app')
	.controller('LoginCtrl', [
		'$scope',
		'$http',
		'$window',
		'rootUrl',
		function ($scope, $http, $window, rootUrl) {
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
				
				$http.post(rootUrl + '/api/guest/authenticate', $scope.data)
					.then(function () {
						$window.location.href = rootUrl + '/';
					})
					.catch (function () {
						$scope.authError = true;
					});
			};
			
			$scope.submit = function () { __submit(); return false; };
		}
	]);
