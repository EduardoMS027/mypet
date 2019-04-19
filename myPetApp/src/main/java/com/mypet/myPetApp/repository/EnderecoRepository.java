package com.mypet.myPetApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypet.myPetApp.entity.Endereco;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {


}