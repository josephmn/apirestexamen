package com.crudusuario.apirestexamen.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.crudusuario.apirestexamen.response.RespuestaResponse;
 

@ControllerAdvice
@ResponseBody
public class ExceptionBadRequest  {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<RespuestaResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
		
	    List<String> errors = new ArrayList<>();
	    ex.getBindingResult().getAllErrors().forEach(error -> {  
	        String errorMessage = error.getDefaultMessage();
	        errors.add(errorMessage);
	    });
	    
		new ResponseEntity<RespuestaResponse>(HttpStatus.BAD_REQUEST);
		return ResponseEntity.badRequest().body(new RespuestaResponse(errors.get(0)));
	}
}
