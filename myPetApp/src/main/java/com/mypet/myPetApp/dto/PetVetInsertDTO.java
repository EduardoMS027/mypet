package com.mypet.myPetApp.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.mypet.myPetApp.entity.Endereco;
import com.mypet.myPetApp.service.validation.ClienteInsert;
import com.mypet.myPetApp.service.validation.servicos.PetVetInsert;

//Classe destina para cadastro de petclient.

@PetVetInsert
public class PetVetInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preechimento obrigatório")
	@Email(message = "Email inválido")
	private   String email;

	@NotEmpty(message = "Preechimento obrigatório")
	private  String password;
	private Integer tipoPerfil;

	@NotEmpty(message = "Prenchimento obrigatório")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
	 private String nomeRazaoSocial;
	
	

	

	@NotEmpty(message = "Preechimento obrigatório")
	 private String cnpj;

	@NotEmpty(message = "Preechimento obrigatório")
	private String logradouro;
	private String numero;
	private String bairro;
	@NotEmpty(message = "Preechimento obrigatório")
	private String cep;

	@NotEmpty(message = "Preechimento obrigatório")
	private String telefone1;
	private String telefone2;
	private String telefone3;
	
	
	
	public PetVetInsertDTO() {
		
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

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}






	
}
