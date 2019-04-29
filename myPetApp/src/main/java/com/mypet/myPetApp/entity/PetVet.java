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
import javax.persistence.OneToMany;

import com.mypet.myPetApp.grupos.TipoGrupo;

@Entity
public class PetVet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nomeRazaoSocial;
	private String cnpj;
	private Integer tipoPerfil;
	private String email;
	private String password;
	private int avaliacao;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;




	@ElementCollection
	@CollectionTable(name = "TELEFONE_PETVET") // nome da tabela
	private Set<String> telefones = new HashSet<>();// permite não repetir valores(represanta os conjuntos de valores )

	public PetVet() {

	}

	public PetVet(Integer id, String nomeRazaoSocial, String cnpj, TipoGrupo tipoPerfil, String email, String password,
			int avaliacao,String logradouro,String numero,String bairro,String cep) {
		super();
		this.id = id;
		this.nomeRazaoSocial = nomeRazaoSocial;
		this.cnpj = cnpj;
		this.tipoPerfil = (tipoPerfil == null) ? null : tipoPerfil.getCod();
		this.email = email;
		this.password = password;
		this.avaliacao = avaliacao;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;

	}

	

	public Integer getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(Integer tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @return the id
	 */

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
	 * @param id              the id to set
	 * 
	 *                        /**
	 * @param nomeRazaoSocial the nomeRazaoSocial to set
	 */
	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
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
	

}