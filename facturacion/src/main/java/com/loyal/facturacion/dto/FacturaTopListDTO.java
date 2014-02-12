package com.loyal.facturacion.dto;

import java.math.BigDecimal;
import java.util.List;

import com.loyal.facturacion.model.factura.Factura;

public class FacturaTopListDTO {

    private Integer year;
    private Integer month;
    private String monthName;
    private BigDecimal monto;
    private BigDecimal rentabilidad;
    private List<Factura> list;
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public BigDecimal getRentabilidad() {
		return rentabilidad;
	}
	public void setRentabilidad(BigDecimal rentabilidad) {
		this.rentabilidad = rentabilidad;
	}
	public List<Factura> getList() {
		return list;
	}
	public void setList(List<Factura> list) {
		this.list = list;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public String getMonthName() {
		return monthName;
	}
	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}
}
