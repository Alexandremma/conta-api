package com.db1.conta.contaapi.repository;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.conta.contaapi.domain.entity.Agencia;
import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgenciaRepositoryTest {

	@Autowired
	private AgenciaRepository agenciaRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@After
	public void afterTest() {
		agenciaRepository.deleteAll();
		cidadeRepository.deleteAll();
	}
	
	@Test
	public void deveSalvarUmaAgencia() {
		Cidade cidade = new Cidade("Maringá", Estado.PR);
		cidadeRepository.save(cidade);
		
		Agencia agencia = new Agencia("1234", "5", cidade);
		Agencia agenciaSalva = agenciaRepository.save(agencia);
		
		Assert.assertNotNull(agenciaSalva.getId());
		Assert.assertEquals(agencia.getNumero(), agenciaSalva.getNumero());
		Assert.assertEquals(agencia.getDigito(), agenciaSalva.getDigito());
		Assert.assertEquals(cidade.getId(), agenciaSalva.getCidade().getId());
	}
	
	@Test
	public void deveRetornarAgenciaPorNumero() {
		Cidade cidade = new Cidade("Maringá", Estado.PR);
		cidadeRepository.save(cidade);
		
		Agencia agencia = new Agencia("1234", "5", cidade);
		agenciaRepository.save(agencia);
		
		Agencia agenciaBuscadaPorNumero = agenciaRepository.findByNumero("1234");
		
		Assert.assertNotNull(agenciaBuscadaPorNumero);
		Assert.assertEquals(agencia.getNumero(), agenciaBuscadaPorNumero.getNumero());
		Assert.assertEquals(agencia.getDigito(), agenciaBuscadaPorNumero.getDigito());
		Assert.assertEquals(cidade.getId(), agenciaBuscadaPorNumero.getCidade().getId());
	}
	
	@Test
	public void deveRetornarAgenciasPorEstado() {
		Cidade cidade = new Cidade("Maringá", Estado.PR);
		cidadeRepository.save(cidade);
		
		Agencia agencia = new Agencia("1234", "5", cidade);
		agenciaRepository.save(agencia);
		
		List<Agencia> agencias = agenciaRepository.findByCidadeEstado(Estado.PR);
		
		Assert.assertEquals(1, agencias.size());
	}
	
}
