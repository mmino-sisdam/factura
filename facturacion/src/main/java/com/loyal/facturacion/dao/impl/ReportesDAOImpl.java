package com.loyal.facturacion.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.loyal.facturacion.dto.FacturaListDTO;
import com.loyal.facturacion.dto.ItemReporteAcumuladoDTO;
import com.loyal.facturacion.dto.ReporteDTO;
import com.loyal.facturacion.dto.ReportePaginadoDTO;
import com.loyal.facturacion.dao.ReportesDAO;
import com.loyal.facturacion.rowmapper.FacturaListRowMapper;

public class ReportesDAOImpl extends JdbcDaoSupport implements ReportesDAO {

	@Override
	public List<ItemReporteAcumuladoDTO> facturacionAcumuladaPorVendedor(ReportePaginadoDTO reporteDTO) {
		
		String sql = "SELECT count(*) AS cantidad, "
				+ "CONCAT(p.apellido,\", \", p.nombre) as nombre, f.persona_responsable_id as id, null as descripcion,"
				+ "sum(importe_comision) AS importeComision, "
				+ "sum(importe_costo) AS importeCosto, "
				+ "sum(importe_rentabilidad) AS importeRentabilidad, "
				+ "sum(importe_subtotal) AS importeSubtotal, "
				+ "sum(importe_iva) AS importeIva, "
				+ "sum(importe_total) AS importeTotal "
				+ "FROM facturas f "
				+ "INNER JOIN personas p on p.persona_id = f.persona_responsable_id "
				+ "WHERE fecha_emision between date(?) and date(?) "
				+ "GROUP BY persona_responsable_id "
				+ "ORDER BY apellido, nombre";
		
		return query(sql, reporteDTO.getDesde(), reporteDTO.getHasta());
		
	}
	
	@Override
	public List<ItemReporteAcumuladoDTO> facturacionAcumuladaPorLineaProducto(ReportePaginadoDTO reporteDTO) {
		
		
		return query(generateQuerySQLDato("linea_producto"), reporteDTO.getDesde(), reporteDTO.getHasta());
		
	}
	
	@Override
	public List<ItemReporteAcumuladoDTO> facturacionAcumuladaPorStatus(ReportePaginadoDTO reporteDTO) {
		
		
		return query(generateQuerySQLDato("status"), reporteDTO.getDesde(), reporteDTO.getHasta());
		
	}
	
	private List<ItemReporteAcumuladoDTO> query(String sql, Date desde, Date hasta) {
		return getJdbcTemplate().query(sql, new Object[]{desde, hasta}, new ItemRowMapper());
	}
	
	private List<ItemReporteAcumuladoDTO> query(String sql) {
		return getJdbcTemplate().query(sql, new ItemRowMapper());
	}
	
	private String generateQuerySQLDato(String dato){
		String sql = "SELECT count(*) AS cantidad, "
				+ "l.nombre, l."+dato+"_id as id, l.descripcion,"
				+ "sum(importe_comision) AS importeComision, "
				+ "sum(importe_costo) AS importeCosto, "
				+ "sum(importe_rentabilidad) AS importeRentabilidad, "
				+ "sum(importe_subtotal) AS importeSubtotal, "
				+ "sum(importe_iva) AS importeIva, "
				+ "sum(importe_total) AS importeTotal "
				+ "FROM facturas f "
				+ "INNER JOIN " + dato + " l on l." + dato + "_id = f." + dato + "_id "
				+ "WHERE fecha_emision between date(?) and date(?) "
				+ "GROUP BY l." + dato + "_id "
				+ "ORDER BY l.nombre";		
		return sql;
	}

