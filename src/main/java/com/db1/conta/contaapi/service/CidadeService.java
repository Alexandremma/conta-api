package com.db1.conta.contaapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1.conta.contaapi.adapter.CidadeAdapter;
import com.db1.conta.contaapi.domain.dto.CidadePersistDTO;
import com.db1.conta.contaapi.domain.dto.CidadeResponseDTO;
import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public CidadeResponseDTO save(CidadePersistDTO dto) {
		Cidade cidade = new Cidade(dto.getNome(), dto.getEstado());
		cidadeRepository.save(cidade);
		return CidadeAdapter.entityToResponse(cidade);
	}
	
	public CidadeResponseDTO update(Long cidadeId, CidadePersistDTO dto) {
		Optional<Cidade> opCidade = cidadeRepository.findById(cidadeId);
		if (opCidade.isPresent()) {
			Cidade cidade = opCidade.get();
			cidade.alterar(dto.getNome(), dto.getEstado());
			cidadeRepository.save(cidade);
			return CidadeAdapter.entityToResponse(cidade);
		}
		throw new RuntimeException("Cidade de ID " + cidadeId + " não encontrada");
	}
	
	public CidadeResponseDTO delete(Long cidadeId, CidadePersistDTO dto) {
		Optional<Cidade> opCidade = cidadeRepository.findById(cidadeId);
		if (opCidade.isPresent()) {
			Cidade cidade = opCidade.get();
			cidadeRepository.delete(cidade);
		}
		throw new RuntimeException("Cidade de ID " + cidadeId + " não encontrada");
	}
	
	public List<CidadeResponseDTO> getCidades() {
		List<CidadeResponseDTO> listCidadesResponse = new ArrayList<>();
		List<Cidade> listCidades = cidadeRepository.findAll();
		for (Cidade cidade : listCidades) {
		 	CidadeResponseDTO cidadeResponse = CidadeAdapter.entityToResponse(cidade);
			listCidadesResponse.add(cidadeResponse);
		}
		return listCidadesResponse;
	}
	
	public CidadeResponseDTO findCidadeById(Long cidadeId, CidadePersistDTO dto) {
		Optional<Cidade> opCidade = cidadeRepository.findById(cidadeId);
		if (opCidade.isPresent()) {
			Cidade cidade = opCidade.get();
			return CidadeAdapter.entityToResponse(cidade);
		}
		throw new RuntimeException("Cidade de ID " + cidadeId + " não encontrada");
	}
	
	public CidadeResponseDTO findCidadeByName(String cidadeNome, CidadePersistDTO dto) {
		Optional<Cidade> opCidade = cidadeRepository.findByNomeOptional(cidadeNome);
		if (opCidade.isPresent()) {
			Cidade cidade = opCidade.get();
			return CidadeAdapter.entityToResponse(cidade);
		}
		throw new RuntimeException("Cidade de nome " + cidadeNome + " não encontrada");
	}
}
