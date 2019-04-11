package com.mypet.myPetApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.mypet.myPetApp.entity.Petclient;

public interface PetclientRepository extends JpaRepository<Petclient, Long> {

    Petclient findByEmail(String email);

    Optional<Petclient> findById(Long id); //utilização do por questão do CRUD nativo do Spring Boot

}