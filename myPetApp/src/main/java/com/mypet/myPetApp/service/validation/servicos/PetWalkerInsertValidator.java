package com.mypet.myPetApp.service.validation.servicos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.mypet.myPetApp.dto.PetWalkerInsertDTO;
import com.mypet.myPetApp.entity.PetWalker;
import com.mypet.myPetApp.grupos.TipoGrupo;
import com.mypet.myPetApp.repository.PetWalkerRepository;
import com.mypet.myPetApp.service.exception.FieldMessage;
import com.mypet.myPetApp.service.validation.utils.BR;

public class PetWalkerInsertValidator implements ConstraintValidator<PetWalkerInsert, PetWalkerInsertDTO> {

		@Autowired
		private PetWalkerRepository petWalkerRepository;
	
	@Override
	public void initialize(PetWalkerInsert ann) {
	}

	@Override
	public boolean isValid(PetWalkerInsertDTO objDto, ConstraintValidatorContext context) {


		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getTipoPerfil().equals(TipoGrupo.FISICAJURIDICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF invalido"));
		}
		if (objDto.getTipoPerfil().equals(TipoGrupo.JURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ invalido"));
		}
		
		PetWalker aux = petWalkerRepository.findByEmail(objDto.getEmail());
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
