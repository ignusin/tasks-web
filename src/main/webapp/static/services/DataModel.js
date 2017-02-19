angular.module('app')
	.factory('DataModel', [
		function () {
			var __projects = [];
			var __currentUser = {};
			
			return {
				currentUser: __currentUser,
				projects: __projects
			};
		}
	]);