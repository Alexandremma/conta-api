package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.Assert;

import com.db1.conta.contaapi.infra.Verificadora;

@Entity
@Table(name = "conta")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "agencia_id", nullable = false)
	private Agencia agencia;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_conta", length = 10, nullable = false)
	private ContaTipo contaTipo;
	
	@Column(name = "numero", length = 20, nullable = false, unique = true)
	private String numero;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
	@Column(name = "saldo", length = 20, nullable = false)
	private Double saldo;
	
	@ElementCollection
    @CollectionTable(name="historico_conta", joinColumns=@JoinColumn(name="conta_id"))
	private List<Historico> historicoDaConta = new ArrayList<Historico>();
	
	protected Conta() {}
	
	public Conta(Agencia agencia, ContaTipo contaTipo, String numero, Cliente cliente) {
		Assert.notNull(agencia, "Agência é obrigatória");
		Assert.notNull(contaTipo, "Tipo da conta é obrigatório");
		Assert.hasText(numero, "Número da conta é obrigatório");
		Assert.notNull(cliente, "Cliente é obrigatório");
//		Assert.notNull(saldo, "Saldo é obrigatório");
	
		this.agencia = agencia;
		this.contaTipo = contaTipo;
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = 0.0;
	}
	
	public void depositar(Double valor) {
		Verificadora.verificaValorMaiorQueZero(valor, "Valor a ser depositado deve ser maior que zero");
		
		this.saldo += valor;
		this.historicoDaConta.add(new Historico(HistoricoTipo.Entrada, valor, this.saldo));
	}
	
	public void sacar(Double valor) {
		Verificadora.verificaValorMaiorQueZero(valor, "Valor a ser sacado deve ser maior que zero");
		Verificadora.verificaValorMaiorQueZero(this.saldo - valor, "Saldo insuficiente");
		
		this.saldo -= valor;
		this.historicoDaConta.add(new Historico(HistoricoTipo.Saida, valor, this.saldo));
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
