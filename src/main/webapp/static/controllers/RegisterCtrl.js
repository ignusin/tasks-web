angular.module('app')
	.controller('RegisterCtrl', [
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
				
				$http.post(rootUrl + '/api/guest/register', $scope.data)
					.then(function () {
						$window.location.href = rootUrl + '/login';
					})
					.catch (function (res) {
						$scope.errorMessage = res.data.message;
					});
			};
			
			$scope.submit = function () { __submit(); return false; };
		}
	]);
