package com.loyal.facturacion.dao;

import java.util.List;

import com.loyal.facturacion.model.Cliente;

public interface ClienteDAO {
	
	public void insert(Cliente cliente);
	
	public void update(Cliente cliente);
	
	public Cliente findById(Integer id);

	public List<Cliente> getAll();

}
