package com.example.demo.exceptionhandler;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
// captura excessões de respostas de entidades
@ControllerAdvice   
public class DemoExceptionHandler extends ResponseEntityExceptionHandler {
	
	   @Autowired
	    private MessageSource messageSource;
	  @Override
	    protected ResponseEntity<Object> handleHttpMessageNotReadable(
	            HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

	        // Obtém a mensagem do arquivo messages.properties
		    String mensagemErro = messageSource.getMessage("mensagem.erro.invalida", null, Locale.getDefault());

	        return handleExceptionInternal(ex, mensagemErro, headers, status, request);
	    }


}
 