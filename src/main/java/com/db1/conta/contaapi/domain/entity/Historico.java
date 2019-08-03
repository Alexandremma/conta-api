package com.db1.conta.contaapi.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.util.Assert;

@Embeddable
public class Historico {
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_historico")
	private HistoricoTipo historicoTipo;
	
	@Column(name = "data", nullable = false, length = 30)
	private LocalDateTime data;
	
	@Column(name = "valor", nullable = false, precision = 14, scale = 2)
	private Double valor;
	
//	private Conta conta;
	
	@Column(name = "valor_resultante", nullable = false, precision = 14, scale = 2)
	private Double valorResultante;
	
	protected Historico() {}
	
	public Historico(HistoricoTipo historicoTipo, Double valor, Double valorResultante) {
		Assert.notNull(historicoTipo, "Tipo do histórico é obrigatório");
		Assert.notNull(valor, "Valor é obrigatório");
//		Assert.notNull(conta, "Conta é obrigatória");
		Assert.notNull(valorResultante, "Valor Resultante é obrigatório");
		
		this.historicoTipo = historicoTipo;
		this.data = LocalDateTime.now();
		this.valor = valor;
//		this.conta = conta;
		this.valorResultante = valorResultante;
	}
	
//	public Long getId() {
//		return id;
//	}
	
	public HistoricoTipo getHistoricoTipo() {
		return historicoTipo;
	}
	
	public LocalDateTime getData() {
		return data;
	}
	
	public Double getValor() {
		return valor;
	}
	
//	public Conta getConta() {
//		return conta;
//	}
	
	public Double getValorResultante() {
		return valorResultante;
	}
	
}
