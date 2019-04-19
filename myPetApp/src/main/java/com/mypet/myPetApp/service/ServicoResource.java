package com.mypet.myPetApp.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.mypet.myPetApp.entity.Servico;
import com.mypet.myPetApp.repository.ServicoRepository;
import com.mypet.myPetApp.service.exceptions.ObjectNotFoundException;

@Service
public class ServicoResource {

	@Autowired
	ServicoRepository servicoRepository;

	public Servico find(Integer id) {

		java.util.Optional<Servico> op = servicoRepository.findById(id);

		return op.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + Servico.class.getName()));
	}

}
