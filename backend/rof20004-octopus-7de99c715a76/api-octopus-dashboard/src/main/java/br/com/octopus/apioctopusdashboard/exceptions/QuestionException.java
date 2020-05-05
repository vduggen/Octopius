package br.com.octopus.apioctopusdashboard.exceptions;

public class QuestionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public QuestionException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
