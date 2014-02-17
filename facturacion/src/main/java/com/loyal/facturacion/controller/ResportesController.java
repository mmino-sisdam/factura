package com.loyal.facturacion.controller;

import java.util.HashMap;
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

	@RequestMapping(value = "/vendedor", method = RequestMethod.POST)
	public @ResponseBody
	ReporteDTO facturacionPorVendedor(@RequestBody ReporteDTO reporteDTO) {
		Map<String, List<Map<String, Object>>> map =  new HashMap<String, List<Map<String,Object>>>();
		map.put("vendedor",reportesDAO.facturacionAcumuladaPorVendedor(reporteDTO));
		reporteDTO.setResultado(map);
		return reporteDTO;
	}

	@RequestMapping(value = "/producto", method = RequestMethod.POST)
	public @ResponseBody
	ReporteDTO facturacionPorLineaProducto(@RequestBody ReporteDTO reporteDTO) {
		Map<String, List<Map<String, Object>>> map =  new HashMap<String, List<Map<String,Object>>>();
		map.put("producto",reportesDAO.facturacionAcumuladaPorLineaProducto(reporteDTO));
		reporteDTO.setResultado(map);
		return reporteDTO;
	}

	@RequestMapping(value = "/status", method = RequestMethod.POST)
	public @ResponseBody
	ReporteDTO facturacionPorStatus(@RequestBody ReporteDTO reporteDTO) {
		Map<String, List<Map<String, Object>>> map =  new HashMap<String, List<Map<String,Object>>>();
		map.put("status", reportesDAO.facturacionAcumuladaPorStatus(reporteDTO));
		reporteDTO.setResultado(map);
		return reporteDTO;
	}
	
	@RequestMapping(value = "/vencimiento", method = RequestMethod.POST)
	public @ResponseBody
	ReporteDTO facturacionAVencer(@RequestBody ReporteDTO reporteDTO) {
		Map<String, List<Map<String, Object>>> map =  new HashMap<String, List<Map<String,Object>>>();
		map.put("vencimiento", reportesDAO.facturacionAVencer(reporteDTO));
		reporteDTO.setResultado(map);
		return reporteDTO;
	}
	
	@RequestMapping(value = "/indicadores", method = RequestMethod.POST)
	public @ResponseBody
	ReporteDTO facturacionIndicadores(@RequestBody ReporteDTO reporteDTO) {
		Map<String, List<Map<String, Object>>> map =  new HashMap<String, List<Map<String,Object>>>();
		map.put("cobrada", reportesDAO.indicadorFacturacionCobrada(reporteDTO));
		map.put("pendiente", reportesDAO.indicadorFacturacionPendiente(reporteDTO));
		map.put("ventas", reportesDAO.indicadorFacturacion(reporteDTO));
		reporteDTO.setResultado(map);
		return reporteDTO;
	}


}
