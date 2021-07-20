package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomerRestExceptionHandler {

	// Add an exception handler for CustomerNotFoundException
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorRespone> handleException(CustomerNotFoundException exc) {
		
		// create CustomerErrorRespone
		
		CustomerErrorRespone error = new CustomerErrorRespone(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// create ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	// Add an exception handler ... to catch any exception (catch all)
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorRespone> handleException(Exception exc) {
		
		// create CustomerErrorRespone
		
		CustomerErrorRespone error = new CustomerErrorRespone(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// create ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}
