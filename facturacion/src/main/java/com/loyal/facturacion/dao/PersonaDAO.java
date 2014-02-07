package com.loyal.facturacion.dao;

import java.util.List;

import com.loyal.facturacion.model.Persona;

public interface PersonaDAO {
	
	public int insert(Persona persona);
	
	public int update(Persona persona);
	
	public Persona findById(Integer id);

	public List<Persona> getAll();

	public int deleteById(Integer id);

}
