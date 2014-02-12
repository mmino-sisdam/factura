package com.loyal.facturacion.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.loyal.facturacion.dao.FacturaDAO;
import com.loyal.facturacion.dto.FacturaListDTO;

@Controller
@RequestMapping(value="/facturas")

public class FacturaController{

	@Autowired
	FacturaDAO facturaDAO;

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Map<String, Collection<FacturaListDTO>> list(){
		Map<String, Collection<FacturaListDTO>> results = new HashMap<String, Collection<FacturaListDTO>>();
		results.put("invoice", facturaDAO.getAll());
		return results;
	}

	/*@RequestMapping(method=RequestMethod.POST)
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
	public @ResponseBody ResponseMessage update(@RequestBody Persona persona){
		personaDAO.update(persona);
		return new ResponseMessage(ResponseMessageType.OK);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ResponseMessage delete(@PathVariable Integer id){
		personaDAO.deleteById(id);
		return new ResponseMessage(ResponseMessageType.OK);
	}*/


}
