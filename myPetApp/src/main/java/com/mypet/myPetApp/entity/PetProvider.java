package com.mypet.myPetApp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)// para mapear instacias no banco de dados
public class PetProvider implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String password;
    private int avaliacao;


    public PetProvider() {

    }

    public PetProvider(String email, String password, int avaliacao) {
        this.email = email;
        this.password = password;
        this.avaliacao = avaliacao;
    }

    /**
     * @return the avaliacao
     */
    public int getAvaliacao() {
        return avaliacao;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param avaliacao the avaliacao to set
     */
    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}