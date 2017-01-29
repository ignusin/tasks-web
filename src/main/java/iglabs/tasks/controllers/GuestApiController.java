package iglabs.tasks.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import iglabs.tasks.dto.CredentialsDTO;
import iglabs.tasks.dto.RegisterDTO;
import iglabs.tasks.services.AuthService;
import iglabs.tasks.services.UserService;


@Controller
public class GuestApiController extends ApiController {
	@Autowired
	private AuthService authService;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/api/guest/authenticate", method=RequestMethod.POST)
	public @ResponseBody void login(@RequestBody CredentialsDTO dto,
		HttpServletRequest request, HttpServletResponse response) {
		
		if (!userService.checkCredentials(dto.getName(), dto.getPassword())) {
			throw new RuntimeException("Invalid credentials");
		}
		
		authService.authenticate(request, response, dto.getName(), dto.getPassword());
	}
	
	@RequestMapping(value="/api/guest/register", method=RequestMethod.POST)
	public @ResponseBody void register(@RequestBody RegisterDTO dto) {
		userService.createUser(dto.getName(), dto.getPassword(), dto.getEmail());
	}
}
