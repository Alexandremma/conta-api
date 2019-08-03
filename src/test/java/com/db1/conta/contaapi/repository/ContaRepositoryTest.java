package com.db1.conta.contaapi.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.conta.contaapi.domain.entity.Agencia;
import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Cliente;
import com.db1.conta.contaapi.domain.entity.Conta;
import com.db1.conta.contaapi.domain.entity.ContaTipo;
import com.db1.conta.contaapi.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContaRepositoryTest {

	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@After
	public void afterTest() {
		contaRepository.deleteAll();
		agenciaRepository.deleteAll();
		cidadeRepository.deleteAll();
		clienteRepository.deleteAll();
	}
	
	@Test
	public void deveSalvarUmaConta() {
		Cidade cidadeSalva = cidadeRepository.save(new Cidade("Campo Grande", Estado.PR));
		Agencia agenciaSalva = agenciaRepository.save(new Agencia("2134", "6", cidadeSalva));
		Cliente clienteSalvo = clienteRepository.save(new Cliente("Client Nome", "99849393981"));
		
		Conta conta = new Conta(agenciaSalva, ContaTipo.Corrente, "1234", clienteSalvo);
		Conta contaSalva = contaRepository.save(conta);
	
		Assert.assertNotNull(contaSalva.getId());
		Assert.assertEquals(conta.getNumero(), contaSalva.getNumero());
	}
	
	@Test
	public void deveSalvarDepositoEmConta() {
		Cidade cidadeSalva = cidadeRepository.save(new Cidade("Maringá", Estado.PR));
		Agencia agenciaSalva = agenciaRepository.save(new Agencia("1324", "5", cidadeSalva));
		Cliente clienteSalvo = clienteRepository.save(new Cliente("Roberto", "10949399391"));
		
		Conta conta = new Conta(agenciaSalva, ContaTipo.Corrente, "1234", clienteSalvo);
		conta.depositar(50.0);
		Conta contaSalva = contaRepository.save(conta);
		
		Assert.assertNotNull(contaSalva.getId());
		Assert.assertEquals(conta.getNumero(), contaSalva.getNumero());
		Assert.assertEquals(50.0, contaSalva.getSaldo(), 0.0);
		Assert.assertEquals(1, contaSalva.getHistoricoDaConta().size());
	}
	
}
