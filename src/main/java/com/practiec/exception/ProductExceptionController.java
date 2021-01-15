package com.practiec.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ProductExceptionController {

	public ResponseEntity<Object> exception(ProductNotFoundException exception){
		return new ResponseEntity<>("Product not found ", HttpStatus.NOT_FOUND);
	}
}
