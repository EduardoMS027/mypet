package com.mypet.myPetApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.mypet.myPetApp.repository.PetclientRepository;
import com.mypet.myPetApp.service.PetclientResource;

import javassist.tools.rmi.ObjectNotFoundException;

import com.mypet.myPetApp.dto.PetClientDTO;
import com.mypet.myPetApp.entity.Petclient;

@RestController
@RequestMapping(value = "/petclientes")
public class PetclientController {

    @Autowired
	private PetclientResource service;

    
    
    
    @RequestMapping( method = RequestMethod.GET) // para bater em um end pont com id
	public ResponseEntity <List<PetClientDTO>> findAll( Integer id) {
    	List<Petclient> list = service.findAll();
    	List<PetClientDTO> listDto = list.stream().map(obj -> new PetClientDTO(obj)).collect(Collectors.toList()); // stream percorre a lista, map realiza uma operação para cada elemento da lista,collector realiza a transformação para lista novamente
		
		return ResponseEntity.ok().body(listDto);

	}
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET) // para bater em um end pont com id
	public ResponseEntity<Petclient> find(@PathVariable Integer id) {

		Petclient obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Petclient obj) { // requestBody faz o json ser convertido para obj
																		// java automaticamente
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Petclient obj, @PathVariable Integer id) {// receber o obejto json e
																								// tambem o parametro da
																								// URL
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) // para bater em um end pont com id
	public ResponseEntity<Void> delete(@PathVariable Integer id)  {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}
	
}