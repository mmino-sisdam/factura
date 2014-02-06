package com.loyal.facturacion.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loyal.facturacion.dao.PersonaDAO;
import com.loyal.facturacion.model.Persona;
import com.loyal.facturacion.model.Rol;

@Controller
@RequestMapping(value="/personas")

public class PersonaController {

	@Autowired
	PersonaDAO personaDAO;

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void insert(@ModelAttribute Persona persona){
		
		personaDAO.insert(persona);
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
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
	public void update(@ModelAttribute Persona persona){
		personaDAO.update(persona);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public void delete(@RequestParam Integer id){
		personaDAO.deleteById(id);
	}
	
	// REST
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public @ResponseBody Persona find(@PathVariable Integer id){
		return personaDAO.findById(id);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public void updateR(@ModelAttribute Persona persona){
		personaDAO.update(persona);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public void deleteR(@PathVariable Integer id){
		personaDAO.deleteById(id);
	}
}
