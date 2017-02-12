angular.module('app')
	.factory('UserService', [
		'$http',
		'$q',
		'RootUrl',
		function ($http, $q, RootUrl) {
			var __register = function (dto) {
				var promise = $q(function (resolve, reject) {
					$http.post(RootUrl + '/api/guest/register', dto)
						.then(function () {
							resolve();
						})
						.catch (function (res) {
							reject(res.data.message);
						});					
				});
				
				return promise;
			};
			
			var __authenticate = function (dto) {
				var promise = $q(function (resolve, reject) {
					$http.post(RootUrl + '/api/guest/authenticate', dto)
						.then(function () {
							resolve();
						})
						.catch (function (res) {
							reject(res.data.message);
						});
				});
				
				return promise;
			};
			
			var __logout = function () {
				var promise = $q(function (resolve, reject) {
					$http.get(RootUrl + '/api/user/logout')
						.then(function () {
							resolve();
						})
						.catch(function (res) {
							reject(res.data.message);
						});
				});
				
				return promise;
			};
			
			return {
				register: __register,
				authenticate: __authenticate,
				logout: __logout
			};
		}
	]);