package com.example.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;
@Data
public class ExceptionBean {
	 private HttpStatus status;
	    private String message;
	    private LocalDateTime timestamp;

	    public ExceptionBean(HttpStatus status, String message, LocalDateTime timestamp) {
	        this.status = status;
	        this.message = message;
	        this.timestamp = timestamp;
	    }


}
