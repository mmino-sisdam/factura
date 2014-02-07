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

import com.loyal.facturacion.dao.PersonaDAO;
import com.loyal.facturacion.model.Persona;

@Controller
@RequestMapping(value="/personas")

public class PersonaController {

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
	public void create(@Valid @RequestBody Persona persona){
		personaDAO.insert(persona);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public @ResponseBody Persona find(@PathVariable Integer id){
		return personaDAO.findById(id);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateR(@RequestBody Persona persona){
		personaDAO.update(persona);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteR(@PathVariable Integer id){
		personaDAO.deleteById(id);
	}
	
	  
}