	@Override
	public List<FacturaListDTO> facturacionAVencer(ReportePaginadoDTO reporteDTO) {
		String sql = "SELECT f.*, c.nombre AS cliente, tf.nombre AS tipo_factura, s.nombre AS status, pr.apellido ape_respo, pr.nombre AS nom_respo "
				+ "FROM facturas f "
				+ "INNER JOIN clientes c ON c.cliente_id = f.cliente_id "
				+ "INNER JOIN tipo_factura tf ON tf.tipo_factura_id = f.tipo_factura_id "
				+ "INNER JOIN personas pr ON pr.persona_id = f.persona_responsable_id "
				+ "INNER JOIN status s ON s.status_id = f.status_id "				
				+ "WHERE fecha_vencimiento between date(?) and date(?) and f.status_id!=4 "
				+ "ORDER BY fecha_vencimiento, tipo_factura_id, factura_id;";

		return getJdbcTemplate().query(sql, new Object[]{reporteDTO.getDesde(), reporteDTO.getHasta()}, new FacturaListRowMapper());
	}
	
	@Override
	public List<ItemReporteAcumuladoDTO> indicadorFacturacionPendiente(ReporteDTO reporteDTO) {

		String sql = "SELECT null as id, null as nombre,count(*) AS cantidad, null as descripcion,"
				+ "sum(importe_comision) AS importeComision, "
				+ "sum(importe_costo) AS importeCosto, "
				+ "sum(importe_rentabilidad) AS importeRentabilidad, "
				+ "sum(importe_subtotal) AS importeSubtotal, "
				+ "sum(importe_iva) AS importeIva, "
				+ "sum(importe_total) AS importeTotal "
				+ "FROM facturas f "
				+ "WHERE status_id not in(1,4)";
		
		return query(sql);
	}

	@Override
	public List<ItemReporteAcumuladoDTO> indicadorFacturacionCobrada(ReporteDTO reporteDTO) {

		String sql = "SELECT null as id, null as nombre,count(*) AS cantidad, null as descripcion,"
				+ "sum(importe_comision) AS importeComision, "
				+ "sum(importe_costo) AS importeCosto, "
				+ "sum(importe_rentabilidad) AS importeRentabilidad, "
				+ "sum(importe_subtotal) AS importeSubtotal, "
				+ "sum(importe_iva) AS importeIva, "
				+ "sum(importe_total) AS importeTotal "
				+ "FROM facturas f "
				+ "WHERE fecha_cobro between date(?) and date(?) and status_id = 1";
		
		return query(sql, reporteDTO.getDesde(), reporteDTO.getHasta());
	}
	
	@Override
	public List<ItemReporteAcumuladoDTO> indicadorFacturacion(ReporteDTO reporteDTO) {

		String sql = "SELECT null as id, null as nombre, count(*) AS cantidad, null as descripcion,"
				+ "sum(importe_comision) AS importeComision, "
				+ "sum(importe_costo) AS importeCosto, "
				+ "sum(importe_rentabilidad) AS importeRentabilidad, "
				+ "sum(importe_subtotal) AS importeSubtotal, "
				+ "sum(importe_iva) AS importeIva, "
				+ "sum(importe_total) AS importeTotal "
				+ "FROM facturas f "
				+ "WHERE fecha_emision between date(?) and date(?) and status_id!=4";
		
		return query(sql, reporteDTO.getDesde(), reporteDTO.getHasta());
	}
	
	public class ItemRowMapper implements RowMapper<ItemReporteAcumuladoDTO> {
		@Override
		public ItemReporteAcumuladoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			ItemReporteAcumuladoDTO item = new ItemReporteAcumuladoDTO();
			
			item.setId(rs.getInt("ID"));
			item.setNombre(rs.getString("NOMBRE"));
			item.setDescripcion(rs.getString("DESCRIPCION"));
			item.setImporteComision(rs.getBigDecimal("IMPORTECOMISION"));
			item.setImporteCosto(rs.getBigDecimal("IMPORTECOSTO"));
			item.setImporteIva(rs.getBigDecimal("IMPORTEIVA"));
			item.setImporteRentabilidad(rs.getBigDecimal("IMPORTERENTABILIDAD"));
			item.setImporteSubtotal(rs.getBigDecimal("IMPORTESUBTOTAL"));
			item.setImporteTotal(rs.getBigDecimal("IMPORTETOTAL"));
			item.setCantidad(rs.getInt("CANTIDAD"));
			return item;
		}
	}

	
}
