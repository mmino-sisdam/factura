package com.loyal.facturacion.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.loyal.facturacion.dao.ClienteDAO;
import com.loyal.facturacion.model.Cliente;

public class ClienteDAOImpl extends JdbcDaoSupport implements ClienteDAO {


	@Override
	@Transactional
	public void insert(Cliente cliente) throws DataAccessException {
		String sql = "INSERT INTO clientes "
				+ "(NOMBRE, CUIT, DIRECCION, LOCALIZACION, TIPO_IVA_ID, TIPO_RETENCION_ID) VALUES (?, ?, ?, ?, ?, ?)";
		getJdbcTemplate().update(
				sql,
				new Object[] { cliente.getNombre(), cliente.getCuit(),
						cliente.getDireccion(), cliente.getLocalizacion(),
						cliente.getIdTipoIVA(), cliente.getIdTipoRetencion() });
	}

	@Override
	public Cliente findById(Integer id) {
		String sql = "SELECT * FROM clientes WHERE CLIENTE_ID = ?";
		Cliente cliente = (Cliente) getJdbcTemplate().queryForObject(
				sql, new Object[] { id }, new ClienteRowMapper());
		return cliente;
	}

	@Override
	public List<Cliente> getAll() {

		String sql = "SELECT * FROM clientes order by nombre";

		List<Cliente> lista = getJdbcTemplate().query(sql, new ClienteRowMapper(), new Object[]{});

		return lista;
	}

	@Override
	public void update(Cliente cliente)  throws DataAccessException{
		String sql = "UPDATE clientes "
				+ "SET NOMBRE = ?, CUIT = ?, DIRECCION = ?, LOCALIZACION = ?, TIPO_IVA_ID = ?, TIPO_RETENCION_ID = ? "
				+ "WHERE CLIENTE_ID = ?";
		getJdbcTemplate().update(
				sql,
				new Object[] { cliente.getNombre(), cliente.getCuit(),
						cliente.getDireccion(), cliente.getLocalizacion(),
						cliente.getIdTipoIVA(), cliente.getIdTipoRetencion() });


	}

	@Override
	public int deleteById(Integer id) throws DataAccessException{
		String sql = "DELETE FROM clientes WHERE CLIENTE_ID = ?";
		return getJdbcTemplate().update(
				sql,
				new Object[] { id });
	}
	
	public class ClienteRowMapper implements RowMapper<Cliente> {
		@Override
		public Cliente mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			Cliente cliente= new Cliente();
			cliente.setId(rs.getInt("CLIENTE_ID"));
			cliente.setNombre(rs.getString("NOMBRE"));
			cliente.setCuit(rs.getString("CUIT"));
			cliente.setDireccion(rs.getString("DIRECCION"));
			cliente.setLocalizacion(rs.getString("LOCALIZACION"));
			cliente.setIdTipoIVA(rs.getInt("TIPO_IVA_ID"));
			cliente.setIdTipoRetencion(rs.getInt("TIPO_RETENCION_ID"));
			return cliente;
		}
	}
}
