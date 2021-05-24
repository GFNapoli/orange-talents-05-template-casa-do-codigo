package br.com.zup.livraria.livraria.config.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookStoreExceptionHandler {
	
	@ExceptionHandler(value = BookStoreRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(BookStoreRequestException e) {
        //Payload
        BookStoreException bookStoreException = new BookStoreException(
                e.getMessage(),
                e.getHttpStatus()
        );
        return new ResponseEntity<>(bookStoreException, e.getHttpStatus());
    }

}
