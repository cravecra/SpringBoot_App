package com.example.demo.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

		@ExceptionHandler(value = {ApiRequestException.class})
		public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
			HttpStatus badRequest = HttpStatus.BAD_REQUEST;
			
			// Payload containing exception details
			ApiException apiException = new ApiException(e.getMessage(), e, badRequest,ZonedDateTime.now(ZoneId.of("Z")));
			// Return response entity
			return new ResponseEntity<>(apiException, badRequest);
		}
}
