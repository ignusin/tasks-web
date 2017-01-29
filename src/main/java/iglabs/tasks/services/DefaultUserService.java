package iglabs.tasks.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import iglabs.tasks.dao.UserDAO;
import iglabs.tasks.entities.User;

@Component
public class DefaultUserService implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public boolean checkCredentials(String name, String password) {
		User user = userDAO.findByName(name);
		if (user == null) {
			return false;
		}
		
		return StringUtils.equals(user.getPassword(), password);
	}
	
	@Override
	@Transactional
	public void createUser(String name, String password, String email) {
		if (StringUtils.isBlank(name)) {
			throw new IllegalArgumentException("Name cannot be blank");
		}
		
		if (StringUtils.isBlank(password)) {
			throw new IllegalArgumentException("Password cannot be blank");
		}
		
		if (StringUtils.isBlank(email)) {
			throw new IllegalArgumentException("Email cannot be blank");
		}
		
		User existingUser = userDAO.findByName(name);
		if (existingUser != null) {
			throw new IllegalArgumentException("User with same name already registered");
		}
		
		User user = new User(name, password, email);
		userDAO.add(user);
	}
}
