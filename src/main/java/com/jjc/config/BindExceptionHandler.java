/**
 * 
 */
package com.jjc.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
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
public class BindExceptionHandler {

	@ExceptionHandler({BindException.class})
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Object handle(BindException bindException, HandlerMethod handlerMethod) {
		String tip = "";
		for (ObjectError error : bindException.getAllErrors()) {
			if(tip != "") {
				tip += ",";
			}
			tip += error.getDefaultMessage();
		}
		/*if(handlerMethod.getMethodAnnotation(ResponseBody.class) == null) {
			return tip;
		}*/
		return ResponseEntity.badRequest().body(tip);		
	}
	
}
