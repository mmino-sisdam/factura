package com.loyal.facturacion.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;

import com.loyal.facturacion.dto.FacturaHeadListDTO;
import com.loyal.facturacion.model.factura.Factura;

public interface FacturaDAO {
	
	public int insert(Factura factura) throws DataAccessException, DuplicateKeyException;
	
	public int update(Factura factura)  throws DataAccessException, DuplicateKeyException;
	
	public Factura findById(Integer tipo, Long numero)  throws DataAccessException;

	public List<FacturaHeadListDTO> getAll(); 

	public int deleteById(Integer tipo, Long id)  throws DataAccessException;

}
