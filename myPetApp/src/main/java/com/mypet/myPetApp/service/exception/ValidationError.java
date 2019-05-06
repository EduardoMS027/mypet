package com.mypet.myPetApp.service.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandarError { // tem todos os dados do StandErrror mais a lista que implementa��o
	private static final long serialVersionUID = 1L;

	
	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
		
	}


	public List<FieldMessage> getErrors() {
		return errors;
	}


	public void addError(String fieldName, String messagem) { //adiciona um erro de cada vez
		errors.add(new FieldMessage(fieldName,messagem)); // adiciona o erro.
	}


}
