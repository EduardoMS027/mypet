package com.mypet.myPetApp.service.validation.servicos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mypet.myPetApp.dto.PetClientInsertDTO;
import com.mypet.myPetApp.dto.PetVetInsertDTO;
import com.mypet.myPetApp.grupos.TipoGrupo;
import com.mypet.myPetApp.service.exception.FieldMessage;

public class PetVetInsertValidator implements ConstraintValidator<PetVetInsert, PetVetInsertDTO> {

	@Override
	public void initialize(PetVetInsert ann) {
	}

	@Override
	public boolean isValid(PetVetInsertDTO objDto, ConstraintValidatorContext context) {

		List<com.mypet.myPetApp.service.exception.FieldMessage> list = new ArrayList<>();
		/*
		 * if (objDto.getTipoPerfil().equals(TipoGrupo.FISICAJURIDICA.getCod()) &&
		 * !com.mypet.myPetApp.service.validation.utils.BR.isValidCPF(objDto.
		 * getCpfOuCnpj())) { list.add(new
		 * com.mypet.myPetApp.service.exception.FieldMessage("cpfOuCnpj",
		 * "CPF invalido")); } if
		 * (objDto.getTipoPerfil().equals(TipoGrupo.JURIDICA.getCod()) &&
		 * !com.mypet.myPetApp.service.validation.utils.BR.isValidCNPJ(objDto.
		 * getCpfOuCnpj())) { list.add(new
		 * com.mypet.myPetApp.service.exception.FieldMessage("cpfOuCnpj",
		 * "CNPJ invalido")); }
		 */

		if (objDto.getTipoPerfil().equals(TipoGrupo.JURIDICA.getCod())
				&& !com.mypet.myPetApp.service.validation.utils.BR.isValidCNPJ(objDto.getCnpj())) {
			list.add(new FieldMessage("cnpj", "CNPJ invalido"));
		}
		

		

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
