package com.loyal.facturacion.dto;

import java.util.List;
import java.util.Map;

public class ReportePaginadoDTO extends ReporteDTO{

    private Integer itemsPorPagina;
    private Integer pagina;
    private Integer totalPaginas;
    
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

}
