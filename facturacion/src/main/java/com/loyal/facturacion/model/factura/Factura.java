package com.loyal.facturacion.model.factura;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.loyal.facturacion.json.JsonDateDeserializer;
import com.loyal.facturacion.json.JsonDateSerializer;

public class Factura {
	private Integer idTipoFactura; //
	private String tipoFactura;
	
	private Long numero; //
	
	private Integer idCliente; //
	private String cliente;
	
	private Integer idResponsable; // 
	private String responsable;
	
	@JsonDeserialize(using = JsonDateDeserializer.class) 
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date fecha; //
	private Integer idStatus; // 
	private String status;
	
	private String contacto;
	private Integer idUsuario;
	
	private Integer idLineaProducto; // 
	
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date fechaVencimiento; // 
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date fechaProbableCobro; // 
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date fechaCobro; //
	
	private Integer idTipoRetencion; //
	private Integer idTipoIVA; //
	
	private BigDecimal importeSubtotal;
	private BigDecimal importeIVA; // 
	private BigDecimal importeTotal; //
	
	private Integer idTipoComision; //
	private BigDecimal importeComision;
	
	private BigDecimal importeCosto; // 
	
	private Integer idTipoComprobableEntregable;
	private Date fechaComprobableEntregable;
	
	private BigDecimal importeCobrado;
	
	private BigDecimal importeRentabilidad; // 
	
	private String formaDePago; //
	
	private String remito; // 
	private String ordenDeCompra; // 
	
	private List<FacturaDetalle> detalles; //
	
	
	public Integer getIdTipoFactura() {
		return idTipoFactura; //
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
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdLineaProducto() {
		return idLineaProducto;
	}
	public void setIdLineaProducto(Integer idLineaProducto) {
		this.idLineaProducto = idLineaProducto;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Date getFechaProbableCobro() {
		return fechaProbableCobro;
	}
	public void setFechaProbableCobro(Date fechaProbableCobro) {
		this.fechaProbableCobro = fechaProbableCobro;
	}
	public Date getFechaCobro() {
		return fechaCobro;
	}
	public void setFechaCobro(Date fechaCobro) {
		this.fechaCobro = fechaCobro;
	}
	public Integer getIdTipoRetencion() {
		return idTipoRetencion;
	}
	public void setIdTipoRetencion(Integer idTipoRetencion) {
		this.idTipoRetencion = idTipoRetencion;
	}
	public Integer getIdTipoIVA() {
		return idTipoIVA;
	}
	public void setIdTipoIVA(Integer idTipoIVA) {
		this.idTipoIVA = idTipoIVA;
	}
	public BigDecimal getImporteSubtotal() {
		return importeSubtotal;
	}
	public void setImporteSubtotal(BigDecimal importeSubtotal) {
		this.importeSubtotal = importeSubtotal;
	}
	public BigDecimal getImporteIVA() {
		return importeIVA;
	}
	public void setImporteIVA(BigDecimal importeIVA) {
		this.importeIVA = importeIVA;
	}
	public Integer getIdTipoComision() {
		return idTipoComision;
	}
	public void setIdTipoComision(Integer idTipoComision) {
		this.idTipoComision = idTipoComision;
	}
	public BigDecimal getImporteComision() {
		return importeComision;
	}
	public void setImporteComision(BigDecimal importeComision) {
		this.importeComision = importeComision;
	}
	public Integer getIdTipoComprobableEntregable() {
		return idTipoComprobableEntregable;
	}
	public void setIdTipoComprobableEntregable(Integer idTipoComprobableEntregable) {
		this.idTipoComprobableEntregable = idTipoComprobableEntregable;
	}
	public BigDecimal getImporteCobrado() {
		return importeCobrado;
	}
	public void setImporteCobrado(BigDecimal importeCobrado) {
		this.importeCobrado = importeCobrado;
	}
	public String getFormaDePago() {
		return formaDePago;
	}
	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}
	public String getRemito() {
		return remito;
	}
	public void setRemito(String remito) {
		this.remito = remito;
	}
	public String getOrdenDeCompra() {
		return ordenDeCompra;
	}
	public void setOrdenDeCompra(String ordenDeCompra) {
		this.ordenDeCompra = ordenDeCompra;
	}
	public List<FacturaDetalle> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<FacturaDetalle> detalles) {
		this.detalles = detalles;
	}
	public BigDecimal getImporteCosto() {
		return importeCosto;
	}
	public void setImporteCosto(BigDecimal importeCosto) {
		this.importeCosto = importeCosto;
	}
	public Date getFechaComprobableEntregable() {
		return fechaComprobableEntregable;
	}
	public void setFechaComprobableEntregable(Date fechaComprobableEntregable) {
		this.fechaComprobableEntregable = fechaComprobableEntregable;
	}
	
}
