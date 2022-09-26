package com.company.app.exception;

import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.thymeleaf.exceptions.TemplateInputException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler({NoSuchElementException.class, EmptyResultDataAccessException.class, TemplateInputException.class})
	public ResponseEntity<Object> handleNoSuchElementException(Exception ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage("ID NOT FOUND");
		response.setErrorCode(HttpStatus.NOT_FOUND);
		ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		return entity;
		
	}
}
