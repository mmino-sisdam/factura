package com.loyal.facturacion.dto;

import java.util.HashMap;
import java.util.Map;

public class ReporteIndicadorDTO extends ReporteDTO{

    private Map<String, Object> resultado = new HashMap<String, Object>();

	public Map<String, Object> getResultado() {
		return resultado;
	}

	public void setResultado(Map<String, Object> resultado) {
		this.resultado = resultado;
	}
    
}
