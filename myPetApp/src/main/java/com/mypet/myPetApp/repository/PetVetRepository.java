package com.mypet.myPetApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mypet.myPetApp.entity.PetVet;


@Repository
public interface PetVetRepository extends JpaRepository<PetVet, Integer>{
	
	@Transactional(readOnly = true) // diz que transação não necessita ser envolvida no banco de dados
	PetVet findByEmail(String email);
}
