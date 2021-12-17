package br.com.implant_rag_back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.implant_rag_back.domain.Cliente;
import br.com.implant_rag_back.domain.Filial;
import br.com.implant_rag_back.repository.FilialRepository;

@Service
public class FilialService {

	@Autowired
	private FilialRepository filialRepository;

	public Filial cadastrar(Filial filial) {
		return filialRepository.save(filial);
	}

	public void remover(Long id) {
		filialRepository.deleteById(id);

	}

	public Filial alterar(Filial filial) {
		return filialRepository.save(filial);
	}

	public List<Filial> listarDadosFixos() {
		List<Filial> lista = filialRepository.mostrarDadosFixos();

		return lista;
	}
	
	public List<Filial> listarDados() {
		List<Filial> lista = filialRepository.mostrarDados();

		return lista;
	}

	public Long returnId() {
		List<Filial> lista = filialRepository.mostrarDadosFixos();
		return lista.get(lista.size()).getId();
	}

	public List<Filial> encontrarTodos() {
		List<Filial> lista = filialRepository.mostrarDadosFixos();
		return lista;
	}

	public List<Filial> listarFiliaisDoCliente(Cliente cliente) {
		List<Filial> lista = filialRepository.mostrarFiliaisDoCliente(cliente);
		return lista;
	}
	
	public List<Filial> listarFilialPorCliente(Integer codigo){
		return this.filialRepository.findByClienteByCodigo(codigo);
	}
}
