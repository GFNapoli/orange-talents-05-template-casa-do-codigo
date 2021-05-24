package br.com.zup.livraria.livraria.config.exception;

import org.springframework.http.HttpStatus;

public class BookStoreRequestException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private final HttpStatus httpStatus;

    public BookStoreRequestException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public BookStoreRequestException(String message, Throwable cause, HttpStatus httpStatus) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
