package com.example.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	   @ExceptionHandler(value = ResourceNotFoundException.class)
	    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
	// String msg = ex.getMessage();
		   
		   ExceptionBean eb = new ExceptionBean(HttpStatus.NOT_FOUND, ex.getMessage(), LocalDateTime.now());
	        return new ResponseEntity<>(eb, HttpStatus.NOT_FOUND);
	    }

}
