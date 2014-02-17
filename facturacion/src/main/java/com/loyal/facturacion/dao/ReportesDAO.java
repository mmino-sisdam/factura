package com.loyal.facturacion.dao;

import java.util.List;
import java.util.Map;

import com.loyal.facturacion.dto.ReporteDTO;

public interface ReportesDAO {
	
	public List<Map<String, Object>> facturacionAcumuladaPorVendedor(ReporteDTO reporteDTO);

	public List<Map<String, Object>> facturacionAcumuladaPorLineaProducto(ReporteDTO reporteDTO);

	public List<Map<String, Object>> facturacionAcumuladaPorStatus(ReporteDTO reporteDTO);
	
	public List<Map<String, Object>> facturacionAVencer(ReporteDTO reporteDTO);

}
