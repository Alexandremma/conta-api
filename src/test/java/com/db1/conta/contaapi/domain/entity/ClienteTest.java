package com.db1.conta.contaapi.domain.entity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
public class ClienteTest {
	
	@Test
	public void deveRetornarNomeObrigatorio() {
		String mensagem = null;
		Cliente cliente = null;
		try {
			cliente = new Cliente(null, "99999999999");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Nome é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarCpfObrigatorio() {
		String mensagem = null;
		Cliente cliente = null;
		try {
			cliente = new Cliente("Nome", null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("CPF é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarCpfInvalido() {
		String mensagem = null;
		Cliente cliente = null;
		try {
			cliente = new Cliente("Nome", "999999999912");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("CPF inválido", mensagem);
	}
	
	@Test
	public void deveCriarUmaInstanciaDeCliente() {
		String mensagem = null;
		Cliente cliente = null;
		try {
			cliente = new Cliente("Nome", "99999999999");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertNull(mensagem);
		Assert.assertEquals("Nome", cliente.getNome());
		Assert.assertEquals("99999999999", cliente.getCpf());
	}
	
}
