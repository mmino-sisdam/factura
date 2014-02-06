package com.loyal.facturacion.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.loyal.facturacion.dao.PersonaDAO;
import com.loyal.facturacion.model.Persona;
import com.loyal.facturacion.model.Rol;

public class PersonaDAOImpl extends JdbcDaoSupport implements PersonaDAO {


	@Override
	@Transactional
	public void insert(Persona persona) {
		MessageDigestPasswordEncoder m = new MessageDigestPasswordEncoder("MD5");
		String sql = "INSERT INTO personas "
				+ "(NOMBRE, APELLIDO, USERNAME, MAIL, TELEFONO, PASSWORD, ACCESS_ENABLED, ROLE_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		getJdbcTemplate().update(
				sql,
				new Object[] { persona.getNombre(), persona.getApellido(),
						persona.getUsername(), persona.getMail(),
						persona.getTelefono(),  m.encodePassword(persona.getPassword(), null) ,
						persona.isEnabled(), persona.getRol().getId() });
	}

	@Override
	public Persona findById(Integer id) {
		String sql = "SELECT PERSONA_ID, MAIL, NOMBRE, APELLIDO, USERNAME, TELEFONO, ACCESS_ENABLED, p.ROLE_ID, ROLE, DESCRIP "
				+ "FROM personas p, roles r "
				+ "WHERE p.ROLE_ID = r.ROLE_ID AND p.PERSONA_ID = ?";
		Persona persona = (Persona) getJdbcTemplate().queryForObject(
				sql, new Object[] { id }, new PersonaRowMapper());
		return persona;
	}

	@Override
	public List<Persona> getAll() {

		String sql = "SELECT PERSONA_ID, MAIL, NOMBRE, APELLIDO, USERNAME, TELEFONO, ACCESS_ENABLED, p.ROLE_ID, ROLE, DESCRIP "
				+ "FROM personas p, roles r "
				+ "WHERE p.ROLE_ID = r.ROLE_ID;";

		List<Persona> lista = new ArrayList<Persona>();

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (@SuppressWarnings("rawtypes") Map row : rows) {
			Persona persona= new Persona();
			persona.setId(Integer.parseInt(String.valueOf(row.get("PERSONA_ID"))));
			persona.setNombre((String)row.get("NOMBRE"));
			persona.setMail((String)row.get("MAIL"));
			persona.setApellido((String)row.get("APELLIDO"));
			persona.setUsername((String)row.get("USERNAME"));
			persona.setTelefono((String)row.get("TELEFONO"));
			persona.setEnabled((Boolean)row.get("ACCESS_ENABLED")) ;
			Rol rol = new Rol();
			rol.setId(Integer.parseInt(String.valueOf(row.get("ROLE_ID"))));
			rol.setDescripcion((String)row.get("DESCRIP"));
			rol.setRole((String)row.get("ROLE"));
			persona.setRol(rol);
			lista.add(persona);
		}

		return lista;
	}

	@Override
	public void update(Persona persona) {
		String sql = "UPDATE personas "
				+ "SET NOMBRE = ?, APELLIDO = ?,  MAIL = ?, TELEFONO = ?, ACCESS_ENABLED = ?, ROLE_ID = ? "
				+ "WHERE PERSONA_ID = ?";
		getJdbcTemplate().update(
				sql,
				new Object[] { persona.getNombre(), persona.getApellido(),
						persona.getMail(), persona.getTelefono(), 
						persona.isEnabled(),persona.getRol().getId(), persona.getId() });
	}

	public class PersonaRowMapper implements RowMapper<Object> {
		@Override
		public Object mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			Persona persona= new Persona();
			persona.setId(rs.getInt("PERSONA_ID"));
			persona.setNombre(rs.getString("NOMBRE"));
			persona.setMail(rs.getString("MAIL"));
			persona.setApellido(rs.getString("APELLIDO"));
			persona.setUsername(rs.getString("USERNAME"));
			persona.setTelefono(rs.getString("TELEFONO"));
			persona.setEnabled(rs.getBoolean("ACCESS_ENABLED")) ;
			Rol rol = new Rol();
			rol.setId(rs.getInt("ROLE_ID"));
			rol.setDescripcion(rs.getString("DESCRIP"));
			rol.setRole(rs.getString("ROLE"));
			persona.setRol(rol);
			return persona;
		}
	}
	
	@Override
	public void deleteById(Integer id) {
		String sql = "DELETE FROM personas WHERE PERSONA_ID = ?";
		getJdbcTemplate().update(
				sql,
				new Object[] { id });
	}
}
