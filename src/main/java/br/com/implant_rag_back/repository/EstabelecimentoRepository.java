package br.com.implant_rag_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.implant_rag_back.domain.Estabelecimento;
import br.com.implant_rag_back.domain.Filial;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {

	@Query(value = "SELECT u FROM Estabelecimento u")
	List<Estabelecimento> listarEstabelecimentos();
	
	
	@Query(value = "SELECT u FROM Estabelecimento u where u.filial = :filial")
	List<Estabelecimento> mostrarOperadoraDoCliente(@Param("filial") Filial filial);

	
}
