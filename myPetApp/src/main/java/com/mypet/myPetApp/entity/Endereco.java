package com.mypet.myPetApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco{

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

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }
    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }
    /**
     * @return the numeroMoradia
     */
    public String getNumeroMoradia() {
        return numeroMoradia;
    }
    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }
    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    /**
     * @param numeroMoradia the numeroMoradia to set
     */
    public void setNumeroMoradia(String numeroMoradia) {
        this.numeroMoradia = numeroMoradia;
    }
    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + "Rua: " + getRua() + "Número da moratida: " +getNumeroMoradia() + "Cidade: " + getCidade()  + "Estado: " + getEstado();
    }

}