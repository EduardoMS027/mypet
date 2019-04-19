package com.mypet.myPetApp.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mypet.myPetApp.dto.PetClientInsertDTO;
import com.mypet.myPetApp.grupos.TipoGrupo;
import com.mypet.myPetApp.service.exception.FieldMessage;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, PetClientInsertDTO> {

	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(PetClientInsertDTO objDto, ConstraintValidatorContext context) {

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

		if (objDto.getTipoPerfil().equals(TipoGrupo.CLIENTE.getCod())
				&& !com.mypet.myPetApp.service.validation.utils.BR.isValidCPF(objDto.getCpf())) {
			list.add(new FieldMessage("cpf", "CPF invalido"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
