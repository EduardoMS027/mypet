package com.mypet.myPetApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;



import com.mypet.myPetApp.entity.Petclient;

@Repository
public interface PetclientRepository extends JpaRepository<Petclient, Integer> {
	
	@Transactional(readOnly = true) // diz que transação não necessita ser envolvida no banco de dados
    Petclient findByEmail(String email);

    Optional<Petclient> findById(Integer id); //utilização do por questão do CRUD nativo do Spring Boot

}