package com.mypet.myPetApp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mypet.myPetApp.entity.Endereco;
import com.mypet.myPetApp.entity.Petclient;
import com.mypet.myPetApp.grupos.TipoGrupo;
import com.mypet.myPetApp.repository.EnderecoRepository;
import com.mypet.myPetApp.repository.PetclientRepository;

@SpringBootApplication
public class MyPetAppApplication implements CommandLineRunner {

	@Autowired
	private PetclientRepository petClientRepository;
	@Autowired
	private EnderecoRepository enderecoRepositoty;

	public static void main(String[] args) {
		SpringApplication.run(MyPetAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Petclient pet1 = new Petclient(null, "Yuricesarr@gmail.com", "12345", TipoGrupo.CLIENTE, "Yur1 Cesar", "210405", 0, null);
		petClientRepository.save(pet1);

		Petclient pet2 = new Petclient(null, "Yuricesarr@gmail.com", "12345", TipoGrupo.CLIENTE, "Yur1 Cesar", "210405", 0, null);
		petClientRepository.save(pet2);

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", pet2);

		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "centro", "8777012", pet1);
		pet1.getEndereco().addAll(Arrays.asList(e1, e2)); // cliente conhecendo seu endereços

		petClientRepository.saveAll(Arrays.asList(pet1));
		enderecoRepositoty.saveAll(Arrays.asList(e1, e2));

	}

}
