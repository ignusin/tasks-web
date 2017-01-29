package iglabs.tasks.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import iglabs.tasks.dto.ResultDTO;


public class ApiController {
	@ExceptionHandler(Exception.class)
	public @ResponseBody ResultDTO<Exception> handleException(HttpServletResponse response, Exception ex) {
		response.setStatus(500);
		
		return ResultDTO.error(ex.getMessage(), ex);
	}
}
