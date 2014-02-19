package com.loyal.facturacion.dto;

import java.util.List;

@SuppressWarnings("rawtypes")
public class ReportePaginadoDTO extends ReporteDTO{

    private Integer itemsPorPagina;
    private Integer pagina;
    private Integer totalPaginas;
    
    
	private List resultado;
    
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
	
	public List getResultado() {
		return resultado;
	}
	public void setResultado(List resultado) {
		this.resultado = resultado;
	}

}
