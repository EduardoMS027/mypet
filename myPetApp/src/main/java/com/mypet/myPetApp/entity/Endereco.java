package com.mypet.myPetApp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rua;
    private String estado;
    private String cidade;
    private String numeroMoradia;

    public Endereco(){

    }

    public Endereco(String rua, String estado, String cidade, String numeroMoradia){
        super();
        this.rua = rua;
        this.estado = estado;
        this.cidade = cidade;
        this.numeroMoradia = numeroMoradia;
    }

 
    public Long getId() {
        return id;
    }
   
    public String getCidade() {
        return cidade;
    }
   
    public String getEstado() {
        return estado;
    }
    
    public String getNumeroMoradia() {
        return numeroMoradia;
    }
   
    public String getRua() {
        return rua;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void setNumeroMoradia(String numeroMoradia) {
        this.numeroMoradia = numeroMoradia;
    }
    
    public void setRua(String rua) {
        this.rua = rua;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + "Rua: " + getRua() + "Número da moratida: " +getNumeroMoradia() + "Cidade: " + getCidade()  + "Estado: " + getEstado();
    }

}