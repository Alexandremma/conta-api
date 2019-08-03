package com.db1.conta.contaapi.infra;

import org.junit.Assert;
import org.junit.Test;

public class VerificadoraTest {

	@Test
	public void deveRetornarExceptionQuandoValorNulo() {
		String mensagem = null;
		try {
			Verificadora.verificaValorMaiorQueZero(null, "Valor depositado deve ser válido");
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Valor depositado deve ser válido", mensagem);
	}
	
	@Test
	public void deveRetornarExceptionQuandoValorZero() {
		String mensagem = null;
		try {
			Verificadora.verificaValorMaiorQueZero(0.0, "Valor depositado deve ser maior que zero");
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Valor depositado deve ser maior que zero", mensagem);
	}
	
	@Test
	public void deveRetornarExceptionQuandoValorNegativo() {
		String mensagem = null;
		try {
			Verificadora.verificaValorMaiorQueZero(-0.1, "Valor depositado deve ser positivo");
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Valor depositado deve ser positivo", mensagem);
	}
	
	@Test
	public void naoDeveRetornarExceptionQuandoValorPositivo() {
		String mensagem = null;
		try {
			Verificadora.verificaValorMaiorQueZero(50.0, null);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals(null, mensagem);
	}
	
}
