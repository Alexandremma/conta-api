package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AgenciaTest {
	
	@Test
	public void deveRetornarNumeroObrigatorio() {
		String mensagem = null;
		try {
			Cidade cidade = Mockito.mock(Cidade.class);
			Agencia agencia = new Agencia(null, "6", cidade);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Número é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarDigitoObrigatorio() {
		String mensagem = null;
		try {
			Cidade cidade = Mockito.mock(Cidade.class);
			Agencia agencia = new Agencia("12345", null, cidade);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Dígito é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarCidadeObrigatoria() {
		String mensagem = null;
		try {
			Agencia agencia = new Agencia("12345", "6", null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Cidade é obrigatória", mensagem);
	}
	
	@Test
	public void deveCriarUmaInstanciaDeAgencia() {
		String mensagem = null;
		Cidade cidade = Mockito.mock(Cidade.class);
		Agencia agencia = null;
		try {
			agencia = new Agencia("12345", "6", cidade);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertNull(mensagem);
		Assert.assertEquals("12345", agencia.getNumero());
		Assert.assertEquals("6", agencia.getDigito());
		Assert.assertEquals(cidade, agencia.getCidade());
	}
	
}
