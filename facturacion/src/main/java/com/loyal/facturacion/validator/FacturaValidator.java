package com.loyal.facturacion.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.loyal.facturacion.model.factura.Factura;

@Component
public class FacturaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Factura.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idTipoFactura", "Dato es requerido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numero", "Dato es requerido");
		
	}

}
