package com.db1.conta.contaapi.domain.entity;

import org.springframework.util.Assert;

public class Agencia {

	private Long id;
	
	private String numero;
	
	private String digito;
	
	private Cidade cidade; 
	
	public Agencia(String numero, String digito, Cidade cidade) {
		Assert.hasText(numero, "Número é obrigatório");
		Assert.hasText(digito, "Dígito é obrigatório");
		Assert.notNull(cidade, "Cidade é obrigatória");
		
		this.numero = numero;
		this.digito = digito;
		this.cidade = cidade;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public String getDigito() {
		return digito;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	
}
