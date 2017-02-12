angular.module('app')
	.factory('ProjectService', [
		'$http',
		'$q',
		'RootUrl',
		function ($http, $q, RootUrl) {
			var __addOrUpdate = function (dto) {
				var promise = $q(function (resolve, reject) {
					$http.post(RootUrl + '/api/projects', dto)
						.then(function (res) {
							resolve(res.data.data);
						})
						.catch(function (res) {
							reject(res.data.message);
						});
				});
				
				return promise;
			};
			
			
			return {
				addOrUpdate: __addOrUpdate
			};
		}
	]);