package com.mypet.myPetApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.stereotype.Service;

import com.mypet.myPetApp.dto.PetClientDTO;
import com.mypet.myPetApp.dto.PetClientInsertDTO;
import com.mypet.myPetApp.entity.Endereco;
import com.mypet.myPetApp.entity.Petclient;
import com.mypet.myPetApp.grupos.TipoGrupo;
import com.mypet.myPetApp.repository.EnderecoRepository;
import com.mypet.myPetApp.repository.PetclientRepository;
import com.mypet.myPetApp.service.exceptions.DataInternalException;

@Service
public class PetclientService {

	@Autowired
	PetclientRepository repository;
	@Autowired
	EnderecoRepository enderecoRepository;

	public Petclient find(Integer id) {

		Optional<Petclient> op = repository.findById(id);

		return op.orElseThrow(() -> new com.mypet.myPetApp.service.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + Petclient.class.getName()));
	}

	public Petclient insert(Petclient obj) {
		obj.setId(null);// se o obj tiver valendo alguma coisa o metado ira connsiderar uma atualização
		obj = repository.save(obj);
		enderecoRepository.saveAll(obj.getEndereco());
		return obj;
	}

	public Petclient update(Petclient petClient) {

		Petclient newObj = find(petClient.getId());
		updateData(newObj, petClient);
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

	public List<Petclient> findAll() {
		return repository.findAll();
	}

	public Petclient fromDto(PetClientDTO objDto) { // metado auxiliar que instacia uma categoria a partir de um DTO

		return new Petclient(objDto.getId(), objDto.getEmail(), objDto.getPassword(), null, objDto.getNomeCompleto(),
				objDto.getDataNascimento(), 0, null);
		// nulo porque não temos os dados no DTO

	}

	public Petclient fromDto(PetClientInsertDTO objDto) { // metado auxiliar que instacia uma categoria a partir de um
															// DTO

		Petclient petclient = new Petclient(null, objDto.getEmail(), objDto.getPassword(),
				TipoGrupo.toEnum(objDto.getTipoPerfil()), objDto.getNomeCompleto(), objDto.getDataNascimento(),
				objDto.getAvaliacao(), objDto.getCpf());
		Endereco endereco = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(),
				objDto.getBairro(), objDto.getCep(), petclient);
		petclient.getEndereco().add(endereco);
		petclient.getTelefones().add(objDto.getTelefone1());

		if (objDto.getTelefone2() != null) {
			petclient.getTelefones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3() != null) {
			petclient.getTelefones().add(objDto.getTelefone3());
		}

		return petclient;

	}

	private void updateData(Petclient newObj, Petclient obj) { // metado aux para atualizar os campos do cliente,

		newObj.setEmail(obj.getEmail());// pegando o novo e colocando no antigo
		newObj.setPassword(obj.getPassword());
		newObj.setNomeCompleto(obj.getNomeCompleto());
		newObj.setDataNascimento(obj.getDataNascimento());

	}

}
