package com.loyal.facturacion.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.loyal.facturacion.dao.ClienteDAO;
import com.loyal.facturacion.model.Cliente;

@Controller
@RequestMapping(value="/clientes")

public class ClienteController{

	@Autowired
	ClienteDAO clienteDAO;

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> list(){
		Map<String, Object> results = new HashMap<String, Object>();
		results.put("clientes", clienteDAO.getAll());
		return results;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody ResponseMessage create(@Valid @RequestBody Cliente cliente){
		clienteDAO.insert(cliente);
		return new ResponseMessage(ResponseMessageType.OK);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public @ResponseBody Cliente find(@PathVariable Integer id){
		return clienteDAO.findById(id);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ResponseMessage update(@Valid @RequestBody Cliente cliente, @PathVariable Integer id){
		clienteDAO.update(cliente);
		return new ResponseMessage(ResponseMessageType.OK);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ResponseMessage delete(@PathVariable Integer id){
		clienteDAO.deleteById(id);
		return new ResponseMessage(ResponseMessageType.OK);
	}
}
