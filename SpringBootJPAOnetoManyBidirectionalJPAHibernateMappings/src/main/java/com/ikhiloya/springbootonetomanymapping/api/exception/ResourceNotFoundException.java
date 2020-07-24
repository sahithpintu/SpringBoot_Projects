package com.ikhiloya.springbootonetomanymapping.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

	 public ResourceNotFoundException() {
	        super();
	    }
	 
	public ResourceNotFoundException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}
	public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
