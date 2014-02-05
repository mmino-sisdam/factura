package com.loyal.facturacion.model;

public class Cliente {
	private Integer id;
	private String nombre;
	private String cuit;
	private String direccion;
	private String localizacion;
	private int tipoIVA;
	private int tipoRetencion;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	public int getTipoIVA() {
		return tipoIVA;
	}
	public void setTipoIVA(int tipoIVA) {
		this.tipoIVA = tipoIVA;
	}
	public int getTipoRetencion() {
		return tipoRetencion;
	}
	public void setTipoRetencion(int tipoRetencion) {
		this.tipoRetencion = tipoRetencion;
	}

}
