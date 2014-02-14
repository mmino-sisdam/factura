package com.loyal.facturacion.dao;

import java.util.Date;
import java.util.List;

public interface ReportesDAO {
	
	public List<Object> facturacionPorVendedor(Date desde, Date hasta);

}
