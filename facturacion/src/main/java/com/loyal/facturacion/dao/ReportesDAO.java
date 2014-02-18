package com.loyal.facturacion.dao;

import java.util.List;
import java.util.Map;

import com.loyal.facturacion.dto.ReporteDTO;
import com.loyal.facturacion.dto.ReportePaginadoDTO;

public interface ReportesDAO {
	
	public List<Map<String, Object>> facturacionAcumuladaPorVendedor(ReportePaginadoDTO reporteDTO);

	public List<Map<String, Object>> facturacionAcumuladaPorLineaProducto(ReportePaginadoDTO reporteDTO);

	public List<Map<String, Object>> facturacionAcumuladaPorStatus(ReportePaginadoDTO reporteDTO);
	
	public List<Map<String, Object>> facturacionAVencer(ReportePaginadoDTO reporteDTO);
	
	public List<Map<String, Object>> indicadorFacturacionCobrada(ReporteDTO reporteDTO);

	public List<Map<String, Object>> indicadorFacturacionPendiente(ReporteDTO reporteDTO);

	public List<Map<String, Object>> indicadorFacturacion(ReporteDTO reporteDTO);

}
