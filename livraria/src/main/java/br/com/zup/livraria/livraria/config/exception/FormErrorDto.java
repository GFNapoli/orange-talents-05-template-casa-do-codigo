package br.com.zup.livraria.livraria.config.exception;

public class FormErrorDto {
	
	private String error;
	private String message;
	
	public FormErrorDto(String error, String message) {
		super();
		this.error = error;
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}
	
	

}
