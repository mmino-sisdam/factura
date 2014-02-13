package com.loyal.facturacion.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
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
	public int insert(Persona persona) throws DataAccessException, DuplicateKeyException {
		MessageDigestPasswordEncoder m = new MessageDigestPasswordEncoder("MD5");
		String sql = "INSERT INTO personas "
				+ "(NOMBRE, APELLIDO, USERNAME, MAIL, TELEFONO, PASSWORD, ACCESS_ENABLED, ROLE_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		return getJdbcTemplate().update(
				sql,
				new Object[] { persona.getNombre(), persona.getApellido(),
						persona.getUsername(), persona.getMail(),
						persona.getTelefono(),  m.encodePassword(persona.getPassword(), null) ,
						persona.isEnabled(), persona.getRol().getId() });
	}

	@Override
	public Persona findByUsername(String username) throws DataAccessException {
		String sql = "SELECT PERSONA_ID, MAIL, NOMBRE, APELLIDO, USERNAME, TELEFONO, ACCESS_ENABLED, p.ROLE_ID, ROLE, DESCRIP "
				+ "FROM personas p, roles r "
				+ "WHERE p.ROLE_ID = r.ROLE_ID AND p.USERNAME = ?";
		Persona persona = (Persona) getJdbcTemplate().queryForObject(
				sql, new Object[] { username }, new PersonaRowMapper());
		return persona;
	}
	
	@Override
	public Persona findById(Integer id) throws DataAccessException{
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

		List<Persona> lista = getJdbcTemplate().query(sql, new PersonaRowMapper(), new Object[]{});

		return lista;
	}

	@Override
	public int update(Persona persona) throws DataAccessException, DuplicateKeyException {
		String sql = "UPDATE personas "
				+ "SET NOMBRE = ?, APELLIDO = ?,  MAIL = ?, TELEFONO = ?, ACCESS_ENABLED = ?, ROLE_ID = ? "
				+ "WHERE PERSONA_ID = ?";
		return getJdbcTemplate().update(
				sql,
				new Object[] { persona.getNombre(), persona.getApellido(),
						persona.getMail(), persona.getTelefono(), 
						persona.isEnabled(),persona.getRol().getId(), persona.getId() });
	}

	@Override
	public int deleteById(Integer id) throws DataAccessException{
		String sql = "DELETE FROM personas WHERE PERSONA_ID = ?";
		return getJdbcTemplate().update(
				sql,
				new Object[] { id });
	}
	
	public class PersonaRowMapper implements RowMapper<Persona> {
		@Override
		public Persona mapRow(ResultSet rs, int rowNum)
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
	
}
