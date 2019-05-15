package com.mypet.myPetApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.mypet.myPetApp.dto.PetVetDTO;
import com.mypet.myPetApp.dto.PetVetInsertDTO;



import com.mypet.myPetApp.entity.PetVet;

import com.mypet.myPetApp.grupos.TipoGrupo;


import com.mypet.myPetApp.repository.PetVetRepository;
import com.mypet.myPetApp.service.exceptions.DataInternalException;

@Service
public class PetVetService {

	@Autowired
	private PetVetRepository petVetRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	public PetVet find(Integer id) {

		Optional<PetVet> op = petVetRepository.findById(id);

		return op.orElseThrow(() -> new com.mypet.myPetApp.service.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + PetVet.class.getName()));
	}

	public PetVet insert(PetVet obj) {
		obj.setId(null);// se o obj tiver valendo alguma coisa o metado ira connsiderar uma atualização
		obj = petVetRepository.save(obj);
		return obj;
	}

	public PetVet update(PetVet petVet) {

		PetVet newObj = find(petVet.getId());
		updateData(newObj, petVet);
		return petVetRepository.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			petVetRepository.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new DataInternalException("Não é possivel exclui porque há entidades relacionadas");
		}
	}

	public List<PetVet> findAll() {
		return petVetRepository.findAll();
	}

	public PetVet fromDtoPetVet(PetVetDTO objDto) { // metado auxiliar que instacia uma categoria a partir de um DTO

		return new PetVet(objDto.getId(), objDto.getNomeRazaoSocial(),null,null,objDto.getEmail(),null,0,objDto.getBairro(),objDto.getLogradouro(),objDto.getNumero(),objDto.getCep());
		// nulo porque não temos os dados no DTO
		
	}

	public PetVet fromDto(PetVetInsertDTO objDto) { // metado auxiliar que instacia uma categoria a partir de um
															// DTO

		PetVet petVet = new PetVet(null, objDto.getNomeRazaoSocial(), objDto.getCnpj(),TipoGrupo.toEnum(objDto.getTipoPerfil()),objDto.getEmail(), bCryptPasswordEncoder.encode(objDto.getPassword()),
				         0,objDto.getLogradouro(),objDto.getNumero(), objDto.getBairro(),objDto.getCep());
	
	
		petVet.getTelefones().add(objDto.getTelefone1());

		if (objDto.getTelefone2() != null) {
			petVet.getTelefones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3() != null) {
			petVet.getTelefones().add(objDto.getTelefone3());
		}

		return petVet;

	}

	private void updateData(PetVet newObj, PetVet obj) { // metado aux para atualizar os campos do cliente,
		
		
		newObj.setNomeRazaoSocial(obj.getNomeRazaoSocial());
		newObj.setEmail(obj.getEmail());// pegando o novo e colocando no antigo
		newObj.setPassword(obj.getPassword());
		
		newObj.setLogradouro(obj.getLogradouro());
		newObj.setNumero(obj.getNumero());
		newObj.setBairro(obj.getBairro());
		newObj.setCep(obj.getCep());





	}
}
