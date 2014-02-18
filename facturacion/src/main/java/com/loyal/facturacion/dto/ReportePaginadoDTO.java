package com.loyal.facturacion.dto;

public class ReportePaginadoDTO extends ReporteDTO{

    private Integer itemsPorPagina;
    private Integer pagina;
    private Integer totalPaginas;
    
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
}
