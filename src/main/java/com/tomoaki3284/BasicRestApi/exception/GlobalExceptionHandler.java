package com.tomoaki3284.BasicRestApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Throwable.class)
	public ResponseEntity handleRuntimeException() {
		return new ResponseEntity("something happened", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
