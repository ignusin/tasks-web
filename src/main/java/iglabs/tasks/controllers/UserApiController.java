package iglabs.tasks.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import iglabs.tasks.services.AuthService;

@Controller
public class UserApiController extends ApiController {
	@Autowired
	private AuthService authService;
	
	
	@RequestMapping(value="/api/user/logout", method=RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		authService.signOut(request, response);
	}
}
