package iglabs.tasks.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthService {
	void authenticate(HttpServletRequest httpRequest,
		HttpServletResponse httpResponse, String name, String password);

	int getUserId(HttpServletRequest httpRequest);
	
	String getUserName(HttpServletRequest httpRequest);
	
	boolean isAuthenticated(HttpServletRequest httpRequest);
	
	void signOut(HttpServletRequest httpRequest, HttpServletResponse httpResponse);
}
