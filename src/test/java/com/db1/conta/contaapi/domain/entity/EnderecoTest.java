package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class EnderecoTest {
	
	@Test
	public void deveRetornarClienteObrigatorio() {
		String mensagem = null;
		Cidade cidade = Mockito.mock(Cidade.class);
		try {
			Endereco endereco = new Endereco(null, "log", "num", cidade, "87010055", TipoEndereco.Residencial, "Comp");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Cliente é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarLogradouroObrigatorio() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		try {
			Endereco endereco = new Endereco(cliente, null, "num", cidade, "87010055", TipoEndereco.Residencial, "Comp");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Logradouro é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarNumeroObrigatorio() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		try {
			Endereco endereco = new Endereco(cliente, "log", null, cidade, "87010055", TipoEndereco.Residencial, "Comp");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Número é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarCidadeObrigatorio() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		try {
			Endereco endereco = new Endereco(cliente, "log", "num", null, "87010055", TipoEndereco.Residencial, "Comp");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Cidade é obrigatória", mensagem);
	}
	
	@Test
	public void deveRetornarCepObrigatorio() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		try {
			Endereco endereco = new Endereco(cliente, "log", "num", cidade, null, TipoEndereco.Residencial, "Comp");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("CEP é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarTipoEnderecoObrigatorio() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		try {
			Endereco endereco = new Endereco(cliente, "log", "num", cidade, "87010055", null, "Comp");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Tipo do endereço é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarComplementoObrigatorio() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		try {
			Endereco endereco = new Endereco(cliente, "log", "num", cidade, "87010055", TipoEndereco.Residencial, null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Complemento é obrigatório", mensagem);
	}
	
	@Test
	public void deveCriarUmaInstanciaDeEndereco() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		Endereco endereco = null;
		try {
			endereco = new Endereco(cliente, "log", "num", cidade, "87010055", TipoEndereco.Cobrança, "comp");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertNull(mensagem);
		Assert.assertEquals(cliente, endereco.getCliente());
		Assert.assertEquals("log", endereco.getLogradouro());
		Assert.assertEquals("num", endereco.getNumero());
		Assert.assertEquals(cidade, endereco.getCidade());
		Assert.assertEquals("87010055", endereco.getCep());
		Assert.assertEquals(TipoEndereco.Cobrança, endereco.getTipoEndereco());
		Assert.assertEquals("comp", endereco.getComplemento());
	}
	
}
