package com.loyal.facturacion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.loyal.facturacion.dto.FacturaListDTO;

public class FacturaListRowMapper implements RowMapper<FacturaListDTO> {
	@Override
	public FacturaListDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		FacturaListDTO factura = new FacturaListDTO();
		factura.setIdTipoFactura(rs.getInt("TIPO_FACTURA_ID"));
		factura.setTipoFactura(rs.getString("TIPO_FACTURA"));
		factura.setNumero(rs.getLong("FACTURA_ID"));
		factura.setFecha(rs.getDate("FECHA_EMISION"));
		factura.setFechaVencimiento(rs.getDate("FECHA_VENCIMIENTO"));
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
		factura.setFormaDePago(rs.getString("FORMA_PAGO"));
		
		return factura;
	}
}
