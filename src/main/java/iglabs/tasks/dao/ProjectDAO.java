package iglabs.tasks.dao;

import java.util.List;

import iglabs.tasks.entities.Project;

public interface ProjectDAO extends GenericDAO<Project> {
	List<Project> listByOwnerId(int ownerId);
}
