package iglabs.tasks.dao.jpa;

import iglabs.tasks.dao.RootTaskDAO;
import iglabs.tasks.entities.RootTask;

public class RootTaskJpaDAO extends AbstractGenericJpaDAO<RootTask> implements RootTaskDAO {
	@Override
	protected Class<RootTask> getEntityClass() {
		return RootTask.class;
	}
}
