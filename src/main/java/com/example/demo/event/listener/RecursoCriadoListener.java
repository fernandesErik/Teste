package com.example.demo.event.listener;

import java.net.URI;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.event.RecursocriadoEvent;

import jakarta.servlet.http.HttpServletResponse;
@Component
public class RecursoCriadoListener implements ApplicationListener<RecursocriadoEvent>{

	@Override
	public void onApplicationEvent(RecursocriadoEvent recursoCriadoEvent) {
		HttpServletResponse response = recursoCriadoEvent.getResponse();
		Long codigo = recursoCriadoEvent.getCodigo();
		                                                                                        // se n for codigo é id
		adicionarHeaderLocation(response, codigo);
		
	}

	private void adicionarHeaderLocation(HttpServletResponse response, Long codigo) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/codigo").buildAndExpand(codigo).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}

}
