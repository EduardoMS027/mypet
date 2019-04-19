package com.mypet.myPetApp.dto;

import java.io.Serializable;

import com.mypet.myPetApp.entity.Petclient;

public class PetClientDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	
	    private Integer id;
	    private String email;
	    private String nomeCompleto;
	   
	    
	    public PetClientDTO() {
	    	
	    }

		public PetClientDTO(Petclient petClient) {
		
			id = petClient.getId();
			email = petClient.getEmail();
			nomeCompleto = petClient.getNomeCompleto();
			
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

	
	    
	    
}
