package com.loyal.facturacion.model.factura;

import java.math.BigDecimal;

public class FacturaDetalle {
	private String detalle;
	private Integer cantidad;
	private BigDecimal importeUnitario;
	private BigDecimal importeTotal;

	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getImporteUnitario() {
		return importeUnitario;
	}
	public void setImporteUnitario(BigDecimal importeUnitario) {
		this.importeUnitario = importeUnitario;
	}
	public BigDecimal getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(BigDecimal importeTotal) {
		this.importeTotal = importeTotal;
	}
	
}
