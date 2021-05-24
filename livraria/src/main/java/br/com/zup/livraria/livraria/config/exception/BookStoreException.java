package br.com.zup.livraria.livraria.config.exception;

import org.springframework.http.HttpStatus;

public class BookStoreException {
	
	 private final String message;
	    private final HttpStatus httpStatus;


	    public BookStoreException(String message, HttpStatus httpStatus) {
	        this.message = message;
	        this.httpStatus = httpStatus;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public HttpStatus getHttpStatus() {
	        return httpStatus;
	    }

}
