angular.module('app')
	.run([
		'$rootScope',
		'UserService',
		function ($rootScope, UserService) {
			UserService
				.getCurrentUser()
				.then(function (user) {
					$rootScope.currentUser = user;
				});
		}
	]);