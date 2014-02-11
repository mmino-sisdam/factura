package com.loyal.facturacion.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.loyal.facturacion.model.Persona;
import com.loyal.facturacion.model.Rol;

public class FacturacionValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Rol.class) || clazz.equals(Persona.class); 
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}


}
