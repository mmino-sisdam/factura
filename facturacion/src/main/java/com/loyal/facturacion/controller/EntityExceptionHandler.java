package com.loyal.facturacion.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@SuppressWarnings("unchecked")
@ControllerAdvice
public class EntityExceptionHandler extends ResponseEntityExceptionHandler {


	@SuppressWarnings("rawtypes")
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
		List<String> errors = new ArrayList<String>(fieldErrors.size() + globalErrors.size());
		String error;
		for (FieldError fieldError : fieldErrors) {
			error = fieldError.getField() + ", " + fieldError.getDefaultMessage();
			errors.add(error);
		}
		for (ObjectError objectError : globalErrors) {
			error = objectError.getObjectName() + ", " + objectError.getDefaultMessage();
			errors.add(error);
		}
		ResponseMessage errorMessage = new ResponseMessage(ResponseMessageType.ERROR, errors);
		return new ResponseEntity(errorMessage, headers, status);
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		String unsupported = "Unsupported content type: " + ex.getContentType();
		String supported = "Supported content types: " + MediaType.toString(ex.getSupportedMediaTypes());
		ResponseMessage errorMessage = new ResponseMessage(ResponseMessageType.ERROR,unsupported, supported);
		return new ResponseEntity(errorMessage, headers, status);
	}


	@SuppressWarnings("rawtypes")
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		Throwable mostSpecificCause = ex.getMostSpecificCause();
		ResponseMessage errorMessage;
		if (mostSpecificCause != null) {
			String exceptionName = mostSpecificCause.getClass().getName();
			String message = mostSpecificCause.getMessage();
			errorMessage = new ResponseMessage(ResponseMessageType.ERROR,exceptionName, message);
		} else {
			errorMessage = new ResponseMessage(ResponseMessageType.ERROR,ex.getMessage());
		}
		return new ResponseEntity(errorMessage, headers, status);
	}

	@ExceptionHandler(value = { DataAccessException.class })
	protected ResponseEntity<Object> handleConflictDataAccess(RuntimeException ex, WebRequest request) {
		ResponseMessage errorMessage = new ResponseMessage(ResponseMessageType.ERROR, ex.getLocalizedMessage());
		return handleExceptionInternal(ex, errorMessage, 
		          new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
	@ExceptionHandler(value = { DuplicateKeyException.class })
	protected ResponseEntity<Object> handleConflictDuplicate(RuntimeException ex, WebRequest request) {
		ResponseMessage errorMessage = new ResponseMessage(ResponseMessageType.ERROR, "Clave duplicada");
		return handleExceptionInternal(ex, errorMessage, 
		          new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
}
