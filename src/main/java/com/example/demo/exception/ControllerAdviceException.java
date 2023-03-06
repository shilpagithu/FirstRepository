package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceException {
	@ExceptionHandler(value = CustomException.class)
	   public ResponseEntity<Object> contactexception(CustomException exception) {
	      return new ResponseEntity<>("Contact not found", HttpStatus.NOT_FOUND);
	   }
}
