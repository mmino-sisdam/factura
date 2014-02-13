package com.loyal.facturacion.controller;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class JsonDateSerializer extends JsonSerializer<Date> {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"dd/MM/yyyy"); // change according to your needs

	@Override
	public void serialize(Date date, JsonGenerator gen,
			SerializerProvider provider) throws IOException {

		String formattedDate = dateFormat.format(date);

		gen.writeString(formattedDate);
	}

}
