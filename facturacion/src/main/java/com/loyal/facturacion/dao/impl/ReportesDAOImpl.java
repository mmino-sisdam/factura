package com.loyal.facturacion.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.loyal.facturacion.dao.ReportesDAO;

public class ReportesDAOImpl extends JdbcDaoSupport implements ReportesDAO {

	@Override
	public List<Map<String, Object>> facturacionPorVendedor(Date desde, Date hasta) {
		
		String sql = "SELECT count(*) AS cantidad, "
				+ "p.apellido, p.nombre, f.persona_responsable_id as idPersonaResponsable,"
				+ "sum(importe_comision) AS importeComision, "
				+ "sum(importe_costo) AS importeCosto, "
				+ "sum(importe_rentabilidad) AS importeRentabilidad, "
				+ "sum(importe_subtotal) AS importeSubtotal, "
				+ "sum(importe_iva) AS importeIva, "
				+ "sum(importe_total) AS importeTotal "
				+ "FROM facturas f "
				+ "INNER JOIN personas p on p.persona_id = f.persona_responsable_id "
				+ "WHERE fecha_emision between ? and ? "
				+ "GROUP BY persona_responsable_id "
				+ "ORDER BY apellido, nombre";
		
		return query(sql, desde, hasta);
		
	}
	
	@Override
	public List<Map<String, Object>> facturacionPorLineaProducto(Date desde, Date hasta) {
		
		String sql = "SELECT count(*) AS cantidad, "
				+ "l.nombre, l.linea_producto_id as idLineaProducto,"
				+ "sum(importe_comision) AS importeComision, "
				+ "sum(importe_costo) AS importeCosto, "
				+ "sum(importe_rentabilidad) AS importeRentabilidad, "
				+ "sum(importe_subtotal) AS importeSubtotal, "
				+ "sum(importe_iva) AS importeIva, "
				+ "sum(importe_total) AS importeTotal "
				+ "FROM facturas f "
				+ "INNER JOIN linea_producto l on l.linea_producto_id = f.linea_producto_id "
				+ "WHERE fecha_emision between ? and ? "
				+ "GROUP BY l.linea_producto_id "
				+ "ORDER BY .l.nombre";
		
		return query(sql, desde, hasta);
		
	}
	
	private List<Map<String, Object>> query(String sql, Date desde, Date hasta) {
		return getJdbcTemplate().queryForList(sql, new Object[]{desde, hasta});
	}
	
}
