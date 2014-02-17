package com.loyal.facturacion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.loyal.facturacion.model.factura.Factura;

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
