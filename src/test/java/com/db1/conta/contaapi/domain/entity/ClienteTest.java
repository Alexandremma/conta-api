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
			cliente = new Cliente(null, "10849393981");
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
	public void deveCriarUmaInstanciaDeCliente() {
		String mensagem = null;
		Cliente cliente = null;
		try {
			cliente = new Cliente("Nome", "10849393981");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertNull(mensagem);
		Assert.assertEquals("Nome", cliente.getNome());
		Assert.assertEquals("10849393981", cliente.getCpf());
	}
	
}
