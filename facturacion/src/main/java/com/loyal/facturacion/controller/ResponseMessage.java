package com.loyal.facturacion.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseMessage {

	private ResponseMessageType type;
	private List<String> messages;

	public ResponseMessage() {
	}

	public ResponseMessage(ResponseMessageType type, List<String> messages) {
		this.type = type;
		if (messages==null || messages.size()==0){
			this.messages = Collections.singletonList(type.defaultMessage()); 	
		}else{
			this.messages = messages;
		}
	}

	public ResponseMessage(ResponseMessageType type, String message) {
		this(type, Collections.singletonList(message));
	}

	public ResponseMessage(ResponseMessageType type, String... messages) {
		this(type, Arrays.asList(messages));
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messagew) {
		this.messages = messagew;
	}

	public ResponseMessageType getType() {
		return type;
	}

	public void setType(ResponseMessageType type) {
		this.type = type;
	}
}

enum ResponseMessageType {
	ERROR, OK;

	public String defaultMessage() {
		if (this.equals(OK)) {
			return "Operación realizada correctamente";
		}
		return "Ha ocurrido un error";
	}
}
