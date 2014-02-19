package com.loyal.facturacion.dao;

import java.util.List;

import com.loyal.facturacion.dto.ItemReporteAcumuladoDTO;
import com.loyal.facturacion.dto.ReporteDTO;
import com.loyal.facturacion.dto.ReportePaginadoDTO;
import com.loyal.facturacion.model.factura.Factura;

public interface ReportesDAO {
	
	public List<ItemReporteAcumuladoDTO> facturacionAcumuladaPorVendedor(ReportePaginadoDTO reporteDTO);

	public List<ItemReporteAcumuladoDTO> facturacionAcumuladaPorLineaProducto(ReportePaginadoDTO reporteDTO);

	public List<ItemReporteAcumuladoDTO> facturacionAcumuladaPorStatus(ReportePaginadoDTO reporteDTO);
	
	public List<Factura> facturacionAVencer(ReportePaginadoDTO reporteDTO);
	
	public List<ItemReporteAcumuladoDTO> indicadorFacturacionCobrada(ReporteDTO reporteDTO);

	public List<ItemReporteAcumuladoDTO> indicadorFacturacionPendiente(ReporteDTO reporteDTO);

	public List<ItemReporteAcumuladoDTO> indicadorFacturacion(ReporteDTO reporteDTO);

}
