package iglabs.tasks.dao;

import iglabs.tasks.entities.User;

public interface UserDAO extends GenericDAO<User> {
	User findByName(String name);
}
