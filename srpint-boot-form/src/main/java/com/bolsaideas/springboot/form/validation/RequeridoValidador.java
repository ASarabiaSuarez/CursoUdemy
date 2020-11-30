package com.bolsaideas.springboot.form.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import org.springframework.util.StringUtils;

public class RequeridoValidador implements ConstraintValidator<Requerido, String> {


	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		
		if(value ==null || !StringUtils.hasText(value)) {
			return false;
		}
		
		
		/*if(value == null || value.isEmpty() || value.isBlank()) {
			return false;
		}*/
		
		return true;
	}

}