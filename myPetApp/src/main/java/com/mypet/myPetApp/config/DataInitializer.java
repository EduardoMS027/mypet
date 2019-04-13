package com.mypet.myPetApp.config;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.mypet.myPetApp.entity.Petclient;
import com.mypet.myPetApp.repository.PetclientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


/*
@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    PetclientRepository petclientRepository;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        List<Petclient> listPetcSlient = petclientRepository.findAll();
        

        if(listPetclient.isEmpty()){
            int idade = calculateAge("1997-01-27", "2019-04-11");


            createPetclient("eduardoTest@gamil.com", "senhaTesteEduardo", "cliente", "Eduardo Marques da Silva", idade , 5);
            createPetclient("email", "password", "tipoPerfil", "nomeCompleto", idade, 5);
        }
    
    
    }

    public void createPetclient(String email, String password, String tipoPerfil, String nomeCompleto, 
    int dataNascimento, int avaliacao){

        Petclient varPetclient = new Petclient(email, password, tipoPerfil, nomeCompleto, dataNascimento,  avaliacao);

        petclientRepository.save(varPetclient);
    }

    public int calculateAge(String strBirthDate,String strCurrentDate) {
        LocalDate birthDate;
        LocalDate currentDate;
        birthDate = LocalDate.parse(strBirthDate);
        currentDate = LocalDate.parse(strCurrentDate);

        return Period.between(extracted(birthDate), extracted(currentDate)).getYears();
    }

    private LocalDate extracted(LocalDate currentDate) {
        return currentDate;
    }
}
*/