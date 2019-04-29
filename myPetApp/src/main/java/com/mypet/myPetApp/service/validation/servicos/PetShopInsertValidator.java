package com.mypet.myPetApp.service.validation.servicos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.mypet.myPetApp.dto.PetShopInsertDTO;
import com.mypet.myPetApp.entity.PetShop;

import com.mypet.myPetApp.grupos.TipoGrupo;
import com.mypet.myPetApp.repository.PetShopRepository;
import com.mypet.myPetApp.service.exception.FieldMessage;

public class PetShopInsertValidator implements ConstraintValidator<PetShopInsert, PetShopInsertDTO> {

		@Autowired
		private PetShopRepository petShopRepository;
	
		
	@Override
	public void initialize(PetShopInsert ann) {
	}

	@Override
	public boolean isValid(PetShopInsertDTO objDto, ConstraintValidatorContext context) {

		List<com.mypet.myPetApp.service.exception.FieldMessage> list = new ArrayList<>();
		

		if (objDto.getTipoPerfil().equals(TipoGrupo.JURIDICA.getCod())
				&& !com.mypet.myPetApp.service.validation.utils.BR.isValidCNPJ(objDto.getCnpj())) {
			list.add(new FieldMessage("cnpj", "CNPJ invalido"));
		}
		
		PetShop aux = petShopRepository.findByEmail(objDto.getEmail());
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
