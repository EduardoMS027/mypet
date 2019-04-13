package com.mypet.myPetApp.entity;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.validator.constraints.UniqueElements;

import com.mypet.myPetApp.entity.Endereco;
import com.mypet.myPetApp.entity.Pet;

@Entity
@Table(name = "petclient")
public class Petclient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @UniqueElements
    private String email;
    private String password;
    private String tipoPerfil;
    private String nomeCompleto;
    private int dataNascimento;
    private int avaliacao;
    

    //private Set<Pet> pets;

    
   // private Set<Endereco> enderecos;


    public Petclient (){

    }

    public Petclient (String email, String password, String tipoPerfil, String nomeCompleto, int dataNascimento, int avaliacao){
    
        super();
        this.email = email;
        this.password = password;
        this.tipoPerfil = tipoPerfil;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.avaliacao = avaliacao;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
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
    public int getDataNascimento() {
        return dataNascimento;
    }
    
    public Integer getAvaliacao() {
        return avaliacao;
    }
    /**
     * @return the pet
     */
  //  public Set<Pet> getPet() {
   //     return pets;
    //}
    /**
     * @return the tipoPerfil
     */
    public String getTipoPerfil() {
        return tipoPerfil;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
    public void setDataNascimento(int dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    /**
     * @param avaliacao the avaliacao to set
     */
    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }
    /**
     * @param pet the pet to set
     */
   // public void setPet(Set<Pet> pets) {
   //     this.pets = pets;
   // }
    /**
     * @param tipoPerfil the tipoPerfil to set
     */
    public void setTipoPerfil(String tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    /**
     * @return the endereco
     */
  //  public Set<Endereco> getEndereco() {
    //    return enderecos;
  //  }
    /**
     * @param endereco the endereco to set
     */
   // public void setEndereco(Set<Endereco> enderecos) {
      //  this.enderecos = enderecos;
   // }

    @Override
    public String toString() {
        return "Id: " + getId() + "Email: " + getEmail() + "Password: " + getPassword() + "Tipo de perfil: " + getTipoPerfil() + "Nome completo: " + getNomeCompleto() + "Data de nascimento: " + getDataNascimento()  + "Avaliação: " + getAvaliacao() ;
    }


}