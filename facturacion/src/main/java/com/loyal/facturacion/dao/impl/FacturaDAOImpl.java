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
import com.loyal.facturacion.model.factura.FacturaDetalle;

public class FacturaDAOImpl extends JdbcDaoSupport implements FacturaDAO {

	private String[] mes = { "ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "JUL",
			"AGO", "SEP", "OCT", "NOV", "DIC" };

	@Override
	@Transactional
	public int insert(Factura factura) throws DataAccessException,
			DuplicateKeyException {
		int result = insertEncabezado(factura);
		if (result > 0) {
			for (FacturaDetalle detalle : factura.getDetalles()) {
				insertDetalle(factura.getIdTipoFactura(), factura.getNumero(),
						detalle);
			}

		}
		return result;
	}

	@Override
	@Transactional
	public Factura findById(Integer idTipo, Long numero)
			throws DataAccessException {
		Factura factura = findEncabezadoId(idTipo, numero);
		if (factura != null) {
			factura.setDetalles(findDetallesId(idTipo, numero));
		}
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
	@Transactional
	public int update(Factura factura) throws DataAccessException,
			DuplicateKeyException {
		int result = updateEncabezado(factura);
		if (result > 0) {
			for (FacturaDetalle detalle : factura.getDetalles()) {
				updateDetalle(factura.getIdTipoFactura(), factura.getNumero(),
						detalle);
			}
		}
		return result;
	}

	@Override
	public int deleteById(Integer id, Long numero) throws DataAccessException {
		String sql = "DELETE FROM facturas WHERE FACTURA_ID = ? AND TIPO_FACTURA_ID = ?";
		return getJdbcTemplate().update(sql, new Object[] { numero, id });
	}

	private Factura findEncabezadoId(Integer idTipo, Long numero)
			throws DataAccessException {
		String sql = "SELECT f.*, c.nombre AS cliente, tf.nombre AS tipo_factura, s.nombre AS status, pr.apellido ape_respo, pr.nombre AS nom_respo "
				+ "FROM facturas f "
				+ "INNER JOIN clientes c ON c.cliente_id = f.cliente_id "
				+ "INNER JOIN tipo_factura tf ON tf.tipo_factura_id = f.tipo_factura_id "
				+ "INNER JOIN status s ON s.status_id = f.status_id "
				+ "INNER JOIN personas pr ON pr.persona_id = f.persona_responsable_id "
				+ "WHERE f.tipo_factura_id = ? AND factura_id = ? ";
		Factura factura = (Factura) getJdbcTemplate().queryForObject(sql,
				new Object[] { idTipo, numero }, new FacturaRowMapper());
		return factura;
	}

	private List<FacturaDetalle> findDetallesId(Integer idTipo, Long numero)
			throws DataAccessException {
		String sql = "SELECT * FROM factura_detalle WHERE tipo_factura_id = ? and factura_id = ?";
		List<FacturaDetalle> detalles = getJdbcTemplate().query(sql,
				new FacturaDetalleRowMapper(), new Object[] { idTipo, numero });
		return detalles;
	}

	private int insertEncabezado(Factura factura) throws DataAccessException {

		String sql = "INSERT INTO facturas "
				+ "(tipo_factura_id, factura_id, cliente_id, contacto, persona_id,	fecha_emision, fecha_vencimiento,"
				+ "fecha_probable_cobro, fecha_cobro, importe_subtotal, importe_iva, importe_total,	persona_responsable_id,"
				+ "importe_comision, importe_cobrado, fecha_comprobante_entregable, importe_costo, importe_rentabilidad,"
				+ "forma_pago, remito, orden_compra, status_id, tipo_comision_id, tipo_comprobante_entregable_id,"
				+ "linea_producto_id, tipo_iva_id, tipo_retencion_id)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return getJdbcTemplate().update(
				sql,
				new Object[] { factura.getIdTipoFactura(), factura.getNumero(),
						factura.getIdCliente(), factura.getContacto(),
						factura.getIdUsuario(), factura.getFecha(),
						factura.getFechaVencimiento(),
						factura.getFechaProbableCobro(),
						factura.getFechaCobro(), factura.getImporteSubtotal(),
						factura.getImporteIVA(), factura.getImporteTotal(),
						factura.getIdResponsable(),
						factura.getImporteComision(),
						factura.getImporteCobrado(),
						factura.getFechaComprobableEntregable(),
						factura.getImporteCosto(),
						factura.getImporteRentabilidad(),
						factura.getFormaDePago(), factura.getRemito(),
						factura.getOrdenDeCompra(), factura.getIdStatus(),
						factura.getIdTipoComision(),
						factura.getIdTipoComprobableEntregable(),
						factura.getIdLineaProducto(), factura.getIdTipoIVA(),
						factura.getIdTipoRetencion() });
	}

	private int insertDetalle(Integer idTipoFactura, Long numero,
			FacturaDetalle detalle) throws DataAccessException {

		String sql = "INSERT INTO factura_detalle "
				+ "(tipo_factura_id, factura_id, detalle, importe_unitario, importe_total)"
				+ " VALUES (?, ?, ?, ?, ?)";
		return getJdbcTemplate().update(
				sql,
				new Object[] { idTipoFactura, numero, detalle.getDetalle(),
						detalle.getCantidad(), detalle.getImporteUnitario(),
						detalle.getImporteTotal() });
	}

