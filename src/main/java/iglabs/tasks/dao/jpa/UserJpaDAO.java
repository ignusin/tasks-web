package iglabs.tasks.dao.jpa;

import java.util.List;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import iglabs.tasks.dao.UserDAO;
import iglabs.tasks.entities.User;


@Repository
public class UserJpaDAO
	extends AbstractGenericJpaDAO<User>
	implements UserDAO {
	
	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}
	
	@Transactional
	@Override
	public List<User> list() {
		TypedQuery<User> query = getEntityManager()
			.createQuery("SELECT u FROM User u ORDER BY u.name", User.class);
		
		List<User> result = query.getResultList();
		return result;
	}
	
	@Transactional
	@Override
	public User findByName(String name) {
		TypedQuery<User> query = getEntityManager()
			.createQuery("SELECT u FROM User u WHERE u.name LIKE :name", User.class);
		
		query.setParameter("name", name);
		
		List<User> users = query.getResultList();
		if (users.size() > 0) {
			return users.get(0);
		}
		
		return null;
	}
}
