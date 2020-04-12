/**
 * 
 */
package com.jjc.config;

import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author jjc
 *
 */
public class ValidatorConfig implements WebMvcConfigurer {

	@Override
	public Validator getValidator() {
		return (Validator)new LocalValidatorFactoryBean();
	}
}
