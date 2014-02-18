package com.loyal.facturacion.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loyal.facturacion.dao.ReportesDAO;
import com.loyal.facturacion.dto.ReporteIndicadorDTO;
import com.loyal.facturacion.dto.ReportePaginadoDTO;

@Controller
@RequestMapping(value = "/reportes")
public class ResportesController {

	@Autowired
	ReportesDAO reportesDAO;

	@RequestMapping(value = "/vendedor", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, ReportePaginadoDTO> facturacionPorVendedorGet(@ModelAttribute ReportePaginadoDTO reporteDTO) {
		Map<String, ReportePaginadoDTO> map =  new HashMap<String, ReportePaginadoDTO>();
		reporteDTO.setResultado(reportesDAO.facturacionAcumuladaPorVendedor(reporteDTO));
		map.put("vendedor",reporteDTO);
		return map;
	}
	
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
	
	@RequestMapping(value = "/indicadores", method = RequestMethod.POST)
	public @ResponseBody
	ReporteIndicadorDTO indicadores(@RequestBody ReporteIndicadorDTO reporteDTO) {
		reporteDTO.getResultado().put("pendiente", reportesDAO.indicadorFacturacionPendiente(reporteDTO));
		reporteDTO.getResultado().put("cobrado", reportesDAO.indicadorFacturacionCobrada(reporteDTO));
		reporteDTO.getResultado().put("ventas", reportesDAO.indicadorFacturacion(reporteDTO));
		return reporteDTO;
	}

}
