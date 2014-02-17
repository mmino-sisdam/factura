package com.loyal.facturacion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.loyal.facturacion.model.factura.Factura;

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

