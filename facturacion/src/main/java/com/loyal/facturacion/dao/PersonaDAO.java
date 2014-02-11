package com.loyal.facturacion.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;

import com.loyal.facturacion.model.Persona;

public interface PersonaDAO {
	
	public int insert(Persona persona) throws DataAccessException, DuplicateKeyException;
	
	public int update(Persona persona)  throws DataAccessException, DuplicateKeyException;
	
	public Persona findById(Integer id)  throws DataAccessException;

	public List<Persona> getAll(); 

	public int deleteById(Integer id)  throws DataAccessException;

}
