package iglabs.tasks.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import iglabs.tasks.services.AuthService;

public class SecurityInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private AuthService authService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
		HttpServletResponse response, Object handler) throws Exception {

		if (!authService.isAuthenticated(request)) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
		
		return true;
	}
}
