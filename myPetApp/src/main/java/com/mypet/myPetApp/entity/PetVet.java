package com.mypet.myPetApp.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class PetVet extends PetProvider {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeRazaoSocial;
    private String cnpj;

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @return the nomeRazaoSocial
     */
    public String getNomeRazaoSocial() {
        return nomeRazaoSocial;
    }
    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param nomeRazaoSocial the nomeRazaoSocial to set
     */
    public void setNomeRazaoSocial(String nomeRazaoSocial) {
        this.nomeRazaoSocial = nomeRazaoSocial;
    }

    

}