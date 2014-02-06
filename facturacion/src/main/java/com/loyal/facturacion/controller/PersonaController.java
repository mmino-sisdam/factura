package com.loyal.facturacion.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loyal.facturacion.dao.PersonaDAO;
import com.loyal.facturacion.model.Persona;

@Controller
@RequestMapping(value="/personas")

public class PersonaController {

	@Autowired
	PersonaDAO personaDAO;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void insert(@RequestBody Persona persona){
		personaDAO.insert(persona);
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public @ResponseBody Map<String, Collection<Persona>> list(){
		Map<String, Collection<Persona>> results = new HashMap<String, Collection<Persona>>();
		results.put("usuarios", personaDAO.getAll());
		return results;
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public @ResponseBody Persona get(@RequestParam Integer id){
		return personaDAO.findById(id);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void update(@RequestBody Persona persona){
		personaDAO.update(persona);
	}
}
