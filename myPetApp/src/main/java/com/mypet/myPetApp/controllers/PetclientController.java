package com.mypet.myPetApp.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


import com.mypet.myPetApp.repository.PetclientRepository;
import com.mypet.myPetApp.entity.Petclient;

@RestController
public class PetclientController {

    private PetclientRepository petclientRepository;

    public PetclientController (PetclientRepository petclientRepository){
        this.petclientRepository = petclientRepository;
    }

    @RequestMapping(value = "/petclient", method = RequestMethod.GET)
    public List<Petclient> findAll(){
        return petclientRepository.findAll();
    }

    @RequestMapping(value = "/petclient/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        petclientRepository.deleteById(id);
    }

    @RequestMapping(value = "/petclient", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Petclient save(@RequestBody Petclient petclient){
        return petclientRepository.save(petclient);
    }

    @RequestMapping(value = "/petclient", method = RequestMethod.PUT)
    public Petclient update(@RequestBody Petclient petclient){
        return petclientRepository.save(petclient);
    }
    
}