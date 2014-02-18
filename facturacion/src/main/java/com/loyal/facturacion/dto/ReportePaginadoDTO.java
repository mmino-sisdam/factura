package com.loyal.facturacion.dto;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import com.loyal.facturacion.json.JsonDateDeserializer;
import com.loyal.facturacion.json.JsonDateSerializer;

public class ReportePaginadoDTO {

    private Integer itemsPorPagina;
    private Integer pagina;
    private Integer totalPaginas;
	
	private Integer mes;
	
	
    private List<Map<String, Object>> resultado;
    
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
	
	public List<Map<String, Object>> getResultado() {
		return resultado;
	}
	public void setResultado(List<Map<String, Object>> resultado) {
		this.resultado = resultado;
	}
	
	@JsonSerialize(using = JsonDateSerializer.class)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
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
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	public void setDesde(Date desde) {
		this.desde = desde;
	}
	@JsonSerialize(using = JsonDateSerializer.class)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
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
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonSerialize(using = JsonDateSerializer.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date desde;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonSerialize(using = JsonDateSerializer.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date hasta;

}
