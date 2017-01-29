package iglabs.tasks.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthService {
	void authenticate(HttpServletRequest httpRequest,
		HttpServletResponse httpResponse, String name, String password);
	boolean isAuthenticated(HttpServletRequest httpRequest);
}
