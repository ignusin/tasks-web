package iglabs.tasks.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Transactional;

import iglabs.tasks.dao.GenericDAO;
import iglabs.tasks.entities.IdentityEntity;


public abstract class AbstractGenericJpaDAO<T extends IdentityEntity>
	implements GenericDAO<T> {

	@PersistenceContext
	private EntityManager em;
	
	protected EntityManager getEntityManager() {
		return em;
	}
	
	protected abstract Class<T> getEntityClass();
	
	@Transactional
	@Override
	public void add(T entity) {
		getEntityManager().persist(entity);
	}

	@Transactional
	@Override
	public void addOrUpdate(T entity) {
		if (entity.getId() == null) {
			add(entity);
		}
		else {
			update(entity);
		}
	}
	
	@Transactional
	@Override
	public void update(T entity) {
		getEntityManager().merge(entity);
	}

	@Transactional
	@Override
	public void remove(T entity) {
		getEntityManager().remove(entity);
	}

	@Transactional
	@Override
	public List<T> list() {
		EntityManager em = getEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> query = cb.createQuery(getEntityClass());
		query.select(query.from(getEntityClass()));
		
		return em.createQuery(query).getResultList();
	}

	@Transactional
	@Override
	public T find(int id) {
		return getEntityManager().find(getEntityClass(), id);
	}
}
