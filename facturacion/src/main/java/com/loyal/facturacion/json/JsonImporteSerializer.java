package com.loyal.facturacion.json;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Component
public class JsonImporteSerializer extends JsonSerializer<BigDecimal> {

	@Override
	public void serialize(BigDecimal number, JsonGenerator gen,
			SerializerProvider provider) throws IOException {
		
		DecimalFormat df = new DecimalFormat("$#0.00");
		df.setGroupingUsed(true);
		df.setGroupingSize(3);
		gen.writeString(df.format(number));
	}

}
