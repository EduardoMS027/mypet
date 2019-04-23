package com.mypet.myPetApp.service.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mypet.myPetApp.service.exceptions.ObjectNotFoundException;

@ControllerAdvice // para intercptar erros
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class) // indica que é um tratador de excessão de
														// ObjectNotFoundException.class
	public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

		StandarError err = new StandarError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

	}

	@ExceptionHandler(com.mypet.myPetApp.service.exceptions.DataInternalException.class) // indica que é um tratador de
																							// excessão de
																							// ObjectNotFoundException.class
	public ResponseEntity<StandarError> DataInternalException(
			com.mypet.myPetApp.service.exceptions.DataInternalException e, HttpServletRequest request) {

		StandarError err = new StandarError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class) // indica que é um tratador de excessão de
																// ObjectNotFoundException.class
	public ResponseEntity<StandarError> objectNotFound(MethodArgumentNotValidException e, HttpServletRequest request) {

		ValidationError err = new ValidationError(HttpStatus.NOT_FOUND.value(), "Erro de validação",
				System.currentTimeMillis());

		for (FieldError x : e.getBindingResult().getFieldErrors()) { // percorrer lista de erros, getBindin e getFiled acessa todos os erros de campos que ocorreu
			err.addError(x.getField(), x.getDefaultMessage());// x pega o nome do erro, getDefault pega a mensagem
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

	}
}
