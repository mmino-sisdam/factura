package com.loyal.facturacion.controller;

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

	@RequestMapping(value = "/vendedor", method = RequestMethod.POST)
	public @ResponseBody
	ReporteDTO facturacionPorVendedor(@RequestBody ReporteDTO reporteDTO) {
		reporteDTO.setResultado(reportesDAO.facturacionAcumuladaPorVendedor(reporteDTO));
		return reporteDTO;
	}

	@RequestMapping(value = "/producto", method = RequestMethod.POST)
	public @ResponseBody
	ReporteDTO facturacionPorLineaProducto(@RequestBody ReporteDTO reporteDTO) {
		reporteDTO.setResultado(reportesDAO.facturacionAcumuladaPorLineaProducto(reporteDTO));
		return reporteDTO;
	}

	@RequestMapping(value = "/status", method = RequestMethod.POST)
	public @ResponseBody
	ReporteDTO facturacionPorStatus(@RequestBody ReporteDTO reporteDTO) {
		reporteDTO.setResultado(reportesDAO.facturacionAcumuladaPorStatus(reporteDTO));
		return reporteDTO;
	}
	
	@RequestMapping(value = "/vencimiento", method = RequestMethod.POST)
	public @ResponseBody
	ReporteDTO facturacionAVencer(@RequestBody ReporteDTO reporteDTO) {
		reporteDTO.setResultado(reportesDAO.facturacionAVencer(reporteDTO));
		return reporteDTO;
	}

}
