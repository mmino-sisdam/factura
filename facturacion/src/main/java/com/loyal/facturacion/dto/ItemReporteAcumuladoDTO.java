package com.loyal.facturacion.dto;

import java.math.BigDecimal;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.loyal.facturacion.json.JsonImporteSerializer;

public class ItemReporteAcumuladoDTO {

	private Integer cantidad;
	private String nombre;
	private Integer id;
	private String descripcion;
	
	@JsonSerialize(using=JsonImporteSerializer.class)
	private BigDecimal importeComision;
	@JsonSerialize(using=JsonImporteSerializer.class)
	private BigDecimal importeCosto;
	@JsonSerialize(using=JsonImporteSerializer.class)
	private BigDecimal importeRentabilidad;
	@JsonSerialize(using=JsonImporteSerializer.class)
	private BigDecimal importeSubtotal;
	@JsonSerialize(using=JsonImporteSerializer.class)
	private BigDecimal importeIva;
	@JsonSerialize(using=JsonImporteSerializer.class)
	private BigDecimal importeTotal;
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getImporteComision() {
		return importeComision;
	}
	public void setImporteComision(BigDecimal importeComision) {
		this.importeComision = importeComision;
	}
	public BigDecimal getImporteCosto() {
		return importeCosto;
	}
	public void setImporteCosto(BigDecimal importeCosto) {
		this.importeCosto = importeCosto;
	}
	public BigDecimal getImporteRentabilidad() {
		return importeRentabilidad;
	}
	public void setImporteRentabilidad(BigDecimal importeRentabilidad) {
		this.importeRentabilidad = importeRentabilidad;
	}
	public BigDecimal getImporteSubtotal() {
		return importeSubtotal;
	}
	public void setImporteSubtotal(BigDecimal importeSubtotal) {
		this.importeSubtotal = importeSubtotal;
	}
	public BigDecimal getImporteIva() {
		return importeIva;
	}
	public void setImporteIva(BigDecimal importeIva) {
		this.importeIva = importeIva;
	}
	public BigDecimal getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(BigDecimal importeTotal) {
		this.importeTotal = importeTotal;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
