package iglabs.tasks.dao.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

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
	
	@Override
	public List<Project> listByOwnerId(int ownerId) {
		TypedQuery<Project> query = getEntityManager()
			.createQuery("SELECT p FROM Project p WHERE p.owner.id = :ownerId ORDER BY p.name ASC", Project.class);
			
		query.setParameter("ownerId", ownerId);
		
		List<Project> projects = query.getResultList();
		
		return projects;
	}
}
