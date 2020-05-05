package br.com.octopus.apioctopusdashboard.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2
public class GlobalException {
	
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public Map<String, Object> handleNoSuchElementException(NoSuchElementException e) {
		String message = e.getMessage();
		String timestamp = LocalDateTime.now().toString();
		
		log.error("[GlobalException.handleNoSuchElementException] " + message);
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("message", message);
		body.put("timestamp", timestamp);
		
		return body;
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public Map<String, Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		String message = "Corpo da requisição inválido";
		String timestamp = LocalDateTime.now().toString();
		
		log.error("[GlobalException.handleHttpMessageNotReadableException] " + message);
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("message", message);
		body.put("timestamp", timestamp);
		
		return body;
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, Object> handleIllegalArgumentException(IllegalArgumentException e) {
		String message = "Requisição inválida";
		String timestamp = LocalDateTime.now().toString();
		
		log.error("[GlobalException.handleIllegalArgumentException] " + message);
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("message", message);
		body.put("timestamp", timestamp);
		
		return body;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String, Object> handleNoHandlerFoundException(NoHandlerFoundException e) {
		String message = "Recurso não encontrado";
		String timestamp = LocalDateTime.now().toString();
		
		log.error("[GlobalException.handleNoHandlerFoundException] " + message);
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("message", message);
		body.put("timestamp", timestamp);
		
		return body;
	}
	
	@ExceptionHandler(UserException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, Object> handleUserException(UserException e, HttpServletResponse response) {
		String message = e.getMessage();
		String timestamp = LocalDateTime.now().toString();
		
		log.error("[GlobalException.handleUserException] " + message);
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("message", message);
		body.put("timestamp", timestamp);
		
		return body;
	}

	@ExceptionHandler(AuthException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public Map<String, Object> handleAuthException(AuthException e, HttpServletResponse response) {
		String message = e.getMessage();
		String timestamp = LocalDateTime.now().toString();
		
		log.error("[GlobalException.handleAuthException] " + message);
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("message", message);
		body.put("timestamp", timestamp);
		
		return body;
	}
	
	@ExceptionHandler(ProductException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, Object> handleProductException(ProductException e, HttpServletResponse response) {
		String message = e.getMessage();
		String timestamp = LocalDateTime.now().toString();
		
		log.error("[GlobalException.handleProductException] " + message);
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("message", message);
		body.put("timestamp", timestamp);
		
		return body;
	}
	
	@ExceptionHandler(BlacklistException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, Object> handleBlacklistException(BlacklistException e, HttpServletResponse response) {
		String message = e.getMessage();
		String timestamp = LocalDateTime.now().toString();
		
		log.error("[GlobalException.handleBlacklistException] " + message);
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("message", message);
		body.put("timestamp", timestamp);
		
		return body;
	}
	
	@ExceptionHandler(NotificationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, Object> handleNotificationException(NotificationException e, HttpServletResponse response) {
		String message = e.getMessage();
		String timestamp = LocalDateTime.now().toString();
		
		log.error("[GlobalException.handleNotificationException] " + message);
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("message", message);
		body.put("timestamp", timestamp);
		
		return body;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, Object> handleException(Exception e) {
		String message = e.getMessage();
		String timestamp = LocalDateTime.now().toString();
		
		log.error("[GlobalException.handleException] " + message);
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("message", message);
		body.put("timestamp", timestamp);
		
		return body;
	}

}