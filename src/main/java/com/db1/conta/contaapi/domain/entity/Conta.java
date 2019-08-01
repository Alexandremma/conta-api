package com.db1.conta.contaapi.domain.entity;

import java.util.List;

import org.springframework.util.Assert;

public class Conta {

	private Long id;
	
	private Agencia agencia;
	
	private ContaTipo contaTipo;
	
	private String numero;
	
	private Cliente cliente;
	
	private Double saldo;
	
	private List<Historico> historicoDaConta;
	
	public Conta(Agencia agencia, ContaTipo contaTipo, String numero, Cliente cliente, Double saldo) {
		Assert.notNull(agencia, "Agência é obrigatória");
		Assert.notNull(contaTipo, "Tipo da conta é obrigatório");
		Assert.hasText(numero, "Número da conta é obrigatório");
		Assert.notNull(cliente, "Cliente é obrigatório");
		Assert.notNull(saldo, "Saldo é obrigatório");
	
		this.agencia = agencia;
		this.contaTipo = contaTipo;
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = saldo;
	}
	
	public Long getId() {
		return id;
	}
	
	public Agencia getAgencia() {
		return agencia;
	}
	
	public ContaTipo getContaTipo() {
		return contaTipo;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public List<Historico> getHistoricoDaConta() {
		return historicoDaConta;
	}
	
}
