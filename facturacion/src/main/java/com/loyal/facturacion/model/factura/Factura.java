package com.loyal.facturacion.model.factura;

import java.math.BigDecimal;
import java.util.Date;

public class Factura {
	private Integer idTipoFactura;
	private String tipoFactura;
	
	private Long numero;
	
	private Integer idCliente;
	private String cliente;
	
	private Integer idResponsable;
	private String responsable;
	
	private Date fecha;
	private Integer idStatus;
	private String status;
	
	private BigDecimal importeTotal;
	private BigDecimal importeRentabilidad;
	
	public Integer getIdTipoFactura() {
		return idTipoFactura;
	}
	public void setIdTipoFactura(Integer idTipoFactura) {
		this.idTipoFactura = idTipoFactura;
	}
	public String getTipoFactura() {
		return tipoFactura;
	}
	public void setTipoFactura(String tipoFactura) {
		this.tipoFactura = tipoFactura;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public Integer getIdResponsable() {
		return idResponsable;
	}
	public void setIdResponsable(Integer idResponsable) {
		this.idResponsable = idResponsable;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}
	public BigDecimal getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(BigDecimal importeTotal) {
		this.importeTotal = importeTotal;
	}
	public BigDecimal getImporteRentabilidad() {
		return importeRentabilidad;
	}
	public void setImporteRentabilidad(BigDecimal importeRentabilidad) {
		this.importeRentabilidad = importeRentabilidad;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
