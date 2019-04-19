package com.mypet.myPetApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.mypet.myPetApp.entity.Servico;


@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {


}