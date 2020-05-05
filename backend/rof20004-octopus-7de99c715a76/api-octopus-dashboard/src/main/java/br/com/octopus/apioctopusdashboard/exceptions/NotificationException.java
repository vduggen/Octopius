package br.com.octopus.apioctopusdashboard.exceptions;

public class NotificationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public NotificationException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
