package com.loyal.facturacion.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.loyal.facturacion.dao.ReportesDAO;

public class ReportesDAOImpl extends JdbcDaoSupport implements ReportesDAO {

	@Override
	public List<Object> facturacionPorVendedor(Date desde, Date hasta) {
		
		String sql = "SELECT count(*) AS cantidad, "
				+ "sum(importe_comision) AS importe_comision, "
				+ "sum(importe_costo) AS importe_costo, "
				+ "sum(importe_rentabilidad) AS importe_rentabilidad, "
				+ "sum(importe_subtotal) AS importe_subtotal, "
				+ "sum(importe_iva) AS importe_iva, "
				+ "sum(importe_total) AS importe_total, "
				+ "FROM facturas f "
				+ "INNER JOIN personas p on p.persona_id = f.persona_responsable_id "
				+ "WHERE fecha_emision between ? and ? "
				+ "GROUP BY persona_responsable_id "
				+ "ORDER BY apellido, nombre";
		
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql, new Object[]{desde, hasta});
		
		return new ArrayList<Object>();
		
	}
}
