package br.com.implant_rag_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.implant_rag_back.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {

	
}
