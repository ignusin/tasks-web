package iglabs.tasks.services;

public interface UserService {
	boolean checkCredentials(String name, String password);
	void createUser(String name, String password, String email);
}
