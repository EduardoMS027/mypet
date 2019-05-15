package com.mypet.myPetApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import java.util.stream.Collectors;

import javax.validation.Valid;


import com.mypet.myPetApp.service.PetVetService;




import com.mypet.myPetApp.dto.PetVetDTO;
import com.mypet.myPetApp.dto.PetVetInsertDTO;
import com.mypet.myPetApp.entity.PetVet;

@RestController
@RequestMapping(value = "/petvets")
public class PetVetController {

    @Autowired
	private PetVetService service;

    
    
    @CrossOrigin
    @RequestMapping( method = RequestMethod.GET) // para bater em um end pont com id
	public ResponseEntity <List<PetVetDTO>> findAll( Integer id) {
    	List<PetVet> list = service.findAll();
    	List<PetVetDTO> listDto = list.stream().map(obj -> new PetVetDTO(obj)).collect(Collectors.toList()); // stream percorre a lista, map realiza uma operação para cada elemento da lista,collector realiza a transformação para lista novamente
		
		return ResponseEntity.ok().body(listDto);

	}

	@CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET) // para bater em um end pont com id
	public ResponseEntity<PetVet> find(@PathVariable Integer id) {

		PetVet obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PetVetInsertDTO objDto) { // requestBody faz o json ser convertido para obj
																		// java automaticamente
		PetVet obj = service.fromDto(objDto);//coverto Dto para objeto entidade
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PetVetDTO objDto, @PathVariable Integer id) {// receber o obejto json e
																								// tambem o parametro da
		PetVet obj = (PetVet) service.fromDtoPetVet(objDto);																						// URL
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) // para bater em um end pont com id
	public ResponseEntity<Void> delete(@PathVariable Integer id)  {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}
	
}