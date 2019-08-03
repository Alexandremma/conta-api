package com.db1.conta.contaapi.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Cliente;
import com.db1.conta.contaapi.domain.entity.Endereco;
import com.db1.conta.contaapi.domain.entity.Estado;
import com.db1.conta.contaapi.domain.entity.TipoEndereco;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnderecoRepositoryTest {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired CidadeRepository cidadeRepository;
	
	@After
	public void afterTest() {
		enderecoRepository.deleteAll();
		clienteRepository.deleteAll();
		cidadeRepository.deleteAll();
	}
	
	@Test
	public void deveSalvarUmEndereco() {
		Cliente cliente = new Cliente("Alexandre", "10849393981");
		clienteRepository.save(cliente);
		
		Cidade cidade = new Cidade("Indianópolis", Estado.PR);
		cidadeRepository.save(cidade);
		
		Endereco endereco = new Endereco(cliente, "logradouro", "1234", cidade, "87010055", TipoEndereco.Cobrança, "complemento");
		Endereco enderecoSalvo = enderecoRepository.save(endereco);
		
		Assert.assertNotNull(enderecoSalvo.getId());
		Assert.assertEquals(endereco.getCliente(), enderecoSalvo.getCliente());
		Assert.assertEquals(endereco.getLogradouro(), enderecoSalvo.getLogradouro());
		Assert.assertEquals(endereco.getNumero(), enderecoSalvo.getNumero());
		Assert.assertEquals(endereco.getCidade(), enderecoSalvo.getCidade());
		Assert.assertEquals(endereco.getCep(), enderecoSalvo.getCep());
		Assert.assertEquals(endereco.getTipoEndereco(), enderecoSalvo.getTipoEndereco());
		Assert.assertEquals(endereco.getComplemento(), enderecoSalvo.getComplemento());
	}
	
}
