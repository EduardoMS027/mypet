package com.mypet.myPetApp.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mypet.myPetApp.grupos.TipoGrupo;

@Entity
public class PetHome implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomeCompleto;
    private String dataNascimento; // "aaaa-mm-dd"
    private String cpfOuCnpj;
   
    @Column(unique = true) 
    private   String email;
    private  String password;
    private   int avaliacao;
    private Integer tipoPerfil;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	
    
    @ElementCollection
   	@CollectionTable(name = "TELEFONE_HOME")//nome da tabela
   	private Set<String> telefones = new HashSet<>();//permite não repetir valores(represanta os conjuntos de valores )
	
    public PetHome (){

    }
    
    


    public PetHome(Integer id, String nomeCompleto, String dataNascimento, String cpfOuCnpj, String email,
			String password, int avaliacao, TipoGrupo tipoPerfil, String logradouro, String numero, String bairro,
			String cep) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
		this.cpfOuCnpj = cpfOuCnpj;
		this.email = email;
		this.password = password;
		this.avaliacao = avaliacao;
		this.tipoPerfil =  (tipoPerfil == null) ? null : tipoPerfil.getCod();
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
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
     * @return the dataNascimento
     */
    public String getDataNascimento() {
        return dataNascimento;
    }
    /**
     * @return the cpf
     */
   
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
    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    /**
     * @param cpf the cpf to set
     */

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public int getAvaliacao() {
		return avaliacao;
	}




	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}




	public Integer getTipoPerfil() {
		return tipoPerfil;
	}




	public void setTipoPerfil(Integer tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}




	public String getLogradouro() {
		return logradouro;
	}




	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}




	public String getNumero() {
		return numero;
	}




	public void setNumero(String numero) {
		this.numero = numero;
	}




	public String getBairro() {
		return bairro;
	}




	public void setBairro(String bairro) {
		this.bairro = bairro;
	}




	public String getCep() {
		return cep;
	}




	public void setCep(String cep) {
		this.cep = cep;
	}




	public Set<String> getTelefones() {
		return telefones;
	}




	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	
	
   
}