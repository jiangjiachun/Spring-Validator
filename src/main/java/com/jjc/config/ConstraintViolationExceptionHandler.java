/**
 * 
 */
package com.jjc.config;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;

/**
 * @author jjc
 *
 */

@ControllerAdvice(annotations = RestController.class)
public class ConstraintViolationExceptionHandler {

	@ExceptionHandler({ConstraintViolationException.class})
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Object handle(ConstraintViolationException exception, HandlerMethod handlerMethod) {
		String tip = "";
		for (ConstraintViolation<?> violation : (Iterable<ConstraintViolation<?>>)exception.getConstraintViolations()) {
			if(tip != "") {
				tip += ",";
			}
			tip += violation.getMessage();
		}
		/*Result result = new Result(HttpStatus.BAD_REQUEST, tip);
		if(handlerMethod.getMethodAnnotation(ResponseBody.class) == null) {
			return tip;
		}*/
		return ResponseEntity.badRequest().body(tip);		
	}
	
}
