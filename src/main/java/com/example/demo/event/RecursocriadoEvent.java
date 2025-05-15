package com.example.demo.event;

import org.springframework.context.ApplicationEvent;

import jakarta.servlet.http.HttpServletResponse;

public class RecursocriadoEvent extends ApplicationEvent{

	
	
	private static final long serialVersionUID = 1L;
	
	private HttpServletResponse response;
	private long codigo;

	public RecursocriadoEvent(Object source, HttpServletResponse response, Long Codigo) {
		super(source);
		this.response = response;
	//	this.codigo = codigo;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public long getCodigo() {
		return codigo;
	}
	
	

	

}
