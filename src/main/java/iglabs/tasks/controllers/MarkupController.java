package iglabs.tasks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MarkupController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/template/{templateName}", method=RequestMethod.GET)
	public ModelAndView template(@PathVariable String templateName) {
		return new ModelAndView("templates/" + templateName);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("register");
	}
}
