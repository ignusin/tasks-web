package iglabs.tasks.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import iglabs.tasks.dto.ExceptionDTO;


public class ApiController {
	@ExceptionHandler(Exception.class)
	public @ResponseBody ExceptionDTO handleException(HttpServletResponse response, Exception ex) {
		response.setStatus(500);
		
		return new ExceptionDTO(ex.getMessage(), ex);
	}
}
