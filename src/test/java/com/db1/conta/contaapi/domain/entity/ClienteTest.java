package com.db1.conta.contaapi.domain.entity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
public class ClienteTest {
	
	@Test
	public void deveRetornarNomeObrigatorio() {
		String mensagem = null;
		List<Endereco> endereco = new ArrayList<Endereco>(); 
		List<Conta> conta = new ArrayList<Conta>();
		Cliente cliente = null;
		try {
			cliente = new Cliente(null, endereco, conta, "10849393981");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Nome é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarEnderecoObrigatorio() {
		String mensagem = null; 
		List<Conta> conta = new ArrayList<Conta>();
		Cliente cliente = null;
		try {
			cliente = new Cliente("Nome", null, conta, "10849393981");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Endereço é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarContaObrigatoria() {
		String mensagem = null;
		List<Endereco> endereco = new ArrayList<Endereco>(); 
		Cliente cliente = null;
		try {
			cliente = new Cliente("Nome", endereco, null, "10849393981");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Conta é obrigatória", mensagem);
	}
	
	@Test
	public void deveRetornarCpfObrigatorio() {
		String mensagem = null;
		List<Endereco> endereco = new ArrayList<Endereco>();
		List<Conta> conta = new ArrayList<Conta>();
		Cliente cliente = null;
		try {
			cliente = new Cliente("Nome", endereco, conta, null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("CPF é obrigatório", mensagem);
	}
	
	@Test
	public void deveCriarUmaInstanciaDeCliente() {
		String mensagem = null;
		List<Endereco> endereco = new ArrayList<Endereco>();
		List<Conta> conta = new ArrayList<Conta>();
		Cliente cliente = null;
		try {
			cliente = new Cliente("Nome", endereco, conta, "10849393981");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertNull(mensagem);
		Assert.assertEquals("Nome", cliente.getNome());
		Assert.assertEquals(endereco, cliente.getEndereco());
		Assert.assertEquals(conta, cliente.getConta());
		Assert.assertEquals("10849393981", cliente.getCpf());
	}
	
}
