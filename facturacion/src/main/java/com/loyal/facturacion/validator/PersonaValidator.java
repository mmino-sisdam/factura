package com.loyal.facturacion.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.loyal.facturacion.model.Persona;
import com.loyal.facturacion.model.Rol;

@Component
public class PersonaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Rol.class) || clazz.equals(Persona.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (target instanceof Rol) {
			validateRol((Rol) target, errors);
		} else {
			validatePersona((Persona) target, errors);
		}
	}

	private void validatePersona(Persona persona, Errors errors) {
		if (persona.getId() == null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Usuario es requerido");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Password es requerido");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido", "Apellido es requerido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "Nombre es requerido");
	}

	private void validateRol(Rol rol, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "rol", "Rol es requerido");
	}
}
