package com.db1.conta.contaapi.domain.entity;

import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.Mockito;

import org.junit.Assert;

public class HistoricoTest {
	
	@Test
	public void deveRetornarTipoDoHistoricoObrigatorio() {
		String mensagem = null;
		Conta conta = Mockito.mock(Conta.class);
		try {
			Historico historico = new Historico(null, 100.0, 200.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Tipo do histórico é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarValorObrigatorio() {
		String mensagem = null;
		Conta conta = Mockito.mock(Conta.class);
		try {
			Historico historico = new Historico(HistoricoTipo.Entrada, null, 200.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Valor é obrigatório", mensagem);
	}
	
//	@Test
//	public void deveRetornarContaObrigatoria() {
//		String mensagem = null;
//		LocalDateTime now = LocalDateTime.now();
//		try {
//			Historico historico = new Historico(HistoricoTipo.Entrada, now, 100.0, null, 200.0);
//		} catch (Exception e) {
//			mensagem = e.getMessage();
//		}
//		
//		Assert.assertEquals("Conta é obrigatória", mensagem);
//	}
	
	@Test
	public void deveRetornarValorResultanteObrigatorio() {
		String mensagem = null;
		Conta conta = Mockito.mock(Conta.class);
		try {
			Historico historico = new Historico(HistoricoTipo.Entrada, 100.0, null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Valor Resultante é obrigatório", mensagem);
	}
	
	@Test
	public void deveCriarUmaInstanciaDeHistorico() {
		String mensagem = null;
		Conta conta = Mockito.mock(Conta.class);
		Historico historico = null;
		try {
			historico = new Historico(HistoricoTipo.Entrada, 100.0, 200.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertNull(mensagem);
		Assert.assertEquals(HistoricoTipo.Entrada, historico.getHistoricoTipo());
		Assert.assertEquals(100.0, historico.getValor(), 0.0);
	}
}
