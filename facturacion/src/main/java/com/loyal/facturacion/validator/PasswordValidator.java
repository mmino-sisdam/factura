package com.loyal.facturacion.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.loyal.facturacion.dto.PasswordDTO;

@Component
public class PasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(PasswordDTO.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PasswordDTO dto = (PasswordDTO) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPassword", "Nuevo password es requerido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "repeatNewPassword", "Confirmar el password es requerido");
		if (!errors.hasErrors() && !dto.getNewPassword().equals(dto.getRepeatNewPassword())){
			errors.reject("repeatNewPassword", null, "La confirmación del password no es válida");
		}
	}

}
