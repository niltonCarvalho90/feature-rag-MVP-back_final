package br.com.implant_rag_back.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.implant_rag_back.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>  {

	List<Cliente> findByCodigo(Integer codigo);
	
	List<Cliente> findByNomeEmpresa(String nomeempresa); 


}
