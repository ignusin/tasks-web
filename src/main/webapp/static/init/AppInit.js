angular.module('app')
	.run([
		'DataModelManager',
		'ProjectRemoteService',
		'UserRemoteService',
		function (DataModelManager, ProjectRemoteService, UserRemoteService) {
			UserRemoteService
				.getCurrentUser()
				.then(function (user) {
					DataModelManager.setCurrentUser(user);
				});
			
			UserRemoteService
				.list()
				.then(function (users) {
					DataModelManager.setUsers(users);
				});
			
			ProjectRemoteService
				.list()
				.then(function (projects) {
					DataModelManager.setProjects(projects);
				});
		}
	]);