package com.mypet.myPetApp.entity;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PetWalker extends PetProvider{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomeCompleto;
    private String dataNascimento; // "aaaa-mm-dd"
    private String cpf;

    public PetWalker() {

    }

    public PetWalker(String nomeCompleto, String dataNascimento, String cpf) {
        super();
    	this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }
    /**
     * @return the dataNascimento
     */
    public String getDataNascimento() {
        return dataNascimento;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @return the nomeCompleto
     */
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @param nomeCompleto the nomeCompleto to set
     */
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
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