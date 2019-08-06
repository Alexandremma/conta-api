package com.db1.conta.contaapi.domain.dto;

import java.io.Serializable;

import com.db1.conta.contaapi.domain.entity.Estado;

public class CidadeResponseDTO implements Serializable {

	private static final long serialVersionUID = 3090571035302249904L;

	private Long id;
	
	private String nome;
	
	private Estado estado;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
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
