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

import com.loyal.facturacion.dao.FacturaDAO;
import com.loyal.facturacion.dto.FacturaTopListDTO;
import com.loyal.facturacion.model.factura.Factura;
import com.loyal.facturacion.validator.FacturaValidator;

@Controller
@RequestMapping(value="/facturas")

public class FacturaController{

	@Autowired
	FacturaDAO facturaDAO;

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Map<String, Collection<FacturaTopListDTO>> list(){
		Map<String, Collection<FacturaTopListDTO>> results = new HashMap<String, Collection<FacturaTopListDTO>>();
		results.put("invoice", facturaDAO.getAll());
		return results;
	}

	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody ResponseMessage create(@Valid @RequestBody Factura factura){
		facturaDAO.insert(factura);
		return new ResponseMessage(ResponseMessageType.OK);
	}

	@RequestMapping(value="/{idTipo}-{numero}",method=RequestMethod.GET)
	public @ResponseBody Factura find(@PathVariable Integer idTipo, @PathVariable Long numero){
		return facturaDAO.findById(idTipo, numero);
	}
/*
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

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest webRequest){ 
		binder.setValidator(new FacturaValidator());
	}
	
}
