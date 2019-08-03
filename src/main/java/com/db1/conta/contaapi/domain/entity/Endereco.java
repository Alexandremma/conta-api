package com.db1.conta.contaapi.domain.entity;

import javax.persistence.Column;
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

@Entity
@Table(name = "endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
	@Column(name = "logradouro", length = 60, nullable = false)
	private String logradouro;
	
	@Column(name = "numero", length = 20, nullable = false)
	private String numero;
	
	@ManyToOne
	@JoinColumn(name = "cidade_id", nullable = false)
	private Cidade cidade;
	
	@Column(name = "cep", length = 8, nullable = false)
	private String cep;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_endereco", length = 11, nullable = false)
	private TipoEndereco tipoEndereco;
	
	@Column(name = "complemento", length = 100)
	private String complemento;
	
	protected Endereco() {}
	
	public Endereco(Cliente cliente, String logradouro, String numero, Cidade cidade, String cep, TipoEndereco tipoEndereco, String complemento) {
		Assert.notNull(cliente, "Cliente é obrigatório");
		Assert.hasText(logradouro, "Logradouro é obrigatório");
		Assert.hasText(numero, "Número é obrigatório");
		Assert.notNull(cidade, "Cidade é obrigatória");
		Assert.hasText(cep, "CEP é obrigatório");
		Assert.isTrue(cep.length() == 8, "CEP inválido");
		Assert.notNull(tipoEndereco, "Tipo do endereço é obrigatório");
	
		this.cliente = cliente;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.cep = cep;
		this.tipoEndereco = tipoEndereco;
		this.complemento = complemento;
	}
	
	public Long getId() {
		return id;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	
	public String getCep() {
		return cep;
	}
	
	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
}
