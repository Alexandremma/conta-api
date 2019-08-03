package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 60, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Endereco> endereco = new ArrayList<Endereco>();
	
//	@OneToMany(mappedBy = "cliente")
//	private List<Conta> conta;
	
	@Column(name = "cpf", length = 11, nullable = false, unique = true)
	private String cpf;
	
	protected Cliente() {}
	
	public Cliente(String nome, String cpf) {
		Assert.hasText(nome, "Nome é obrigatório");
		Assert.hasText(cpf, "CPF é obrigatório");
		Assert.isTrue(cpf.length() == 11, "CPF inválido");
		
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public void addEndereco(String logradouro, String numero, Cidade cidade, String cep, TipoEndereco tipoEndereco, String complemento) {
		Endereco endereco = new Endereco(this, logradouro, numero, cidade, cep, tipoEndereco, complemento);
		this.endereco.add(endereco);
	}
	
	public void addEnderecoCobranca(String logradouro, String numero, Cidade cidade, String cep, String complemento) {
		this.addEndereco(logradouro, numero, cidade, cep, TipoEndereco.Cobrança, complemento);
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
	
//	public List<Conta> getConta() {
//		return conta;
//	}
	
	public String getCpf() {
		return cpf;
	}
}
