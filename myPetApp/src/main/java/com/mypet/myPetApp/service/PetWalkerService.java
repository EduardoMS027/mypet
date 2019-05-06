package com.mypet.myPetApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.stereotype.Service;


import com.mypet.myPetApp.dto.PetWalkerDTO;
import com.mypet.myPetApp.dto.PetWalkerInsertDTO;

import com.mypet.myPetApp.entity.PetWalker;

import com.mypet.myPetApp.grupos.TipoGrupo;

import com.mypet.myPetApp.repository.PetWalkerRepository;

import com.mypet.myPetApp.service.exceptions.DataInternalException;

@Service
public class PetWalkerService {

	@Autowired
	PetWalkerRepository repository;
	

	public PetWalker find(Integer id) {

		Optional<PetWalker> op = repository.findById(id);

		return op.orElseThrow(() -> new com.mypet.myPetApp.service.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + PetWalker.class.getName()));
	}

	public PetWalker insert(PetWalker obj) {
		obj.setId(null);// se o obj tiver valendo alguma coisa o metado ira connsiderar uma atualização
		obj = repository.save(obj);
	
		return obj;
	}

	public PetWalker update(PetWalker petWalker) {

		PetWalker newObj = find(petWalker.getId());
		updateData(newObj, petWalker);
		return repository.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new DataInternalException("Não é possivel exclui porque há entidades relacionadas");
		}
	}

	public List<PetWalker> findAll() {
		return repository.findAll();
	}

	public PetWalker fromDto(PetWalkerDTO objDto) { // metado auxiliar que instacia uma categoria a partir de um DTO

		return new PetWalker(objDto.getId(), objDto.getNomeCompleto(),objDto.getDataNascimento(),null,objDto.getEmail(),null, 0,
				null,objDto.getLogradouro(),objDto.getNumero(),objDto.getBairro(),objDto.getCep());
				
		// nulo porque não temos os dados no DTO

	}

	public PetWalker fromDto(PetWalkerInsertDTO objDto) { // metado auxiliar que instacia uma categoria a partir de um
															// DTO

		PetWalker petWalker = new PetWalker(null,objDto.getNomeCompleto(),objDto.getDataNascimento(),objDto.getCpfOuCnpj(),
				objDto.getEmail(), objDto.getPassword(),0,TipoGrupo.toEnum(objDto.getTipoPerfil()),
				objDto.getLogradouro(),objDto.getNumero(),objDto.getBairro(),objDto.getCep());
			      
		
	
		petWalker.getTelefones().add(objDto.getTelefone1());

		if (objDto.getTelefone2() != null) {
			petWalker.getTelefones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3() != null) {
			petWalker.getTelefones().add(objDto.getTelefone3());
		}

		return petWalker;

	}

	private void updateData(PetWalker newObj, PetWalker obj) { // metado aux para atualizar os campos do cliente,

		newObj.setEmail(obj.getEmail());// pegando o novo e colocando no antigo
		newObj.setPassword(obj.getPassword());
		newObj.setNomeCompleto(obj.getNomeCompleto());
		newObj.setDataNascimento(obj.getDataNascimento());
		newObj.setLogradouro(obj.getLogradouro());
		newObj.setNumero(obj.getNumero());
		newObj.setBairro(obj.getBairro());
		newObj.setCep(obj.getCep());
		

	}

}
