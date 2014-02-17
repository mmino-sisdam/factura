package com.loyal.facturacion.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loyal.facturacion.dao.ClienteDAO;
import com.loyal.facturacion.dao.DatosDAO;
import com.loyal.facturacion.dao.PersonaDAO;

@Controller
@RequestMapping(value="/datos")
public class DatosController{

	@Autowired
	DatosDAO datosDAO;
	
	@Autowired
	ClienteDAO clienteDAO;
	
	@Autowired
	PersonaDAO personaDAO;
	
	@RequestMapping(value="/factura", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> listForFactura(){
		Map<String, Object> map = datosDAO.getListForFactura();
		map.putAll(datosDAO.getListForCliente());
		map.put("clientes", clienteDAO.getAll());
		map.put("responsables", personaDAO.getAll());
		return map;
	}

	@RequestMapping(value="/cliente", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> listForCliente(){
		return datosDAO.getListForCliente();
	}	
}
