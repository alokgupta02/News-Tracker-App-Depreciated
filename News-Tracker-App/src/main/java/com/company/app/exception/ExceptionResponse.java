package com.company.app.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ExceptionResponse {
	
	private String message;
	private HttpStatus errorCode;

}
