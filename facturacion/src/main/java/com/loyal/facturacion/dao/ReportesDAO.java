package com.loyal.facturacion.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ReportesDAO {
	
	public List<Map<String, Object>> facturacionPorVendedor(Date desde, Date hasta);

	public List<Map<String, Object>> facturacionPorLineaProducto(Date desde, Date hasta);

}
