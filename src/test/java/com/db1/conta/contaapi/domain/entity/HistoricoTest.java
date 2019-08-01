package com.db1.conta.contaapi.domain.entity;

import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.Mockito;

import org.junit.Assert;

public class HistoricoTest {
	
	@Test
	public void deveRetornarTipoDoHistoricoObrigatorio() {
		String mensagem = null;
		LocalDateTime now = LocalDateTime.now();
		Conta conta = Mockito.mock(Conta.class);
		try {
			Historico historico = new Historico(null, now, 100.0, conta, 200.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Tipo do histórico é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarDataObrigatoria() {
		String mensagem = null;
		Conta conta = Mockito.mock(Conta.class);
		try {
			Historico historico = new Historico(HistoricoTipo.Entrada, null, 100.0, conta, 200.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Data é obrigatória", mensagem);
	}
	
	@Test
	public void deveRetornarValorObrigatorio() {
		String mensagem = null;
		LocalDateTime now = LocalDateTime.now();
		Conta conta = Mockito.mock(Conta.class);
		try {
			Historico historico = new Historico(HistoricoTipo.Entrada, now, null, conta, 200.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Valor é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarContaObrigatoria() {
		String mensagem = null;
		LocalDateTime now = LocalDateTime.now();
		try {
			Historico historico = new Historico(HistoricoTipo.Entrada, now, 100.0, null, 200.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Conta é obrigatória", mensagem);
	}
	
	@Test
	public void deveRetornarValorResultanteObrigatorio() {
		String mensagem = null;
		LocalDateTime now = LocalDateTime.now();
		Conta conta = Mockito.mock(Conta.class);
		try {
			Historico historico = new Historico(HistoricoTipo.Entrada, now, 100.0, conta, null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Valor Resultante é obrigatório", mensagem);
	}
	
	@Test
	public void deveCriarUmaInstanciaDeHistorico() {
		String mensagem = null;
		LocalDateTime now = LocalDateTime.now();
		Conta conta = Mockito.mock(Conta.class);
		Historico historico = null;
		try {
			historico = new Historico(HistoricoTipo.Entrada, now, 100.0, conta, 200.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertNull(mensagem);
		Assert.assertEquals(HistoricoTipo.Entrada, historico.getHistoricoTipo());
		Assert.assertEquals(now, historico.getData());
		Assert.assertEquals(100.0, historico.getValor(), 0.0);
		Assert.assertEquals(conta, historico.getConta());
	}
}
