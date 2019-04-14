package com.mypet.myPetApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.mypet.myPetApp.entity.Petclient;

@Repository
public interface PetclientRepository extends JpaRepository<Petclient, Integer> {

    Petclient findByEmail(String email);

    Optional<Petclient> findById(Integer id); //utilização do por questão do CRUD nativo do Spring Boot

}