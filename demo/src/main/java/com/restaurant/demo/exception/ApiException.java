package com.restaurant.demo.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiException {

	private final String mesage;
	private final HttpStatus httpStatus;
	private final ZonedDateTime timestamp;
	
	public ApiException(String mesage, 
						HttpStatus httpStatus, 
						ZonedDateTime timestamp) {
		super();
		this.mesage = mesage;
		this.httpStatus = httpStatus;
		this.timestamp = timestamp;
	}

	public String getMesage() {
		return mesage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
	
	
}
