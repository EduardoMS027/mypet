package com.mypet.myPetApp.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


@Inheritance(strategy = InheritanceType.JOINED)// para mapear instacias no banco de dados
public class PetProvider implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private   String email;
    private  String password;
    private   int avaliacao;
    
 

    @ElementCollection
   	@CollectionTable(name = "TELEFONE_PROVAIDER")//nome da tabela
   	private Set<String> telefones = new HashSet<>();//permite não repetir valores(represanta os conjuntos de valores )

	public PetProvider() {

    }

  
	public PetProvider(Integer id,String email, String password, int avaliacao) {
		this.id = id;
		this.email = email;
        this.password = password;
        this.avaliacao = avaliacao;
       
    }

	
	
	
	
	  public Set<String> getTelefones() {
			return telefones;
		}

		public void setTelefones(Set<String> telefones) {
			this.telefones = telefones;
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
    public Integer getId() {
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
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    

  
}