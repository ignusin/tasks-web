angular.module('app')
	.factory('DataModelManager', [
		'DataModel',
		function (DataModel) {
			var __reassignObject = function (target, source) {
				var key;
				for (key in target) {
					if (!target.hasOwnProperty(key)) {
						continue;
					}
					
					delete target[key];
				}
				
				for (key in source) {
					if (!source.hasOwnProperty(key)) {
						continue;
					}
					
					target[key] = source[key];
				}
			};
			
			var __reassignArray = function (target, source) {
				target.splice(0, target.length - 1);
				
				source.forEach(function (it) {
					target.push(it);
				});
			};
			
			var __insertOrdered = function (array, item, orderKey) {
				var i;
				for (i = 0; i < array.length; ++i) {
					if (array[i][orderKey] > item[orderKey]) {
						array.splice(i, 0, item);
						break;
					}
				}
			};
			
			// ########## Current User ##########
			
			var __setCurrentUser = function (user) {
				__reassignObject(DataModel.currentUser, user);
			};
			
			
			// ########## Projects ##########
			
			var __setProjects = function (projects) {
				__reassignArray(DataModel.projects, projects);
			};
			
			var __addProject = function (project) {
				__insertOrdered(DataModel.projects, project, 'name');
			};
			
			
			return {
				setCurrentUser: __setCurrentUser,
				setProjects: __setProjects,
				addProject: __addProject
			};
		}
	]);