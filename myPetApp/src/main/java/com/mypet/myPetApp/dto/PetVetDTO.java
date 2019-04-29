package com.mypet.myPetApp.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.mypet.myPetApp.entity.PetVet;
import com.mypet.myPetApp.service.validation.servicos.PetVetUpdate;

@PetVetUpdate
public class PetVetDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@Column(unique = true) // deixa campo como unico no banco de dados
	private String email;

	@NotEmpty(message = "Prenchimento obrigatório")
	@Length(min = 5, max = 8, message = "O tamanho deve ser entre 5 e 8 caracteres")
	private String password;
	private int avaliacao;

	@NotEmpty(message = "Prenchimento obrigatório")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
	private String nomeRazaoSocial;

	@NotEmpty(message = "Prenchimento obrigatório")
	private String cnpj;

	@NotEmpty(message = "Prenchimento obrigatório")
	private String logradouro;

	@NotEmpty(message = "Prenchimento obrigatório")
	private String numero;

	private String bairro;

	@NotEmpty(message = "Prenchimento obrigatório")
	private String cep;

	public PetVetDTO() {

	}

	public PetVetDTO(PetVet petVet) {
		super();
		this.id = petVet.getId();
		this.email = petVet.getEmail();
		this.password = petVet.getPassword();
		this.avaliacao = petVet.getAvaliacao();
		this.nomeRazaoSocial = petVet.getNomeRazaoSocial();
		this.cnpj = petVet.getCnpj();
		this.logradouro = petVet.getLogradouro();
		this.numero = petVet.getNumero();
		this.bairro = petVet.getBairro();
		this.cep = petVet.getCep();
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

	public String getNomeRazaoSocial() {
		return nomeRazaoSocial;
	}

	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
