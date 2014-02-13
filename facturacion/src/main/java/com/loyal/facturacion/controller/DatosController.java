package com.loyal.facturacion.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.loyal.facturacion.dao.DatosDAO;
import com.loyal.facturacion.dto.DatoDTO;

@Controller
@RequestMapping(value="/datos")
public class DatosController{

	@Autowired
	DatosDAO datosDAO;
	
	@RequestMapping(value="/factura", method=RequestMethod.GET)
	public @ResponseBody Map<String, List<DatoDTO>> listForFactura(){
		Map<String, List<DatoDTO>> map = datosDAO.getListForFactura();
		datosDAO.getListForFactura().putAll(datosDAO.getListForCliente());
		return map;
	}

	@RequestMapping(value="/cliente", method=RequestMethod.GET)
	public @ResponseBody Map<String, List<DatoDTO>> listForCliente(){
		return datosDAO.getListForCliente();
	}	
}
