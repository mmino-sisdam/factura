package com.loyal.facturacion.dao;

import java.util.List;

import com.loyal.facturacion.dto.FacturaListDTO;
import com.loyal.facturacion.dto.ItemReporteAcumuladoDTO;
import com.loyal.facturacion.dto.ReporteIndicadorDTO;
import com.loyal.facturacion.dto.ReportePaginadoDTO;

public interface ReportesDAO {
	
	public List<ItemReporteAcumuladoDTO> facturacionAcumuladaPorVendedor(ReportePaginadoDTO reporteDTO);

	public List<ItemReporteAcumuladoDTO> facturacionAcumuladaPorLineaProducto(ReportePaginadoDTO reporteDTO);

	public List<ItemReporteAcumuladoDTO> facturacionAcumuladaPorStatus(ReportePaginadoDTO reporteDTO);
	
	public List<FacturaListDTO> facturacionAVencer(ReportePaginadoDTO reporteDTO);
	
	public List<ItemReporteAcumuladoDTO> indicadorFacturacionCobrada(ReporteIndicadorDTO reporteDTO);

	public List<ItemReporteAcumuladoDTO> indicadorFacturacionPendiente(ReporteIndicadorDTO reporteDTO);

	public List<ItemReporteAcumuladoDTO> indicadorFacturacion(ReporteIndicadorDTO reporteDTO);

	public List<ItemReporteAcumuladoDTO> indicadorFacturacionVencida(
			ReporteIndicadorDTO reporteDTO);

}
