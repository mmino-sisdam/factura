package com.loyal.facturacion.dto;

import java.util.Calendar;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.loyal.facturacion.json.JsonDateDeserializer;
import com.loyal.facturacion.json.JsonDateSerializer;

public abstract class ReporteParametrizadoDTO {

	@JsonDeserialize(using = JsonDateDeserializer.class) 
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date desde;
	@JsonDeserialize(using = JsonDateDeserializer.class) 
	@JsonSerialize(using = JsonDateSerializer.class)
    private Date hasta;
	
	private Integer mes;
	
	public Date getDesde() {
		if (mes!=null || desde == null){
			Calendar c = Calendar.getInstance();
		    c.setTime(new Date());
		    if (mes!=null){
		    	c.set(Calendar.MONTH, mes -1);
		    }
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

	public void setMes(Integer mes) {
		this.mes = mes;
	}
}
