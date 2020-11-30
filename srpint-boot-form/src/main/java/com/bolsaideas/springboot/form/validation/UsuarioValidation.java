package com.bolsaideas.springboot.form.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bolsaideas.springboot.form.models.domain.Usuario;

@Component
public class UsuarioValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		//Usuario usuario = (Usuario)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "requerido.usuario.nombre");
		
		/*if(usuario.getIdentificador().matches("[\\d]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}") == false) {
			errors.rejectValue("identificador", "pattern.usuario.identificador");
		}*/
		
	}

}
