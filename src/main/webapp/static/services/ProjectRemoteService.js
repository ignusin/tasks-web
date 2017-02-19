angular.module('app')
	.factory('ProjectRemoteService', [
		'$http',
		'$q',
		'RootUrl',
		function ($http, $q, RootUrl) {
			var __list = function () {
				var promise = $q(function (resolve, reject) {
					$http.get(RootUrl + '/api/projects')
						.then(function (res) {
							resolve(res.data);
						})
						.catch(function (res) {
							reject(res.data.message);
						});
				});
				
				return promise;
			};
			
			var __addOrUpdate = function (dto) {
				var promise = $q(function (resolve, reject) {
					$http.post(RootUrl + '/api/projects', dto)
						.then(function (res) {
							resolve(res.data);
						})
						.catch(function (res) {
							reject(res.data.message);
						});
				});
				
				return promise;
			};
			
			
			return {
				list: __list,
				addOrUpdate: __addOrUpdate
			};
		}
	]);