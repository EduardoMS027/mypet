package com.mypet.myPetApp.dto;

import java.io.Serializable;

import com.mypet.myPetApp.entity.Petclient;

public class PetClientDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	
	    private Integer id;
	    private String email;
	    private String nomeCompleto;
	    private String password;
	    private String dataNascimento;
	   
	    
	    public PetClientDTO() {
	    	
	    }

		public PetClientDTO(Petclient petClient) {
		
			this.id = petClient.getId();
			this.email = petClient.getEmail();
			this.nomeCompleto = petClient.getNomeCompleto();
			this.password = petClient.getPassword();
			this.dataNascimento = petClient.getDataNascimento();
			
			
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

	
	    
	    
}
