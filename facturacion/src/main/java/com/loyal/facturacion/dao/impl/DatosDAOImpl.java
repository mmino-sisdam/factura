package com.loyal.facturacion.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.loyal.facturacion.dao.DatosDAO;
import com.loyal.facturacion.dto.DatoDTO;

public class DatosDAOImpl extends JdbcDaoSupport implements DatosDAO {
	private final String[] factura= {"linea_producto", "status", "tipo_factura", "tipo_comision"};
	private final String[] cliente= {"tipo_iva", "tipo_retencion"};

	@Override
	public Map<String, Object> getListForFactura() {
		return getList(factura);
	}
	
	@Override
	public Map<String, Object> getListForCliente() {
		return getList(cliente);
	}
	
	private Map<String, Object> getList(String[] tablas) {
		Map<String,Object> map = new HashMap<String, Object>();
		for (int i = 0; i < tablas.length; i++) {
			String tabla = tablas[i];
			String sql = "SELECT * FROM "+ tabla;
			map.put(tablas[i], getJdbcTemplate().query(sql, new DatoRowMapper(tabla), new Object[]{}));
		}
		return map;
	}
	
	public class DatoRowMapper implements RowMapper<DatoDTO> {
		private String baseKey;
		public DatoRowMapper(String baseKey) {
			this.baseKey = baseKey;
		}

		@Override
		public DatoDTO mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			return new DatoDTO(rs.getInt(baseKey + "_id"),rs.getString("NOMBRE"));
		}
	}
}
