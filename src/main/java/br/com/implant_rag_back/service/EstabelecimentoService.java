package br.com.implant_rag_back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.implant_rag_back.domain.Estabelecimento;
import br.com.implant_rag_back.domain.Filial;
import br.com.implant_rag_back.repository.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {

	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;

	public Estabelecimento salvar(Estabelecimento estabelecimento) {
		return estabelecimentoRepository.save(estabelecimento);
	}

	public List<Estabelecimento> listar() {
		
		return estabelecimentoRepository.findAll();

	}
	public List<Estabelecimento> listarOperadoraDoCliente(Filial filial) {

		return estabelecimentoRepository.mostrarOperadoraDoCliente(filial);

	}


}
