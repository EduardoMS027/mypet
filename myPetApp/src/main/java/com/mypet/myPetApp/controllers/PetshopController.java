package com.mypet.myPetApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import java.util.stream.Collectors;

import javax.validation.Valid;

import com.mypet.myPetApp.service.PetShopService;

import com.mypet.myPetApp.dto.PetShopDTO;
import com.mypet.myPetApp.dto.PetShopInsertDTO;


import com.mypet.myPetApp.entity.PetShop;


@RestController
@RequestMapping(value = "/petshops")
public class PetShopController {

    @Autowired
	private PetShopService service;

    
    
    
    @RequestMapping( method = RequestMethod.GET) // para bater em um end pont com id
	public ResponseEntity <List<PetShopDTO>> findAll( Integer id) {
    	List<PetShop> list = service.findAll();
    	List<PetShopDTO> listDto = list.stream().map(obj -> new PetShopDTO(obj)).collect(Collectors.toList()); // stream percorre a lista, map realiza uma operação para cada elemento da lista,collector realiza a transformação para lista novamente
		
		return ResponseEntity.ok().body(listDto);

	}
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET) // para bater em um end pont com id
	public ResponseEntity<PetShop> find(@PathVariable Integer id) {

    	PetShop obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PetShopInsertDTO objDto) { // requestBody faz o json ser convertido para obj
																		// java automaticamente
		PetShop obj = service.fromDto(objDto);//coverto Dto para objeto entidade
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PetShopDTO objDto, @PathVariable Integer id) {// receber o obejto json e
																								// tambem o parametro da
		PetShop obj = (PetShop) service.fromDtoPetShop(objDto);																					// URL
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