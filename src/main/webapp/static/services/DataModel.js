angular.module('app')
	.factory('DataModel', [
		function () {
			var __projects = [];
			var __currentUser = {};
			var __users = [];
			
			return {
				currentUser: __currentUser,
				projects: __projects,
				users: __users
			};
		}
	]);