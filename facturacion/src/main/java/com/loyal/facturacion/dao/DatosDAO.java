package com.loyal.facturacion.dao;

import java.util.List;


import java.util.Map;

import com.loyal.facturacion.dto.DatoDTO;

public interface DatosDAO {
	
	public Map<String,List<DatoDTO>> getListForFactura(); 
	
	public Map<String,List<DatoDTO>> getListForCliente();

}
