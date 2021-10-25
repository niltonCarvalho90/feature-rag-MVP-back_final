package br.com.implant_rag_back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.implant_rag_back.domain.Operadora;
import br.com.implant_rag_back.repository.OperadoraRepository;

@Service
public class OperadoraService {

	private final OperadoraRepository operadoraRepository;

	@Autowired
	public OperadoraService(OperadoraRepository operadoraRepository) {
		this.operadoraRepository = operadoraRepository;
	}

	public Operadora salvar(Operadora operadora) {
		return operadoraRepository.save(operadora);
	}
}
