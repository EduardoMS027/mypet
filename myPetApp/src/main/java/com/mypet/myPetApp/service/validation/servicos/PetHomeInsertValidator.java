package com.mypet.myPetApp.service.validation.servicos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.mypet.myPetApp.dto.PetHomeInsertDTO;

import com.mypet.myPetApp.entity.PetHome;

import com.mypet.myPetApp.grupos.TipoGrupo;
import com.mypet.myPetApp.repository.PetHomeRepository;

import com.mypet.myPetApp.service.exception.FieldMessage;
import com.mypet.myPetApp.service.validation.utils.BR;

public class PetHomeInsertValidator implements ConstraintValidator<PetHomeInsert, PetHomeInsertDTO> {

		@Autowired
		private PetHomeRepository petHomeRepository;
	
	@Override
	public void initialize(PetHomeInsert ann) {
	}

	@Override
	public boolean isValid(PetHomeInsertDTO objDto, ConstraintValidatorContext context) {


		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getTipoPerfil().equals(TipoGrupo.FISICAJURIDICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF invalido"));
		}
		if (objDto.getTipoPerfil().equals(TipoGrupo.JURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ invalido"));
		}
		
		PetHome aux = petHomeRepository.findByEmail(objDto.getEmail());
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
