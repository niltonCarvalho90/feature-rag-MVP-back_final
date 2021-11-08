package br.com.implant_rag_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.implant_rag_back.domain.Operadora;

@Repository
public interface OperadoraRepository extends JpaRepository<Operadora, Long>  {

	@Query(value = "SELECT u FROM Operadora u WHERE trim(u.nome) LIKE %?1%")
    List<Operadora> buscarOperadoraNome(String nome);
	
}
