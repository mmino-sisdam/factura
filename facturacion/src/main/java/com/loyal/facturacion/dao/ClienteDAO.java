package com.loyal.facturacion.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.loyal.facturacion.model.Cliente;

public interface ClienteDAO {
	
	public void insert(Cliente cliente) throws DataAccessException; 
	
	public void update(Cliente cliente) throws DataAccessException;
	
	public Cliente findById(Integer id);

	public List<Cliente> getAll();

}
