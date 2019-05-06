package com.mypet.myPetApp.dto;

import java.io.Serializable;

import javax.persistence.Column;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;

import com.mypet.myPetApp.entity.PetHome;

import com.mypet.myPetApp.service.validation.servicos.PetHomeUpdate;



@PetHomeUpdate
public class PetHomeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	    private Integer id;
	   
	    @Column(unique = true) // deixa campo como unico no banco de dados
	    private String email;
	    
	    @NotEmpty(message = "Prenchimento obrigatório")
		@Length(min=5,max=120, message = "O tamanho deve ser entre 5 e 120 caracteres")
	    private String nomeCompleto;
	    
	    @NotEmpty(message = "Prenchimento obrigatório")
		@Length(min=5,max=8, message = "O tamanho deve ser entre 5 e 8 caracteres")
	    private String password;
	    
	    
	    private String dataNascimento;
		@NotEmpty(message = "Prenchimento obrigatório")
		private String logradouro;

		@NotEmpty(message = "Prenchimento obrigatório")
		private String numero;

		private String bairro;

		@NotEmpty(message = "Prenchimento obrigatório")
		private String cep;
	   
	    
	    public PetHomeDTO() {
	    	
	    }

		public PetHomeDTO(PetHome petHome) {
		
			this.id = petHome.getId();
			this.email = petHome.getEmail();
			this.nomeCompleto = petHome.getNomeCompleto();
			this.password = petHome.getPassword();
			this.dataNascimento = petHome.getDataNascimento();
			this.logradouro = petHome.getLogradouro();
			this.numero = petHome.getNumero();
			this.bairro = petHome.getBairro();
			this.cep = petHome.getCep();
			
			
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

		public String getNomeCompleto() {
			return nomeCompleto;
		}

		public void setNomeCompleto(String nomeCompleto) {
			this.nomeCompleto = nomeCompleto;
		}


		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(String dataNascimento) {
			this.dataNascimento = dataNascimento;
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
