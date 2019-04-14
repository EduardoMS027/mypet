package com.mypet.myPetApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypet.myPetApp.controllers.PetclientController;
import com.mypet.myPetApp.entity.Petclient;
import com.mypet.myPetApp.grupos.TipoGrupo;
import com.mypet.myPetApp.repository.PetclientRepository;
import com.mypet.myPetApp.service.exceptions.DataInternalException;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PetclientResource {

	@Autowired
	 PetclientRepository repository;

	public Petclient find(Integer id) {

		Optional<Petclient> op = repository.findById(id);

		return op.orElseThrow(() -> new com.mypet.myPetApp.service.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + Petclient.class.getName()));
	}
	public  Petclient insert( Petclient obj) {
		obj.setId(null);// se o obj tiver valendo alguma coisa o metado ira connsiderar uma atualização
		return repository.save(obj);
	}

	public Petclient update(Petclient petClient) {

		Petclient newObj = find(petClient.getId());
		updateData(newObj, petClient);
		return repository.save(newObj);
	}

	public void delete(Integer id)  {
		find(id);
		try {
			repository.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new DataInternalException("Não é possivel exclui porque há entidades relacionadas");
		}
	}

	private void updateData(Petclient newObj, Petclient obj) { // metado aux para atualizar os campos do cliente,
																// pegando o novo e colocando no antigo
		newObj.setNomeCompleto(obj.getNomeCompleto());
		newObj.setEmail(obj.getEmail());
	}

}
