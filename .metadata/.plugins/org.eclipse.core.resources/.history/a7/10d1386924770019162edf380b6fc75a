package com.mypet.myPetApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mypet.myPetApp.dto.PetHomeDTO;
import com.mypet.myPetApp.dto.PetHomeInsertDTO;


import com.mypet.myPetApp.entity.PetHome;


import com.mypet.myPetApp.grupos.TipoGrupo;
import com.mypet.myPetApp.repository.PetHomeRepository;


import com.mypet.myPetApp.service.exceptions.DataInternalException;

@Service
public class PetHomeService {

	@Autowired
	PetHomeRepository repository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	public PetHome find(Integer id) {

		Optional<PetHome> op = repository.findById(id);

		return op.orElseThrow(() -> new com.mypet.myPetApp.service.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + PetHome.class.getName()));
	}

	public PetHome insert(PetHome obj) {
		obj.setId(null);// se o obj tiver valendo alguma coisa o metado ira connsiderar uma atualização
		obj = repository.save(obj);
	
		return obj;
	}

	public PetHome update(PetHome petHome) {

		PetHome newObj = find(petHome.getId());
		updateData(newObj, petHome);
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

	public List<PetHome> findAll() {
		return repository.findAll();
	}

	public PetHome fromDto(PetHomeDTO objDto) { // metado auxiliar que instacia uma categoria a partir de um DTO

		return new PetHome(objDto.getId(), objDto.getNomeCompleto(),objDto.getDataNascimento(),null,objDto.getEmail(),null, 0,
				null,objDto.getLogradouro(),objDto.getNumero(),objDto.getBairro(),objDto.getCep());
				
		// nulo porque não temos os dados no DTO

	}

	public PetHome fromDto(PetHomeInsertDTO objDto) { // metado auxiliar que instacia uma categoria a partir de um
															// DTO

		PetHome pethome = new PetHome(null,objDto.getNomeCompleto(),objDto.getDataNascimento(),objDto.getCpfOuCnpj(),
				objDto.getEmail(),bCryptPasswordEncoder.encode(objDto.getPassword()),0,TipoGrupo.toEnum(objDto.getTipoPerfil()),
				objDto.getLogradouro(),objDto.getNumero(),objDto.getBairro(),objDto.getCep());
			      
		pethome.getTelefones().add(objDto.getTelefone1());

		if (objDto.getTelefone2() != null) {
			pethome.getTelefones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3() != null) {
			pethome.getTelefones().add(objDto.getTelefone3());
		}

		return pethome;

	}

	private void updateData(PetHome newObj, PetHome obj) { // metado aux para atualizar os campos do cliente,

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
