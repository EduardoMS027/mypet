package com.mypet.myPetApp.service.validation;

import java.util.ArrayList;
import java.util.List;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.mypet.myPetApp.dto.PetClientInsertDTO;

import com.mypet.myPetApp.entity.Petclient;
import com.mypet.myPetApp.grupos.TipoGrupo;
import com.mypet.myPetApp.repository.PetclientRepository;
import com.mypet.myPetApp.service.exception.FieldMessage;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, PetClientInsertDTO> {
	
	@Autowired
	private PetclientRepository petclientRepository;
	
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(PetClientInsertDTO objDto, ConstraintValidatorContext context) {

		List<com.mypet.myPetApp.service.exception.FieldMessage> list = new ArrayList<>();
	

		if (objDto.getTipoPerfil().equals(TipoGrupo.CLIENTE.getCod())
				&& !com.mypet.myPetApp.service.validation.utils.BR.isValidCPF(objDto.getCpf())) {
			list.add(new FieldMessage("cpf", "CPF invalido"));
		}
		Petclient aux = petclientRepository.findByEmail(objDto.getEmail());
		if(aux != null) { // verificando se email já existe
			list.add(new FieldMessage("Email", "Email já existente"));
		}
		
		

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
