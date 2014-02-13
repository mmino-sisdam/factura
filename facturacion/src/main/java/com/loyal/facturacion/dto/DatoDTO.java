package com.loyal.facturacion.dto;

public class DatoDTO {

    private Integer id;
    private String nombre;
	public DatoDTO(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public Integer getId() {
		return id;
	}
}
