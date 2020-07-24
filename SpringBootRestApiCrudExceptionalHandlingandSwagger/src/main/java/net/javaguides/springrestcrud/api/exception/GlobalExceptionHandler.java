package net.javaguides.springrestcrud.api.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException  e,WebRequest request)
	{
		ErrorResponse errorResponse=new ErrorResponse(new Date(),e.getLocalizedMessage(),request.getDescription(true));
		
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		
	}
	
	public ResponseEntity<?> handleException(Exception e,WebRequest request)
	{
		ErrorResponse errorResponse=new ErrorResponse(new Date(),e.getLocalizedMessage(),request.getDescription(true));
		return  new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	}


