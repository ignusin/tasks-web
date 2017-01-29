package iglabs.tasks.dao.jpa;

import iglabs.tasks.dao.ProjectDAO;
import iglabs.tasks.entities.Project;

public class ProjectJpaDAO
	extends AbstractGenericJpaDAO<Project>
	implements ProjectDAO {

	@Override
	protected Class<Project> getEntityClass() {
		return Project.class;
	}
}
