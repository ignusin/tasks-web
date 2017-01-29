package iglabs.tasks.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

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
	
	@Override
	public void add(T entity) {
		getEntityManager().persist(entity);
	}

	@Override
	public void update(T entity) {
		getEntityManager().merge(entity);
	}

	@Override
	public void remove(T entity) {
		getEntityManager().remove(entity);
	}

	@Override
	public List<T> list() {
		EntityManager em = getEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> query = cb.createQuery(getEntityClass());
		query.select(query.from(getEntityClass()));
		
		return em.createQuery(query).getResultList();
	}

	@Override
	public T find(int id) {
		return getEntityManager().find(getEntityClass(), id);
	}
}
