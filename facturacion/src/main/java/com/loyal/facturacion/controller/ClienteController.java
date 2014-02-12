package com.loyal.facturacion.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.loyal.facturacion.dao.ClienteDAO;
import com.loyal.facturacion.model.Cliente;

@Controller
@RequestMapping(value="/clientes")

public class ClienteController{

	@Autowired
	ClienteDAO clienteDAO;

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Map<String, Collection<Cliente>> list(){
		Map<String, Collection<Cliente>> results = new HashMap<String, Collection<Cliente>>();
		results.put("clientes", clienteDAO.getAll());
		return results;
	}

}
