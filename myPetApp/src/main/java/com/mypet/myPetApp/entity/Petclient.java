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



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mypet.myPetApp.grupos.TipoGrupo;


@Entity
public class Petclient implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String email;
    private String password;
    private Integer tipoPerfil;
    private String nomeCompleto;
    private String dataNascimento;
    private int avaliacao;
    private String cpf;
    
    

    //private Set<Pet> pets;

    
   // private Set<Endereco> enderecos;

    @OneToMany(mappedBy = "petclient",cascade = CascadeType.ALL) // cascade, toda modificação que ocorrer no cliente ocorre em endereço com efeito cascata (quando apgar um cliente apaga um endereço tb)
    private List<Endereco> endereco = new ArrayList<>();
    
    @JsonIgnore // pedidos do clinete não sera serealizados.
	@OneToMany(mappedBy = "petclientServico")
    private List<Servico> servicos = new ArrayList<>();
    
    @ElementCollection
	@CollectionTable(name = "TELEFONE")//nome da tabela
	private Set<String> telefones = new HashSet<>();//permite não repetir valores(represanta os conjuntos de valores )
	
    
  



	public Petclient (){

    }

 

    public Petclient(Integer id, String email, String password, TipoGrupo tipoPerfil, String nomeCompleto,
    		String dataNascimento, int avaliacao,String cpf) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.tipoPerfil = (tipoPerfil==null) ? null : tipoPerfil.getCod(); //operador ternario ..  na intaciação não aceita nullo precisa de uma condicional por conta do getCod
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
		this.avaliacao = avaliacao;
		this.cpf = cpf;
	}



	/**
     * @return the id
     */
    public Integer getId() {
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
    public String getDataNascimento() {
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
    public TipoGrupo getTipoPerfil() {
        return TipoGrupo.toEnum(tipoPerfil);
    }
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
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
    public void setDataNascimento(String dataNascimento) {
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
    public void setTipoPerfil(TipoGrupo tipoPerfil) {
        this.tipoPerfil = tipoPerfil.getCod();
    }
    public List<Endereco> getEndereco() {
  		return endereco;
  	}



  	public void setEndereco(List<Endereco> endereco) {
  		this.endereco = endereco;
  	}
  	

    public List<Servico> getServicos() {
		return servicos;
	}



	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}



	public Set<String> getTelefones() {
		return telefones;
	}



	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Petclient other = (Petclient) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


}