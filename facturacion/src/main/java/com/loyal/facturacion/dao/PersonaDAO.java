package com.loyal.facturacion.dao;

import java.util.List;

import com.loyal.facturacion.model.Persona;

public interface PersonaDAO {
	
	public void insert(Persona persona);
	
	public void update(Persona persona);
	
	public Persona findById(Integer id);

	public List<Persona> getAll();

	public void deleteById(Integer id);

}
