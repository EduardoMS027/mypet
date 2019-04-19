package com.mypet.myPetApp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Servico implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date instanteServico;
	
	@ManyToOne
	@JoinColumn(name = "endereço_do_serviço")
	private Endereco enderecoServico;
	
	@ManyToOne
	@JoinColumn(name = "petCliente_id")
	private Petclient petclientServico;
	
	@ManyToOne
	@JoinColumn(name = "historico_do_pedido")
	private Historico historico;
	
	
	public Servico() {
		
	}


	public Servico(Integer id, Date instanteServico, Endereco endereco, Historico historico) {
		super();
		this.id = id;
		this.instanteServico = instanteServico;
		this.enderecoServico = endereco;
		this.historico = historico;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getInstanteServico() {
		return instanteServico;
	}


	public void setInstanteServico(Date instanteServico) {
		this.instanteServico = instanteServico;
	}


	public Endereco getEndereco() {
		return enderecoServico;
	}


	public void setEndereco(Endereco endereco) {
		this.enderecoServico = endereco;
	}


	public Historico getHistorico() {
		return historico;
	}


	public void setHistorico(Historico historico) {
		this.historico = historico;
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
		Servico other = (Servico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
