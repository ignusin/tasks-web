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
			
			ProjectRemoteService
				.list()
				.then(function (projects) {
					DataModelManager.setProjects(projects);
				});
		}
	]);