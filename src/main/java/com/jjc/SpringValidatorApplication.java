package com.jjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import com.jjc.config.ValidatorConfig;

@SpringBootApplication
@Import({MethodValidationPostProcessor.class})
public class SpringValidatorApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringValidatorApplication.class);
		app.run(args);
	}

}
