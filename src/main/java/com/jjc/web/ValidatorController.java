package com.jjc.web;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/")
public class ValidatorController {

	@GetMapping
	public ResponseEntity<String> index(@NotNull Integer id) {

		return new ResponseEntity<String>("ok", new HttpHeaders(), HttpStatus.OK);
	}

}