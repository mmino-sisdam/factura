package com.loyal.facturacion.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.http.*;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.loyal.facturacion.dao.PersonaDAO;
import com.loyal.facturacion.dto.PasswordDTO;
import com.loyal.facturacion.model.Persona;
import com.loyal.facturacion.validator.PasswordValidator;

@Controller
@RequestMapping(value="/password")
public class PasswordController{

	@Autowired
	PersonaDAO personaDAO;

	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ResponseMessage changePassword(@Valid @RequestBody PasswordDTO passwordDTO, @PathVariable Integer id){
		personaDAO.changePassword(passwordDTO.getNewPassword(), id);
		return new ResponseMessage(ResponseMessageType.OK);
	}

	@RequestMapping(method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ResponseMessage changePassword(@Valid @RequestBody PasswordDTO passwordDTO){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Persona usuario = personaDAO.findByUsername(authentication.getName());
		personaDAO.changePassword(passwordDTO.getNewPassword(), usuario.getId());
		return new ResponseMessage(ResponseMessageType.OK);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest webRequest){ 
		binder.setValidator(new PasswordValidator());
	}
}
