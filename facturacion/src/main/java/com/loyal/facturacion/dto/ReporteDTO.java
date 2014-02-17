package com.loyal.facturacion.dto;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.loyal.facturacion.json.JsonDateDeserializer;
import com.loyal.facturacion.json.JsonDateSerializer;

public class ReporteDTO {

	@JsonDeserialize(using = JsonDateDeserializer.class) 
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date desde;
	@JsonDeserialize(using = JsonDateDeserializer.class) 
	@JsonSerialize(using = JsonDateSerializer.class)
    private Date hasta;
	
	private Integer mes;
    private Integer itemsPorPagina;
    private Integer pagina;
    private Integer totalPaginas;
    
    private Map<String, List<Map<String, Object>>> resultado;
    
	public Date getDesde() {
		if (mes!=null || desde == null){
			Calendar c = Calendar.getInstance();
		    c.setTime(new Date());
		    if (mes!=null){
		    	c.set(Calendar.MONTH, mes);
		    }
		    c.add(Calendar.MONTH, - 1);
		    c.set(Calendar.DAY_OF_MONTH, 1);
		    desde=c.getTime();			
		}
		return desde;
	}
	public void setDesde(Date desde) {
		this.desde = desde;
	}
	public Date getHasta() {
		if (mes!=null || hasta == null){
			Calendar c = Calendar.getInstance();
		    c.setTime(new Date());
		    if (mes!=null){
		    	c.set(Calendar.MONTH, mes - 1);
		    }
		    c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		    hasta = c.getTime();			
		}
		return hasta;
	}
	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

	public Integer getItemsPorPagina() {
		return itemsPorPagina;
	}
	public void setItemsPorPagina(Integer itemsPorPagina) {
		this.itemsPorPagina = itemsPorPagina;
	}
	public Integer getPagina() {
		return pagina;
	}
	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}
	public Integer getTotalPaginas() {
		return totalPaginas;
	}
	public void setTotalPaginas(Integer totalPaginas) {
		this.totalPaginas = totalPaginas;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Map<String, List<Map<String, Object>>> getResultado() {
		return resultado;
	}
	public void setResultado(Map<String, List<Map<String, Object>>> resultado) {
		this.resultado = resultado;
	}
}
