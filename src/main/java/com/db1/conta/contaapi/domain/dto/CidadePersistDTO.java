package com.db1.conta.contaapi.domain.dto;

import java.io.Serializable;

import com.db1.conta.contaapi.domain.entity.Estado;

public class CidadePersistDTO implements Serializable {

	private static final long serialVersionUID = 7041215295972851764L;
	
	private String nome;
	
	private Estado estado;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Estado getEstado() {
		return estado;
	}

}
