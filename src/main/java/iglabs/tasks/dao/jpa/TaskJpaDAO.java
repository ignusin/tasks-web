package iglabs.tasks.dao.jpa;

import iglabs.tasks.dao.TaskDAO;
import iglabs.tasks.entities.Task;

public class TaskJpaDAO extends AbstractGenericJpaDAO<Task> implements TaskDAO {
	@Override
	protected Class<Task> getEntityClass() {		
		return Task.class;
	}
}
