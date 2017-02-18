package iglabs.tasks.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import iglabs.tasks.dao.ProjectDAO;
import iglabs.tasks.dao.UserDAO;
import iglabs.tasks.dto.ProjectDTO;
import iglabs.tasks.entities.Project;
import iglabs.tasks.entities.User;
import iglabs.tasks.services.AuthService;
import iglabs.tasks.utils.MapperUtils;


@Controller
@RequestMapping(value="/api/projects")
public class ProjectApiController extends ApiController {
	@Autowired
	private AuthService authService;
	
	@Autowired
	private ProjectDAO projectDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private Mapper mapper;
	
	@GetMapping
	@Transactional
	public @ResponseBody List<ProjectDTO> list(HttpServletRequest httpRequest) {
		int ownerId = authService.getUserId(httpRequest);
		List<Project> projects = projectDAO.listByOwnerId(ownerId);
		
		return MapperUtils.mapList(mapper, projects, ProjectDTO.class);
	}
	
	@PostMapping
	@Transactional
	public @ResponseBody ProjectDTO addOrUpdate(@RequestBody ProjectDTO dto, HttpServletRequest httpRequest) {
		Project project = mapper.map(dto, Project.class);
		
		User owner = userDAO.find(authService.getUserId(httpRequest));
		project.setOwner(owner);
		
		projectDAO.addOrUpdate(project);
		
		return mapper.map(project, ProjectDTO.class);
	}
}
