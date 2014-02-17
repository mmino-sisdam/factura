package com.loyal.facturacion.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loyal.facturacion.dao.ReportesDAO;
import com.loyal.facturacion.dto.ReporteDTO;

@Controller
@RequestMapping(value = "/reportes")
public class ResportesController {

	@Autowired
	ReportesDAO reportesDAO;

	@RequestMapping(value = "/vendedor",method = RequestMethod.POST)
	public @ResponseBody
	List<Map<String, Object>> facturacionPorVendedor(@RequestBody ReporteDTO reporteDTO) {
		return reportesDAO.facturacionPorVendedor(reporteDTO.getDesde(), reporteDTO.getHasta());
	}

}
