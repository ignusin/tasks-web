package iglabs.tasks.dao.jpa;

import java.util.List;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

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
