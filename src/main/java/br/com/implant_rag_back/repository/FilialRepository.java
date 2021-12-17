package br.com.implant_rag_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.implant_rag_back.domain.Cliente;
import br.com.implant_rag_back.domain.Filial;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Long> {

	@Query(value = "SELECT new Filial(razaoSocial, cnpj, apelidoLoja, codErp) FROM Filial")
	List<Filial> mostrarDadosFixos();
	
	@Query(value = "SELECT u FROM Filial u")
	List<Filial> mostrarDados();

	@Query(value = "SELECT u FROM Filial u where u.cliente = :cliente")
	List<Filial> mostrarFiliaisDoCliente(@Param("cliente") Cliente cliente);
	
	@Query(value = "SELECT u FROM Filial u where u.cliente.codigo = :codigo")
	List<Filial> findByClienteByCodigo(@Param ("codigo") Integer codigo);
		

	
}
