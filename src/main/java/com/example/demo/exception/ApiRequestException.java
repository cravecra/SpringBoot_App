package com.example.demo.exception;

// Warnning supress added due not serialization needed for this class more info in:
// https://stackoverflow.com/questions/285793/what-is-a-serialversionuid-and-why-should-i-use-it?rq=1

@SuppressWarnings("serial")
public class ApiRequestException extends RuntimeException {
	
	public ApiRequestException(String message) {
		super(message);
	}
	
	public ApiRequestException(String message, Throwable cause) {
		super(message, cause);
	}
}
