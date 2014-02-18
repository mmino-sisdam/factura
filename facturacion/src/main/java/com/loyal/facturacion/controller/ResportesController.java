package com.loyal.facturacion.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loyal.facturacion.dao.ReportesDAO;
import com.loyal.facturacion.dto.ReporteDTO;
import com.loyal.facturacion.dto.ReportePaginadoDTO;

@Controller
@RequestMapping(value = "/reportes")
public class ResportesController {

	@Autowired
	ReportesDAO reportesDAO;

	@RequestMapping(value = "/vendedor", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ReportePaginadoDTO> facturacionPorVendedor(@RequestBody ReportePaginadoDTO reporteDTO) {
		Map<String, ReportePaginadoDTO> map =  new HashMap<String, ReportePaginadoDTO>();
		reporteDTO.setResultado(reportesDAO.facturacionAcumuladaPorVendedor(reporteDTO));
		map.put("vendedor",reporteDTO);
		return map;
	}

	@RequestMapping(value = "/producto", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ReportePaginadoDTO> facturacionPorLineaProducto(@RequestBody ReportePaginadoDTO reporteDTO) {
		Map<String, ReportePaginadoDTO> map =  new HashMap<String, ReportePaginadoDTO>();
		reporteDTO.setResultado(reportesDAO.facturacionAcumuladaPorLineaProducto(reporteDTO));
		map.put("producto", reporteDTO);
		return map;
	}

	@RequestMapping(value = "/status", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ReportePaginadoDTO> facturacionPorStatus(@RequestBody ReportePaginadoDTO reporteDTO) {
		Map<String, ReportePaginadoDTO> map =  new HashMap<String, ReportePaginadoDTO>();
		reporteDTO.setResultado(reportesDAO.facturacionAcumuladaPorStatus(reporteDTO));
		map.put("status", reporteDTO);
		return map;
	}
	
	@RequestMapping(value = "/vencimiento", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ReportePaginadoDTO> facturacionAVencer(@RequestBody ReportePaginadoDTO reporteDTO) {
		Map<String, ReportePaginadoDTO> map =  new HashMap<String, ReportePaginadoDTO>();
		reporteDTO.setResultado(reportesDAO.facturacionAVencer(reporteDTO));
		map.put("vencimiento", reporteDTO);
		return map;
	}
	
	@RequestMapping(value = "/indicadorPendiente", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ReporteDTO> indicadorPendiente(@RequestBody ReporteDTO reporteDTO) {
		Map<String, ReporteDTO> map =  new HashMap<String, ReporteDTO>();
		reporteDTO.setResultado(reportesDAO.indicadorFacturacionPendiente(reporteDTO));
		map.put("pendiente", reporteDTO);
		return map;
	}
	
	@RequestMapping(value = "/indicadorCobrado", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ReporteDTO> indicadorCobrado(@RequestBody ReporteDTO reporteDTO) {
		Map<String, ReporteDTO> map =  new HashMap<String, ReporteDTO>();
		reporteDTO.setResultado(reportesDAO.indicadorFacturacionCobrada(reporteDTO));
		map.put("cobrado", reporteDTO);
		return map;
	}
	
	@RequestMapping(value = "/indicadorVentas", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ReporteDTO> indicadorVentas(@RequestBody ReporteDTO reporteDTO) {
		Map<String, ReporteDTO> map =  new HashMap<String, ReporteDTO>();
		reporteDTO.setResultado(reportesDAO.indicadorFacturacion(reporteDTO));
		map.put("ventas", reporteDTO);
		return map;
	}


}
