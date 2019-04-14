package com.mypet.myPetApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mypet.myPetApp.entity.Petclient;
import com.mypet.myPetApp.grupos.TipoGrupo;
import com.mypet.myPetApp.repository.PetclientRepository;

@SpringBootApplication
public class MyPetAppApplication implements CommandLineRunner{

	@Autowired
	private PetclientRepository petClientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MyPetAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Petclient cat1 = new Petclient(null, "Yuricesarr@gmail.com", "12345", TipoGrupo.CLIENTE, "Yur1 Cesar", 2104, 05);
		petClientRepository.save(cat1);
		
		
	}

}
