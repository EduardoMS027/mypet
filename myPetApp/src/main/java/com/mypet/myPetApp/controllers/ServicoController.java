package com.mypet.myPetApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mypet.myPetApp.entity.Servico;
import com.mypet.myPetApp.service.ServicoResource;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoController {

	
	//private PedidoService pedidoService;
	
	 @Autowired
	 private ServicoResource servicoResource;
	
	
	@RequestMapping(value= "/{id}", method=RequestMethod.GET)// para bater em um end pont com id
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		
		Servico obj = servicoResource.find(id);
		
		 
		return ResponseEntity.ok().body(obj) ;
		
	}
	
}
