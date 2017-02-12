package iglabs.tasks.dao.jpa;

import org.springframework.stereotype.Repository;

import iglabs.tasks.dao.ProjectDAO;
import iglabs.tasks.entities.Project;


@Repository
public class ProjectJpaDAO
	extends AbstractGenericJpaDAO<Project>
	implements ProjectDAO {

	@Override
	protected Class<Project> getEntityClass() {
		return Project.class;
	}
}
