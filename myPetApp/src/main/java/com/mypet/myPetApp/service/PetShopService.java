package com.mypet.myPetApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mypet.myPetApp.dto.PetShopDTO;
import com.mypet.myPetApp.dto.PetShopInsertDTO;

import com.mypet.myPetApp.entity.PetShop;

import com.mypet.myPetApp.grupos.TipoGrupo;

import com.mypet.myPetApp.repository.PetShopRepository;

import com.mypet.myPetApp.service.exceptions.DataInternalException;

@Service
public class PetShopService {

	@Autowired
	private PetShopRepository petShopRepository;

	public PetShop find(Integer id) {

		Optional<PetShop> op = petShopRepository.findById(id);

		return op.orElseThrow(() -> new com.mypet.myPetApp.service.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + PetShop.class.getName()));
	}

	public PetShop insert(PetShop obj) {
		obj.setId(null);// se o obj tiver valendo alguma coisa o metado ira connsiderar uma atualização
		obj = petShopRepository.save(obj);
		return obj;
	}

	public PetShop update(PetShop petShop) {

		PetShop newObj = find(petShop.getId());
		updateData(newObj, petShop);
		return petShopRepository.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			petShopRepository.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new DataInternalException("Não é possivel exclui porque há entidades relacionadas");
		}
	}

	public List<PetShop> findAll() {
		return petShopRepository.findAll();
	}

	public PetShop fromDtoPetShop(PetShopDTO objDto) { // metado auxiliar que instacia uma categoria a partir de um DTO

		return new PetShop(objDto.getId(), objDto.getNomeRazaoSocial(), null, null, objDto.getEmail(),
				objDto.getPassword(), 0,  objDto.getLogradouro(), objDto.getNumero(),objDto.getBairro(),
				objDto.getCep());
		// nulo porque não temos os dados no DTO

	}

	public PetShop fromDto(PetShopInsertDTO objDto) { // metado auxiliar que instacia uma categoria a partir de um
														// DTO

		PetShop petShop = new PetShop(null, objDto.getNomeRazaoSocial(), objDto.getCnpj(),
				TipoGrupo.toEnum(objDto.getTipoPerfil()), objDto.getEmail(), objDto.getPassword(), 0,
				objDto.getBairro(), objDto.getLogradouro(), objDto.getNumero(), objDto.getCep());

		petShop.getTelefones().add(objDto.getTelefone1());

		if (objDto.getTelefone2() != null) {
			petShop.getTelefones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3() != null) {
			petShop.getTelefones().add(objDto.getTelefone3());
		}

		return petShop;

	}

	private void updateData(PetShop newObj, PetShop obj) { // metado aux para atualizar os campos do cliente,

		newObj.setNomeRazaoSocial(obj.getNomeRazaoSocial());
		newObj.setEmail(obj.getEmail());// pegando o novo e colocando no antigo
		newObj.setPassword(obj.getPassword());

		newObj.setLogradouro(obj.getLogradouro());
		newObj.setNumero(obj.getNumero());
		newObj.setBairro(obj.getBairro());
		newObj.setCep(obj.getCep());

	}
}
