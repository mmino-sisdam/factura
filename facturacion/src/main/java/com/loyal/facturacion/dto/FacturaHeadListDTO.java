package com.loyal.facturacion.dto;

import java.math.BigDecimal;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.loyal.facturacion.json.JsonImporteSerializer;

public class FacturaHeadListDTO {

    private Integer year;
    private Integer month;
    private String monthName;
    @JsonSerialize(using=JsonImporteSerializer.class)
    private BigDecimal monto;
    @JsonSerialize(using=JsonImporteSerializer.class)
    private BigDecimal rentabilidad;
    private List<FacturaListDTO> list;
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
	public List<FacturaListDTO> getList() {
		return list;
	}
	public void setList(List<FacturaListDTO> list) {
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
