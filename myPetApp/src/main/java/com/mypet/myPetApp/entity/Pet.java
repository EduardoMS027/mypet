package com.mypet.myPetApp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mypet.myPetApp.entity.Petclient;

@Entity
public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String porte;
    private String cor;
    private String especie;

    public Pet(){

    }

    public Pet(String nome, String porte, String cor, Petclient donoPet, String especie){
        super();
        this.nome = nome;
        this.porte = porte;
        this.cor = cor;
        this.especie = especie;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * @return the porte
     */
    public String getPorte() {
        return porte;
    }
        /**
     * @return the especie
     */
    public String getEspecie() {
        return especie;
    }
    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }
    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * @param porte the porte to set
     */
    public void setPorte(String porte) {
        this.porte = porte;
    }
    /**
     * @param especie the especie to set
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + "Nome: " + getNome() + "Porte: " + getPorte() + "Cor: " + getCor()  + "Espécie: " + getEspecie();
    }

}