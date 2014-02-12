package com.loyal.facturacion.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.loyal.facturacion.dao.FacturaDAO;
import com.loyal.facturacion.dto.FacturaTopListDTO;
import com.loyal.facturacion.model.factura.Factura;

public class FacturaDAOImpl extends JdbcDaoSupport implements FacturaDAO {

	private String[] mes = { "ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "JUL",
			"AGO", "SEP", "OCT", "NOV", "DIC" };

	@Override
	@Transactional
	public int insert(Factura factura) throws DataAccessException,
			DuplicateKeyException {
		String sql = "INSERT INTO facturas "
				+ "(NOMBRE, APELLIDO, USERNAME, MAIL, TELEFONO, PASSWORD, ACCESS_ENABLED, ROLE_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		return getJdbcTemplate()
				.update(sql,
						new Object[] { factura.getIdTipoFactura(),
								factura.getNumero() });
	}

	@Override
	public Factura findById(Integer idTipo, Long numero)
			throws DataAccessException {
		String sql = "SELECT PERSONA_ID, MAIL, NOMBRE, APELLIDO, USERNAME, TELEFONO, ACCESS_ENABLED, p.ROLE_ID, ROLE, DESCRIP "
				+ "FROM personas p, roles r "
				+ "WHERE p.ROLE_ID = r.ROLE_ID AND p.PERSONA_ID = ?";
		Factura factura = (Factura) getJdbcTemplate().queryForObject(sql,
				new Object[] { idTipo, numero }, new FacturaRowMapper());
		return factura;
	}

	@Override
	public List<FacturaTopListDTO> getAll() {

		String sql = "SELECT year(fecha_emision) AS year, month(fecha_emision) AS month, SUM(importe_rentabilidad) AS importe_rentabilidad, "
				+ "SUM(importe_total) AS importe_total  "
				+ "FROM facturacion.facturas "
				+ "GROUP BY year(fecha_emision), month(fecha_emision); ";

		List<FacturaTopListDTO> lista = getJdbcTemplate().query(sql,
				new FacturaListDTORowMapper());

		sql = "SELECT f.*, c.nombre AS cliente, tf.nombre AS tipo_factura, s.nombre AS status, pr.apellido ape_respo, pr.nombre AS nom_respo "
				+ "FROM facturas f "
				+ "INNER JOIN clientes c ON c.cliente_id = f.cliente_id "
				+ "INNER JOIN tipo_factura tf ON tf.tipo_factura_id = f.tipo_factura_id "
				+ "INNER JOIN status s ON s.status_id = f.status_id "
				+ "INNER JOIN personas pr ON pr.persona_id = f.persona_responsable_id "
				+ "WHERE year(fecha_emision) = ? AND month(fecha_emision) = ? "
				+ "ORDER BY fecha_emision;";

		for (FacturaTopListDTO facturaListDTO : lista) {
			facturaListDTO.setList(getJdbcTemplate().query(
					sql,
					new FacturaListRowMapper(),
					new Object[] { facturaListDTO.getYear(),
							facturaListDTO.getMonth() }));
		}

		return lista;
	}

	@Override
	public int update(Factura factura) throws DataAccessException,
			DuplicateKeyException {
		String sql = "UPDATE facturas "
				+ "SET NOMBRE = ?, APELLIDO = ?,  MAIL = ?, TELEFONO = ?, ACCESS_ENABLED = ?, ROLE_ID = ? "
				+ "WHERE PERSONA_ID = ?";
		return getJdbcTemplate()
				.update(sql,
						new Object[] { factura.getIdTipoFactura(),
								factura.getNumero() });
	}

	@Override
	public int deleteById(Integer id, Long numero) throws DataAccessException {
		String sql = "DELETE FROM facturas WHERE FACTURA_ID = ?";
		return getJdbcTemplate().update(sql, new Object[] { id, numero });
	}
	
	public class FacturaRowMapper implements RowMapper<Factura> {
		@Override
		public Factura mapRow(ResultSet rs, int rowNum) throws SQLException {
			Factura factura = new Factura();
			factura.setIdTipoFactura(rs.getInt("TIPO_FACTURA_ID"));
			factura.setTipoFactura(rs.getString("TIPO_FACTURA"));
			factura.setNumero(rs.getLong("FACTURA_ID"));
			factura.setFecha(rs.getDate("FECHA_EMISION"));
			factura.setCliente(rs.getString("CLIENTE"));
			factura.setIdCliente(rs.getInt("CLIENTE_ID"));
			factura.setIdResponsable(rs.getInt("PERSONA_RESPONSABLE_ID"));
			factura.setResponsable(rs.getString("APE_RESPO") + ", "
					+ rs.getString("NOM_RESPO"));
			factura.setIdStatus(rs.getInt("STATUS_ID"));
			factura.setStatus(rs.getString("STATUS"));
			factura.setImporteRentabilidad(rs
					.getBigDecimal("IMPORTE_RENTABILIDAD"));
			factura.setImporteTotal(rs.getBigDecimal("IMPORTE_TOTAL"));
			return factura;
		}
	}
	
	public class FacturaListRowMapper implements RowMapper<Factura> {
		@Override
		public Factura mapRow(ResultSet rs, int rowNum) throws SQLException {
			Factura factura = new Factura();
			factura.setIdTipoFactura(rs.getInt("TIPO_FACTURA_ID"));
			factura.setTipoFactura(rs.getString("TIPO_FACTURA"));
			factura.setNumero(rs.getLong("FACTURA_ID"));
			factura.setFecha(rs.getDate("FECHA_EMISION"));
			factura.setCliente(rs.getString("CLIENTE"));
			factura.setIdCliente(rs.getInt("CLIENTE_ID"));
			factura.setIdResponsable(rs.getInt("PERSONA_RESPONSABLE_ID"));
			factura.setResponsable(rs.getString("APE_RESPO") + ", "
					+ rs.getString("NOM_RESPO"));
			factura.setIdStatus(rs.getInt("STATUS_ID"));
			factura.setStatus(rs.getString("STATUS"));
			factura.setImporteRentabilidad(rs
					.getBigDecimal("IMPORTE_RENTABILIDAD"));
			factura.setImporteTotal(rs.getBigDecimal("IMPORTE_TOTAL"));
			return factura;
		}
	}

	public class FacturaListDTORowMapper implements RowMapper<FacturaTopListDTO> {
		@Override
		public FacturaTopListDTO mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			FacturaTopListDTO factura = new FacturaTopListDTO();
			factura.setMonto(rs.getBigDecimal("IMPORTE_TOTAL"));
			factura.setRentabilidad(rs.getBigDecimal("IMPORTE_RENTABILIDAD"));
			Integer month = rs.getInt("MONTH");
			Integer year = rs.getInt("YEAR");
			factura.setMonth(month);
			factura.setYear(year);
			factura.setMonthName(mes[month + 1]);
			return factura;
		}
	}
}