	private int updateEncabezado(Factura factura) throws DataAccessException {

		String sql = "UPDATE facturas SET"
				+ "cliente_id = ?, contacto = ?, fecha_emision = ?, fecha_vencimiento = ?,"
				+ "fecha_probable_cobro = ?, fecha_cobro = ?, importe_subtotal = ?, importe_iva = ?, importe_total = ?,	persona_responsable_id = ?,"
				+ "importe_comision = ?, importe_cobrado = ?, fecha_comprobante_entregable = ?, importe_costo = ?, importe_rentabilidad = ?,"
				+ "forma_pago = ?, remito = ?, orden_compra = ?, status_id = ?, tipo_comision_id = ?, tipo_comprobante_entregable_id = ?,"
				+ "linea_producto_id = ?, tipo_iva_id = ?, tipo_retencion_id = ? "
				+ "WHERE f.tipo_factura_id = ? AND factura_id = ? ";
		return getJdbcTemplate().update(
				sql,
				new Object[] { factura.getIdCliente(), factura.getContacto(),
						factura.getFecha(), factura.getFechaVencimiento(),
						factura.getFechaProbableCobro(),
						factura.getFechaCobro(), factura.getImporteSubtotal(),
						factura.getImporteIVA(), factura.getImporteTotal(),
						factura.getIdResponsable(),
						factura.getImporteComision(),
						factura.getImporteCobrado(),
						factura.getFechaComprobableEntregable(),
						factura.getImporteCosto(),
						factura.getImporteRentabilidad(),
						factura.getFormaDePago(), factura.getRemito(),
						factura.getOrdenDeCompra(), factura.getIdStatus(),
						factura.getIdTipoComision(),
						factura.getIdTipoComprobableEntregable(),
						factura.getIdLineaProducto(), factura.getIdTipoIVA(),
						factura.getIdTipoRetencion(),
						factura.getIdTipoFactura(), factura.getNumero() });
	}

	private int updateDetalle(Integer idTipoFactura, Long numero,
			FacturaDetalle detalle) throws DataAccessException {

		String sql = "UPDATE factura_detalle SET"
				+ "cantidad = ?, detalle = ?, importe_unitario = ?, importe_total = ? "
				+ "WHERE f.tipo_factura_id = ? AND factura_id = ? ";
		return getJdbcTemplate().update(
				sql,
				new Object[] { detalle.getCantidad(), detalle.getDetalle(),
						detalle.getImporteUnitario(),
						detalle.getImporteTotal(), idTipoFactura, numero });
	}

	public class FacturaDetalleRowMapper implements RowMapper<FacturaDetalle> {
		@Override
		public FacturaDetalle mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			FacturaDetalle facturaDetalle = new FacturaDetalle();
			facturaDetalle.setDetalle(rs.getString("DETALLE"));
			facturaDetalle.setCantidad(rs.getInt("CANTIDAD"));
			facturaDetalle.setImporteUnitario(rs
					.getBigDecimal("IMPORTE_UNITARIO"));
			facturaDetalle.setImporteTotal(rs.getBigDecimal("IMPORTE_TOTAL"));
			return facturaDetalle;
		}
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

			factura.setContacto(rs.getString("CONTACTO"));
			factura.setIdUsuario(rs.getInt("PERSONA_ID"));

			factura.setFechaVencimiento(rs.getDate("FECHA_VENCIMIENTO"));
			factura.setFechaProbableCobro(rs.getDate("FECHA_PROBABLE_COBRO"));
			factura.setFechaCobro(rs.getDate("FECHA_COBRO"));
			factura.setImporteSubtotal(rs.getBigDecimal("IMPORTE_SUBTOTAL"));
			factura.setImporteIVA(rs.getBigDecimal("IMPORTE_IVA"));

			factura.setImporteComision(rs.getBigDecimal("IMPORTE_COMISION"));
			factura.setImporteCobrado(rs.getBigDecimal("IMPORTE_COBRADO"));
			factura.setFechaComprobableEntregable(rs
					.getDate("FECHA_COMPROBANTE_ENTREGABLE"));
			factura.setImporteCosto(rs.getBigDecimal("IMPORTE_COSTO"));

			factura.setFormaDePago(rs.getString("FORMA_PAGO"));
			factura.setRemito(rs.getString("REMITO"));
			factura.setOrdenDeCompra(rs.getString("ORDEN_COMPRA"));

			factura.setIdTipoComision(rs.getInt("TIPO_COMISION_ID"));
			factura.setIdTipoComprobableEntregable(rs
					.getInt("TIPO_COMPROBANTE_ENTREGABLE_ID"));
			factura.setIdLineaProducto(rs.getInt("LINEA_PRODUCTO_ID"));
			factura.setIdTipoIVA(rs.getInt("TIPO_IVA_ID"));
			factura.setIdTipoRetencion(rs.getInt("TIPO_RETENCION_ID"));

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

	public class FacturaListDTORowMapper implements
			RowMapper<FacturaTopListDTO> {
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
