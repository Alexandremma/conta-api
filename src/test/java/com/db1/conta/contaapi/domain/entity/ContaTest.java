package com.db1.conta.contaapi.domain.entity;

import org.junit.Test;
import org.mockito.Mockito;

import org.junit.Assert;

public class ContaTest {

	@Test
	public void deveRetornarAgenciaObrigatoria() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		try {
			Conta conta = new Conta(null, ContaTipo.Corrente, "1234", cliente, 100.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Agência é obrigatória", mensagem);
	}
	
	@Test
	public void deveRetornarTipoDaContaObrigatorio() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		Agencia agencia = Mockito.mock(Agencia.class);
		try {
			Conta conta = new Conta(agencia, null, "1234", cliente, 100.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Tipo da conta é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarNumeroObrigatorio() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		Agencia agencia = Mockito.mock(Agencia.class);
		try {
			Conta conta = new Conta(agencia, ContaTipo.Corrente, null, cliente, 100.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Número da conta é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarClienteObrigatorio() {
		String mensagem = null;
		Agencia agencia = Mockito.mock(Agencia.class);
		try {
			Conta conta = new Conta(agencia, ContaTipo.Corrente, "1234", null, 100.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Cliente é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarSaldoObrigatorio() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		Agencia agencia = Mockito.mock(Agencia.class);
		try {
			Conta conta = new Conta(agencia, ContaTipo.Corrente, "1234", cliente, null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Saldo é obrigatório", mensagem);
	}
	
	@Test
	public void deveCriarUmaInstanciaDeConta() {
		String mensagem = null;
		Agencia agencia = Mockito.mock(Agencia.class);
		Cliente cliente = Mockito.mock(Cliente.class);
		Conta conta = null;
		try {
			conta = new Conta(agencia, ContaTipo.Corrente, "1234", cliente, 100.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertNull(mensagem);
		Assert.assertEquals(agencia, conta.getAgencia());
		Assert.assertEquals(ContaTipo.Corrente, conta.getContaTipo());
		Assert.assertEquals("1234", conta.getNumero());
		Assert.assertEquals(cliente, conta.getCliente());
		Assert.assertEquals(100.0, conta.getSaldo(), 0.0);
	}
	
}
