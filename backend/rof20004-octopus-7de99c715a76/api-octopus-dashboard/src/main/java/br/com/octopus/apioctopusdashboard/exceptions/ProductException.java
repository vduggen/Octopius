package br.com.octopus.apioctopusdashboard.exceptions;

public class ProductException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public ProductException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
