package com.t2s.web.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ServiceCommons {

	public <T> ResponseEntity<T> createOkResponse(T body) {
		return createResponse(body, HttpStatus.OK);
	}

	public <T> ResponseEntity<T> createErrorResponse(T body) {
		return createResponse(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public <T> ResponseEntity<T> createResponse(T body, HttpStatus httpStatus) {
		return new ResponseEntity<>(body, httpStatus);
	}

}
