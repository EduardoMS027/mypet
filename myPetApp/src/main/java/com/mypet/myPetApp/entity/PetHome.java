package com.mypet.myPetApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PetHome extends PetProvider{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomeCompleto;
    private String dataNascimento; // "aaaa-mm-dd"
    private String cpf;
    private String cnpj;

    public PetHome (){

    }

    public PetHome (String nomeCompleto, String dataNascimento, String cpf, String cnpj){
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.cnpj = cnpj;
    }


    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @return the nomeCompleto
     */
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    /**
     * @return the dataNascimento
     */
    public String getDataNascimento() {
        return dataNascimento;
    }
    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }
    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param nomeCompleto the nomeCompleto to set
     */
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}