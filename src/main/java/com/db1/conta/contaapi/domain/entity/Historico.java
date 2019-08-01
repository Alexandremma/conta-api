package com.db1.conta.contaapi.domain.entity;

import java.time.LocalDateTime;

import org.springframework.util.Assert;

public class Historico {
	
	private Long id;
	
	private HistoricoTipo historicoTipo;
	
	private LocalDateTime data;
	
	private Double valor;
	
	private Conta conta;
	
	private Double valorResultante;
	
	public Historico(HistoricoTipo historicoTipo, LocalDateTime data, Double valor, Conta conta, Double valorResultante) {
		Assert.notNull(historicoTipo, "Tipo do histórico é obrigatório");
		Assert.notNull(data, "Data é obrigatória");
		Assert.notNull(valor, "Valor é obrigatório");
		Assert.notNull(conta, "Conta é obrigatória");
		Assert.notNull(valorResultante, "Valor Resultante é obrigatório");
		
		this.historicoTipo = historicoTipo;
		this.data = data;
		this.valor = valor;
		this.conta = conta;
		this.valorResultante = valorResultante;
	}
	
	public Long getId() {
		return id;
	}
	
	public HistoricoTipo getHistoricoTipo() {
		return historicoTipo;
	}
	
	public LocalDateTime getData() {
		return data;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public Conta getConta() {
		return conta;
	}
	
	public Double getValorResultante() {
		return valorResultante;
	}
	
}
