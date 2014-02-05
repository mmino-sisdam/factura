package com.loyal.facturacion.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.loyal.facturacion.dao.ClienteDAO;
import com.loyal.facturacion.model.Cliente;

public class ClienteDAOImpl extends JdbcDaoSupport implements ClienteDAO {


	@Override
	@Transactional
	public void insert(Cliente cliente) {
		String sql = "INSERT INTO CLIENTES "
				+ "(NOMBRE, CUIT, DIRECCION, LOCALIZACION, TIPO_IVA, TIPO_RETENCION) VALUES (?, ?, ?, ?, ?, ?)";
		getJdbcTemplate().update(
				sql,
				new Object[] { cliente.getNombre(), cliente.getCuit(),
						cliente.getDireccion(), cliente.getLocalizacion(),
						cliente.getTipoIVA(), cliente.getTipoRetencion() });
	}

	@Override
	public Cliente findById(Integer id) {
		String sql = "SELECT * FROM CLIENTES WHERE CLIENTE_ID = ?";
		Cliente cliente = (Cliente) getJdbcTemplate().queryForObject(
				sql, new Object[] { id }, new ClienteRowMapper());
		return cliente;
	}

	@Override
	public List<Cliente> getAll() {

		String sql = "SELECT * FROM CLIENTES";

		List<Cliente> lista = new ArrayList<Cliente>();

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (@SuppressWarnings("rawtypes") Map row : rows) {
			Cliente cliente  = new Cliente();
			cliente.setId(Integer.parseInt(String.valueOf(row.get("CLIENTE_ID"))));
			cliente.setCuit((String)row.get("CUIT"));
			cliente.setNombre((String)row.get("NOMBRE"));
			cliente.setDireccion((String)row.get("DIRECCION"));
			cliente.setLocalizacion((String)row.get("LOCALIZACION"));
			cliente.setTipoIVA(Integer.parseInt((String)row.get("TIPO_IVA")));
			cliente.setTipoRetencion(Integer.parseInt((String)row.get("TIPO_RETENCION")));
			lista.add(cliente);
		}

		return lista;
	}

	@Override
	public void update(Cliente cliente) {
		String sql = "UPDATE CLIENTES "
				+ "SET NOMBRE = ?, CUIT = ?, DIRECCION = ?, LOCALIZACION = ?, TIPO_IVA = ?, TIPO_RETENCION = ? "
				+ "WHERE CLIENTE_ID = ?";
		getJdbcTemplate().update(
				sql,
				new Object[] { cliente.getNombre(), cliente.getCuit(),
						cliente.getDireccion(), cliente.getLocalizacion(),
						cliente.getTipoIVA(), cliente.getTipoRetencion() });


	}

	public class ClienteRowMapper implements RowMapper<Object> {
		@Override
		public Object mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			Cliente cliente= new Cliente();
			cliente.setId(rs.getInt("CLIENTE_ID"));
			cliente.setNombre(rs.getString("NOMBRE"));
			cliente.setCuit(rs.getString("CUIT"));
			cliente.setDireccion(rs.getString("DIRECCION"));
			cliente.setLocalizacion(rs.getString("LOCALIZACION"));
			cliente.setTipoIVA(rs.getInt("TIPO_IVA"));
			cliente.setTipoRetencion(rs.getInt("TIPO_RETENCION"));
			return cliente;
		}
	}
}
