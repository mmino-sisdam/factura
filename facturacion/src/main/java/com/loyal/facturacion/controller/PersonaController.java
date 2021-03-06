package com.loyal.facturacion.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.loyal.facturacion.model.Persona;
import com.loyal.facturacion.validator.PersonaValidator;

@Controller
@RequestMapping(value="/personas")
public class PersonaController{

	@Autowired
	PersonaDAO personaDAO;

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Map<String, Collection<Persona>> list(){
		Map<String, Collection<Persona>> results = new HashMap<String, Collection<Persona>>();
		results.put("usuarios", personaDAO.getAll());
		return results;
	}

	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody ResponseMessage create(@Valid @RequestBody Persona persona){
		personaDAO.insert(persona);
		return new ResponseMessage(ResponseMessageType.OK);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public @ResponseBody Persona find(@PathVariable Integer id){
		return personaDAO.findById(id);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ResponseMessage update(@Valid @RequestBody Persona persona, @PathVariable Integer id){
		personaDAO.update(persona);
		return new ResponseMessage(ResponseMessageType.OK);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ResponseMessage delete(@PathVariable Integer id){
		personaDAO.deleteById(id);
		return new ResponseMessage(ResponseMessageType.OK);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest webRequest){ 
		binder.setValidator(new PersonaValidator());
	}
}
