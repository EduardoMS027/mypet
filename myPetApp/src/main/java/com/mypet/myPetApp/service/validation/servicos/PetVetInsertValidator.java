package com.mypet.myPetApp.service.validation.servicos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.mypet.myPetApp.dto.PetVetInsertDTO;
import com.mypet.myPetApp.entity.PetVet;

import com.mypet.myPetApp.grupos.TipoGrupo;
import com.mypet.myPetApp.repository.PetVetRepository;
import com.mypet.myPetApp.service.exception.FieldMessage;

public class PetVetInsertValidator implements ConstraintValidator<PetVetInsert, PetVetInsertDTO> {

	
	@Autowired
	private PetVetRepository petVetRepository;
	@Override
	public void initialize(PetVetInsert ann) {
	}

	@Override
	public boolean isValid(PetVetInsertDTO objDto, ConstraintValidatorContext context) {

		List<com.mypet.myPetApp.service.exception.FieldMessage> list = new ArrayList<>();
		

		if (objDto.getTipoPerfil().equals(TipoGrupo.JURIDICA.getCod())
				&& !com.mypet.myPetApp.service.validation.utils.BR.isValidCNPJ(objDto.getCnpj())) {
			list.add(new FieldMessage("cnpj", "CNPJ invalido"));
		}
		
		PetVet aux = petVetRepository.findByEmail(objDto.getEmail());
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
