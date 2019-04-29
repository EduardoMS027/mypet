package com.mypet.myPetApp.service.validation.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.mypet.myPetApp.dto.PetShopDTO;

import com.mypet.myPetApp.entity.PetShop;

import com.mypet.myPetApp.repository.PetShopRepository;

import com.mypet.myPetApp.service.exception.FieldMessage;

public class PetShopUpdateValidator implements ConstraintValidator<PetShopUpdate, PetShopDTO> {

	@Autowired
	private HttpServletRequest request; // permite pegar o parametro da uri
	@Autowired
	private PetShopRepository petShopRepository;

	@Override
	public void initialize(PetShopUpdate ann) {
	}

	public boolean isValid(PetShopDTO objDto, ConstraintValidatorContext context) {

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request
				.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		// Map estrutura de dados, chave e valor exemplo(chave id, valor 2)

		List<FieldMessage> list = new ArrayList<>();

		PetShop aux = petShopRepository.findByEmail(objDto.getEmail());
		if (aux != null && !aux.getId().equals(uriId)) { // verificando se email já existe
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
