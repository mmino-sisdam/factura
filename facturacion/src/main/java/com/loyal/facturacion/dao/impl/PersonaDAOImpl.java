package com.loyal.facturacion.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.loyal.facturacion.dao.PersonaDAO;
import com.loyal.facturacion.model.Persona;

public class PersonaDAOImpl extends JdbcDaoSupport implements PersonaDAO {


	@Override
	@Transactional
	public void insert(Persona persona) {
		String sql = "INSERT INTO PERSONAS "
				+ "(NOMBRE, APELLIDO, USERNAME, MAIL, TELEFONO, PASSWORD, ACCESS_ENABLED) VALUES (?, ?, ?, ?, ?, ?, ?)";
		getJdbcTemplate().update(
				sql,
				new Object[] { persona.getNombre(), persona.getApellido(),
						persona.getUsername(), persona.getMail(),
						persona.getTelefono(), persona.getPassword(),
						persona.isEnabled() });
	}

	@Override
	public Persona findById(Integer id) {
		String sql = "SELECT * FROM PERSONAS WHERE PERSONA_ID = ?";
		Persona persona = (Persona) getJdbcTemplate().queryForObject(
				sql, new Object[] { id }, new PersonaRowMapper());
		return persona;
	}

	@Override
	public List<Persona> getAll() {

		String sql = "SELECT PERSONA_ID, NOMBRE, APELLIDO, USERNAME, TELEFONO, ACCESS_ENABLED FROM PERSONAS";

		List<Persona> lista = new ArrayList<Persona>();

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (@SuppressWarnings("rawtypes") Map row : rows) {
			Persona persona= new Persona();
			persona.setId(Integer.parseInt(String.valueOf(row.get("PERSONA_ID"))));
			persona.setNombre((String)row.get("NOMBRE"));
			persona.setApellido((String)row.get("APELLIDO"));
			persona.setUsername((String)row.get("USERNAME"));
			persona.setTelefono((String)row.get("TELEFONO"));
			persona.setEnabled((Boolean)row.get("ACCESS_ENABLED")) ;
			lista.add(persona);
		}

		return lista;
	}

	@Override
	public void update(Persona persona) {
		String sql = "UPDATE PERSONAS "
				+ "SET NOMBRE = ?, APELLIDO = ?,  MAIL = ?, TELEFONO = ?, ACCESS_ENABLED = ? "
				+ "WHERE PERSONA_ID = ?";
		getJdbcTemplate().update(
				sql,
				new Object[] { persona.getNombre(), persona.getApellido(),
						persona.getMail(), persona.getTelefono(), 
						persona.isEnabled(),persona.getId() });


	}

	public class PersonaRowMapper implements RowMapper<Object> {
		@Override
		public Object mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			Persona persona= new Persona();
			persona.setId(rs.getInt("PERSONA_ID"));
			persona.setNombre(rs.getString("NOMBRE"));
			persona.setApellido(rs.getString("APELLIDO"));
			persona.setUsername(rs.getString("USERNAME"));
			persona.setTelefono(rs.getString("TELEFONO"));
			persona.setEnabled(rs.getBoolean("ACCESS_ENABLED")) ;
			return persona;
		}
	}
}
