package com.db1.conta.contaapi.domain.entity;

import java.util.List;

import org.springframework.util.Assert;

public class Cliente {
	
	private Long id;
	
	private String nome;
	
	private List<Endereco> endereco;
	
	private List<Conta> conta;
	
	private String cpf;
	
	public Cliente(String nome, List<Endereco> endereco, List<Conta> conta, String cpf) {
		Assert.hasText(nome, "Nome é obrigatório");
		Assert.notEmpty(endereco, "Endereço é obrigatório");
		Assert.notEmpty(conta, "Conta é obrigatória");
		Assert.hasText(cpf, "CPF é obrigatório");
		
		this.nome = nome;
		this.endereco = endereco;
		this.conta = conta;
		this.cpf = cpf;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public List<Endereco> getEndereco() {
		return endereco;
	}
	
	public List<Conta> getConta() {
		return conta;
	}
	
	public String getCpf() {
		return cpf;
	}
}
