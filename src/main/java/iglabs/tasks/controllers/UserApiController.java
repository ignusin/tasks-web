package iglabs.tasks.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import iglabs.tasks.dao.UserDAO;
import iglabs.tasks.dto.UserDTO;
import iglabs.tasks.entities.User;
import iglabs.tasks.services.AuthService;
import iglabs.tasks.utils.MapperUtils;

@Controller
@RequestMapping("/api/user")
public class UserApiController extends ApiController {
	@Autowired
	private AuthService authService;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private Mapper mapper;
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public @ResponseBody List<UserDTO> list() {
		List<User> users = userDAO.list();
		return MapperUtils.mapList(mapper, users, UserDTO.class);
	}
	
	@RequestMapping(value="/current", method=RequestMethod.GET)
	public @ResponseBody UserDTO currentUser(HttpServletRequest request) {
		int userId = authService.getUserId(request);
		User user = userDAO.find(userId);
		
		return mapper.map(user, UserDTO.class);
	}
	
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public @ResponseBody void logout(HttpServletRequest request, HttpServletResponse response) {
		authService.signOut(request, response);
	}
}
